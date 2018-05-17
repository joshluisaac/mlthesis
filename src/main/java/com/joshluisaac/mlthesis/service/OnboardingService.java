package com.joshluisaac.mlthesis.service;

import org.springframework.stereotype.Service;

@Service
public class OnboardingService {
  
  
  public boolean customerAgeChecker(Integer age) {
    boolean isOlder = false;
    if (age > 29) {
      System.out.println("Customer is older than 29");
      isOlder = true;
    } else {
      System.out.println("Customer is less than 29");
    }
    
    return isOlder;
  }

}
