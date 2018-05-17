package com.joshluisaac.mlthesis.entity;

public class Workload {
  
  public double getPredtpps() {
    return predtpps;
  }

  public void setPredtpps(double predtpps) {
    this.predtpps = predtpps;
  }

  double runningTime, numberOfRecords, thruputpersec, predtpps, variance;

  public double getVariance() {
    return variance;
  }

  public void setVariance(double variance) {
    this.variance = variance;
  }

  public double getRunningTime() {
    return runningTime;
  }

  public void setRunningTime(double runningTime) {
    this.runningTime = runningTime;
  }

  public double getNumberOfRecords() {
    return numberOfRecords;
  }

  public void setNumberOfRecords(double numberOfRecords) {
    this.numberOfRecords = numberOfRecords;
  }

  public double getThruputpersec() {
    return thruputpersec;
  }

  public void setThruputpersec(double thruputpersec) {
    this.thruputpersec = thruputpersec;
  }

  @Override
  public String toString() {
    return "Workload [runningTime=" + runningTime + ", numberOfRecords=" + numberOfRecords + ", thruputpersec="
        + thruputpersec + ", predtpps=" + predtpps + "]";
  }
  
  
  
  

}
