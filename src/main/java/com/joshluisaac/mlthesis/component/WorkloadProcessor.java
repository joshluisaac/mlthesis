package com.joshluisaac.mlthesis.component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.joshluisaac.mlthesis.entity.Workload;
import com.kollect.etl.util.FileUtils;

@Component
public class WorkloadProcessor {

  
  
  
  public List<Workload> process() {
    List<Workload> workload = new ArrayList<>();
    FileUtils utils = new FileUtils();
    
    try {
      List<String> list = utils.readFile(new File("/media/joshua/martian/staffworkspace/mlthesis/out/workload_prediction_data.csv"));
      
      for(int i = 0; i < list.size(); i++) {
        String[] s = list.get(i).split("\\|");
        
//        String recs = s[0];
//        String rt = s[1];
//        String tps = s[1];
//        
        double recs = Double.parseDouble(s[0]);
        double rt =Double.parseDouble(s[1]);
        double tps =Double.parseDouble(s[2]);
        
        double pred = (-0.022f * tps) + 92.55 + 3.99;
        
        double variance = rt - pred;
        
        Workload w = new Workload();
        w.setNumberOfRecords(recs);
        w.setRunningTime(rt);
        w.setThruputpersec(tps);
        w.setPredtpps(pred);
        w.setVariance(variance);
        workload.add(w);
        
        //System.out.println(w);
      }
      
      
      
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    return workload;
    
  }
  
  
  public static void main(String[] args) {
    WorkloadProcessor w = new WorkloadProcessor();
    w.process();
  }
  
}
