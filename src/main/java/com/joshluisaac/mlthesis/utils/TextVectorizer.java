package com.joshluisaac.mlthesis.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kollect.etl.util.FileUtils;

public class TextVectorizer {
  
  public static final String DATA_FILE_PATH = "/media/joshua/martian/staffworkspace/phd-thesis/datafiles/";
  public static final Map<String, String> MAP = new HashMap<>();

  
  public TextVectorizer() {
    MAP.put("Open", "open");
    MAP.put("Paid", "paid");
  }
  
  
  public void vectorize(final String rootPath) throws IOException {
    FileUtils utils = new FileUtils();
    
    File file = new File(rootPath, "customerInvoiceDataPred.csv");
    List<String> dataSet = new FileUtils().readFile(file);
    StringBuilder buffer = new StringBuilder();

    for (int i = 0; i < dataSet.size(); i++) {
      String[] columns = dataSet.get(i).split("\\|");

      String customerId = columns[0];
      String customerName = columns[1];
      String invoiceDate = columns[2];
      String invoiceStatus = columns[3];

      if (customerId != null) {
        buffer.append("1|");
      } else {
        buffer.append("0|");
      }
      if (customerName != null) {
        if (customerName.length() <= 30) {
          buffer.append("1|");
        } else {
          buffer.append("2|");
        }
      } else {
        buffer.append("0|");
      }
      
      
      if (invoiceDate != null) {
        if (invoiceDate.length() == 10) {
          buffer.append("1|");
        } else {
          buffer.append("2|");
        }
      } else {
        buffer.append("0|");
      }
      if (invoiceStatus != null) {
        if (MAP.containsKey(invoiceStatus)) {
          buffer.append("1");
        } else {
          buffer.append("2");
        }
      } else {
        buffer.append("0");
      }
      buffer.append("\n");
    }
    utils.deleteFile(new File(DATA_FILE_PATH,"customerInvoiceDataPred.vec")); 
    utils.writeTextFile(DATA_FILE_PATH + "customerInvoiceDataPred.vec", buffer); 
  }


  public static void main(String[] args) throws Exception {
    
    new TextVectorizer().vectorize(DATA_FILE_PATH);


  }

}
