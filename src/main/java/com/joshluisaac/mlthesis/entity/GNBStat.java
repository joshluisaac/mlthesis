package com.joshluisaac.mlthesis.entity;

public class GNBStat {
  
  double test_size, random_state, accuracy;

  public double getTest_size() {
    return test_size;
  }

  public void setTest_size(double test_size) {
    this.test_size = test_size;
  }

  public double getRandom_state() {
    return random_state;
  }

  public void setRandom_state(double random_state) {
    this.random_state = random_state;
  }

  public double getAccuracy() {
    return accuracy;
  }

  public void setAccuracy(double accuracy) {
    this.accuracy = accuracy;
  }

  @Override
  public String toString() {
    return "GNBStat [test_size=" + test_size + ", random_state=" + random_state + ", accuracy=" + accuracy + "]";
  }
  
  
  
  

}
