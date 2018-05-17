package com.joshluisaac.mlthesis.entity;

public class PandaDescribe {
  
  double count, mean, std, min, max, percent_25, percent_50, percent_75;
  String mapKey;
  
  public double getCount() {
    return count;
  }

  public void setCount(double count) {
    this.count = count;
  }

  public double getMean() {
    return mean;
  }

  public void setMean(double mean) {
    this.mean = mean;
  }

  public double getStd() {
    return std;
  }

  public void setStd(double std) {
    this.std = std;
  }

  public double getMin() {
    return min;
  }

  public void setMin(double min) {
    this.min = min;
  }

  public double getMax() {
    return max;
  }

  public void setMax(double max) {
    this.max = max;
  }



  public double getPercent_25() {
    return percent_25;
  }

  public void setPercent_25(double percent_25) {
    this.percent_25 = percent_25;
  }

  public double getPercent_50() {
    return percent_50;
  }

  public void setPercent_50(double percent_50) {
    this.percent_50 = percent_50;
  }

  public double getPercent_75() {
    return percent_75;
  }

  public void setPercent_75(double percent_75) {
    this.percent_75 = percent_75;
  }

  public String getMapKey() {
    return mapKey;
  }

  public void setMapKey(String mapKey) {
    this.mapKey = mapKey;
  }

  @Override
  public String toString() {
    return "PandaDescribe [count=" + count + ", mean=" + mean + ", std=" + std + ", min=" + min + ", max=" + max
        + ", mapKey=" + mapKey + "]";
  }
  
  
  

}
