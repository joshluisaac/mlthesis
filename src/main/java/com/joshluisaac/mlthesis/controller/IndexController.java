package com.joshluisaac.mlthesis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joshluisaac.mlthesis.service.OnboardingService;

@Controller
public class IndexController {
  
  //dependency injection
  
  @Autowired
  OnboardingService serv;
  

  
  /**
   * HTTP GET request to serve onboarding page
   * @param customerName
   * @param customerAge
   * 
   * @return returns the onboarding page
   */
  
  @GetMapping(value="/onboarding")
  public String getOnboarding(String customerName, Integer age) {
    customerName = "Johnson";
    boolean ageChecker = serv.customerAgeChecker(age);
    
    if(ageChecker) System.out.println("Agechecker is true");
    
    return "onboarding";
  }
  
  
  /**
   * It does some processing checks the customer name and age and redirects to onboarding ctrl
   * 
   * @param customerName
   * @param age
   * 
   * @return redirection URL
   * 
   */
  
  @PostMapping(value="/updateCustomer")
  public String updateCustomerNameAndAge(@RequestParam(required=false) String customerName, @RequestParam Integer age) {
    System.out.println("This is the customers name: " + customerName);
    System.out.println("Customers age: " + age);
    
    return "redirect:/onboarding?customerName=" + customerName +"&age=" + age;
  }


}
