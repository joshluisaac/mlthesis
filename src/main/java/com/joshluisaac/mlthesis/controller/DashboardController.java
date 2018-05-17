package com.joshluisaac.mlthesis.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.joshluisaac.mlthesis.component.ComponentProvider;
import com.joshluisaac.mlthesis.component.PandaDescribeReader;
import com.joshluisaac.mlthesis.component.PredictedCsvProcessor;
import com.joshluisaac.mlthesis.component.WorkloadProcessor;
import com.joshluisaac.mlthesis.entity.GaussianMetrics;
import com.joshluisaac.mlthesis.entity.RegressionMetrics;

@Controller
public class DashboardController {
  
  @Autowired
  ComponentProvider comp;
  
  @Autowired
  PandaDescribeReader pandaDesc;
  
  @Autowired
  PredictedCsvProcessor pred;
  
  @Autowired
  WorkloadProcessor workload;
  
  @GetMapping(value = "/")
  public Object getDashBoardHome() throws IOException {
    comp.textToVec("/media/joshua/martian/staffworkspace/phd-thesis/datafiles/");
    return "home";
  }
  
  @GetMapping(value="/regressionml")
  @ResponseBody
  public Object getRegressionMetrics() {
    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.getForObject("http://localhost:9099", String.class);
  }
  
  
  @GetMapping(value="/gaussianmodel")
  //@ResponseBody
  public Object gaussianmodel(Model model) {

    //model.addAttribute("metrics", gaussian);
    model.addAttribute("pandaDescribe", pandaDesc.read("gaussian_train.json"));
    model.addAttribute("accuracy", pandaDesc.readAccurracy("gnb_train_stats.json"));
    model.addAttribute("title", "Gaussian Classification - Model Training");
    
    return "gaussianmodel";
    //System.out.println("Got here...");
    //return gaussian.toString();
  }
  
  @GetMapping(value="/gaussianml")
  //@ResponseBody
  public Object getClassificationMetrics(Model model) {
    RestTemplate restTemplate = new RestTemplate();
    System.out.println("Printing....");
    GaussianMetrics gaussian = null;;
    
    try {
      gaussian  =  restTemplate.getForObject("http://localhost:9099/gaussian", GaussianMetrics.class);
    } catch (RestClientException e) {
      e.printStackTrace();
    }
    
    model.addAttribute("metrics", gaussian);
    model.addAttribute("pandaDescribe", pandaDesc.read("gaussian_pred.json"));
    model.addAttribute("title", "Gaussian Classification -  Detecting Anomalous Records In Customer Invoices");
    
    List<Integer> predList = pred.process();
    
    int valid = predList.get(0);
    int invalid = predList.get(1);
    int invaliddefault = predList.get(2);
    
    model.addAttribute("predvalid", valid);
    model.addAttribute("predinvalid", invalid);
    model.addAttribute("predinvalidloaddef", invaliddefault);
    
    int totalInvoices = valid + invalid + invaliddefault;
    
    model.addAttribute("totalinvoices", totalInvoices);
    
    return "gaussian";
    //System.out.println("Got here...");
    //return gaussian.toString();
  }
  
  @GetMapping(value="/linearregresmodel")
  //@ResponseBody
  public Object getLinearRegres(Model model) {
    RestTemplate restTemplate = new RestTemplate();
    RegressionMetrics regres = null;;
    
    try {
      regres  =  restTemplate.getForObject("http://localhost:9099/regression", RegressionMetrics.class);
    } catch (RestClientException e) {
      e.printStackTrace();
    }
    
    model.addAttribute("metrics", regres);
    model.addAttribute("workload", workload.process());
    model.addAttribute("pandaDescribe", pandaDesc.readWorkload("workload_pred.json"));
    model.addAttribute("title", "Univariate Linear Regression - Model Training");
    return "linearregresmodel";
  }
  

}
