package com.joshluisaac.mlthesis.component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kollect.etl.util.FileUtils;

@Component
public class PredictedCsvProcessor {
  
  List<Integer> predResult = new ArrayList<>();
  
  List<String> valid = new ArrayList<>();
  List<String> invalid = new ArrayList<>();
  List<String> invalidloaddefault = new ArrayList<>();
  
  
  public List<Integer> process() {
    FileUtils utils = new FileUtils();
    List<String> csvList;
    try {
      csvList = utils.readFile(new File("/media/joshua/martian/staffworkspace/mlthesis/out/data_pred.csv"));
      for(int i = 0; i < csvList.size(); i++) {
        String replaced = csvList.get(i).replaceAll("[^0-9A-Za-z|]+","");
        //System.out.println(replaced);
        
        String[] columns = replaced.split("\\|");
        if(columns.length == 5) {
          if(columns[4].equals("Valid")) {
            valid.add("valid");
          }
          if(columns[4].equals("InvalidData")) {
            invalid.add("invalid");
          }
          
          if(columns[4].equals("InvalidDataLoadDefault")) {
            invalidloaddefault.add("invaliddataloaddefault");
          } 
        }
      }
    } catch (IOException e) {
      //JOSHTODO: Implement error handing and logging
      e.printStackTrace();
    }
    predResult.add(valid.size());
    predResult.add(invalid.size());
    predResult.add(invalidloaddefault.size());
    return predResult;
    
  }

  public static void main(String[] args) throws IOException {
    new PredictedCsvProcessor().process();
    System.out.println();

  }

}
