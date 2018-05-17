package com.joshluisaac.mlthesis.component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.joshluisaac.mlthesis.entity.GNBStat;
import com.joshluisaac.mlthesis.entity.Panda;
import com.joshluisaac.mlthesis.entity.PandaDescribe;
import com.joshluisaac.mlthesis.entity.RegressionMetrics;

@Component
public class PandaDescribeReader {
  
  public final static String[] keys = {"CustomerId_PKEY","InvoiceDate_NN","InvoiceStatus_OPT","CustomerName_OPT"};
  public final static String[] workloadkeys = {"Payload","ThroughputPersec","RunningTime"};
  
  public List<PandaDescribe> readX(String fileName) {
    List<PandaDescribe> list = new ArrayList<>();
    JSONParser parser = new JSONParser();
    
    
    try(Reader reader = new InputStreamReader(PandaDescribeReader.class.getResourceAsStream("/" + fileName), "UTF-8")) {
      Object obj = parser.parse(reader);
      
      JSONObject jsonObject = (JSONObject) obj;
      //System.out.println(jsonObject);
      
      //System.out.println(jsonObject.size());
      
      
      
      for(int i = 0; i < keys.length; i++) {
        PandaDescribe pd = new PandaDescribe();
        
        String mapKey = keys[i];
        
        JSONObject val =  (JSONObject) jsonObject.get(mapKey);
        pd.setStd((double) val.get("std"));
        pd.setCount((double) val.get("count"));
        pd.setMin((double) val.get("min"));
        pd.setMax((double) val.get("max"));
        pd.setMean((double) val.get("mean"));
        
        pd.setPercent_25((double) val.get("25%"));
        pd.setPercent_50((double) val.get("50%"));
        pd.setPercent_75((double) val.get("75%"));
        pd.setMapKey(mapKey);
        list.add(pd);
      }

      
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (UnsupportedEncodingException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    
    
    System.out.println(list.toString());
    
//    try(Reader reader = new InputStreamReader(PandaDescribeReader.class.getResourceAsStream("/gaussian_pred.json"), "UTF-8")){
//      Gson gson = new Gson();  
//      PandaDescribe p = gson.fromJson(reader, PandaDescribe.class);
//      System.out.println(p);
//  }
    
    return list;
}
  
  
  public List<GNBStat> readGNBStats(final String fileName) {
    List<GNBStat> list = new ArrayList<>();
    JSONParser parser = new JSONParser();
    
    //FileReader
    
    try(Reader reader = new FileReader(fileName)) {
      Object obj = parser.parse(reader);
      
      JSONObject jsonObject = (JSONObject) obj;
      
      System.out.println(jsonObject);
      
      System.out.println(jsonObject.get("accuracy"));
    }
    
    catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (UnsupportedEncodingException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    
    return list;
    
  }
  
  
  public List<PandaDescribe> readWorkload(final String fileName) {
    Gson gson = new Gson();
    Panda regresPred;
    List<PandaDescribe> p = null;
    try(Reader reader = new InputStreamReader(PandaDescribeReader.class.getResourceAsStream("/" + fileName), "UTF-8")) {
      regresPred = gson.fromJson(reader, Panda.class);
      p = new ArrayList<>();
      PandaDescribe payload = regresPred.getPayload();
      payload.setMapKey(workloadkeys[0]);
      
      PandaDescribe thruput = regresPred.getThroughputPersec();
      thruput.setMapKey(workloadkeys[1]);
      
      PandaDescribe runningtime = regresPred.getRunningTime();
      runningtime.setMapKey(workloadkeys[2]);
      
      p.add(payload);
      p.add(thruput);
      p.add(runningtime);

      
    } catch (JsonSyntaxException e) {
      e.printStackTrace();
    } catch (JsonIOException e) {
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    System.out.println("Deserialization using google GSON for regression");
    return p;
  }
  
  
  
  public List<PandaDescribe> read(final String fileName) {
    Gson gson = new Gson();
    Panda gnbPred;
    List<PandaDescribe> p = null;
    try(Reader reader = new InputStreamReader(PandaDescribeReader.class.getResourceAsStream("/" + fileName), "UTF-8")) {
      gnbPred = gson.fromJson(reader, Panda.class);
      p = new ArrayList<>();
      PandaDescribe customer = gnbPred.getCustomerId_PKEY();
      customer.setMapKey(keys[0]);
      
      PandaDescribe invoiceno = gnbPred.getInvoiceDate_NN();
      invoiceno.setMapKey(keys[1]);
      
      PandaDescribe invStatus = gnbPred.getInvoiceStatus_OPT();
      invStatus.setMapKey(keys[2]);
      
      PandaDescribe customerName = gnbPred.getCustomerName_OPT();
      customerName.setMapKey(keys[3]);
      
      p.add(customer);
      p.add(invoiceno);
      p.add(invStatus);
      p.add(customerName);
      
    } catch (JsonSyntaxException e) {
      e.printStackTrace();
    } catch (JsonIOException e) {
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    System.out.println("Deserialization using google GSON");
    return p;
  }

  public GNBStat readAccurracy(final String fileName) {
    Gson gson = new Gson();
    GNBStat gnb = null;
    try(Reader reader = new InputStreamReader(PandaDescribeReader.class.getResourceAsStream("/" + fileName), "UTF-8")) {
      
      gnb = gson.fromJson(reader, GNBStat.class);
      
    } catch (UnsupportedEncodingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return gnb;
  }
  
  
  
  public RegressionMetrics readRegres(final String fileName) {
    Gson gson = new Gson();
    RegressionMetrics model = null;
    try(Reader reader = new InputStreamReader(PandaDescribeReader.class.getResourceAsStream("/" + fileName), "UTF-8")) {
      
      model = gson.fromJson(reader, RegressionMetrics.class);
      
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return model;
  }
  
  
  public static void main(String[] args) throws Exception {
    
    
    //new PandaDescribeReader().read("");
    new PandaDescribeReader().readGNBStats("/media/joshua/martian/staffworkspace/mlthesis/out/gnb_train_stats.json");
    

    

    
    
    
    
    

  }

}
