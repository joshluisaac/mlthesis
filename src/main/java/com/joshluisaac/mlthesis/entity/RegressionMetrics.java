package com.joshluisaac.mlthesis.entity;

public class RegressionMetrics {
  
  double intercept, coefficient, mae,mse,rms;

  public double getIntercept() {
    return intercept;
  }

  public void setIntercept(double intercept) {
    this.intercept = intercept;
  }

  public double getCoefficient() {
    return coefficient;
  }

  public void setCoefficient(double coefficient) {
    this.coefficient = coefficient;
  }

  public double getMae() {
    return mae;
  }

  public void setMae(double mae) {
    this.mae = mae;
  }

  public double getMse() {
    return mse;
  }

  public void setMse(double mse) {
    this.mse = mse;
  }

  public double getRms() {
    return rms;
  }

  public void setRms(double rms) {
    this.rms = rms;
  }

  @Override
  public String toString() {
    return "RegressionMetrics [intercept=" + intercept + ", coefficient=" + coefficient + ", mae=" + mae + ", mse="
        + mse + ", rms=" + rms + "]";
  }
  
  

}
