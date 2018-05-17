package com.joshluisaac.mlthesis.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GaussianMetrics {
  
  String model_type;
  int prediction_file_length;
  String model_name;
  
  public String getModel_type() {
    return model_type;
  }
  public void setModel_type(String model_type) {
    this.model_type = model_type;
  }
  public int getPrediction_file_length() {
    return prediction_file_length;
  }
  public void setPrediction_file_length(int prediction_file_length) {
    this.prediction_file_length = prediction_file_length;
  }
  public String getModel_name() {
    return model_name;
  }
  public void setModel_name(String model_name) {
    this.model_name = model_name;
  }
  @Override
  public String toString() {
    return "GaussianMetrics [model_type=" + model_type + ", prediction_file_length=" + prediction_file_length
        + ", model_name=" + model_name + "]";
  }

  
  

}
