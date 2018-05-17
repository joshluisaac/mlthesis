package com.joshluisaac.mlthesis.entity;

public class Panda {
  
  PandaDescribe CustomerId_PKEY,CustomerName_OPT,InvoiceDate_NN,InvoiceStatus_OPT, RunningTime, Payload, ThroughputPersec;

  public PandaDescribe getRunningTime() {
    return RunningTime;
  }

  public void setRunningTime(PandaDescribe runningTime) {
    RunningTime = runningTime;
  }

  public PandaDescribe getPayload() {
    return Payload;
  }

  public void setPayload(PandaDescribe payload) {
    Payload = payload;
  }

  public PandaDescribe getThroughputPersec() {
    return ThroughputPersec;
  }

  public void setThroughputPersec(PandaDescribe throughputPersec) {
    ThroughputPersec = throughputPersec;
  }

  public PandaDescribe getCustomerId_PKEY() {
    return CustomerId_PKEY;
  }

  public void setCustomerId_PKEY(PandaDescribe customerId_PKEY) {
    CustomerId_PKEY = customerId_PKEY;
  }

  public PandaDescribe getCustomerName_OPT() {
    return CustomerName_OPT;
  }

  public void setCustomerName_OPT(PandaDescribe customerName_OPT) {
    CustomerName_OPT = customerName_OPT;
  }

  public PandaDescribe getInvoiceDate_NN() {
    return InvoiceDate_NN;
  }

  public void setInvoiceDate_NN(PandaDescribe invoiceDate_NN) {
    InvoiceDate_NN = invoiceDate_NN;
  }

  public PandaDescribe getInvoiceStatus_OPT() {
    return InvoiceStatus_OPT;
  }

  public void setInvoiceStatus_OPT(PandaDescribe invoiceStatus_OPT) {
    InvoiceStatus_OPT = invoiceStatus_OPT;
  }

  @Override
  public String toString() {
    return "Panda [CustomerId_PKEY=" + CustomerId_PKEY + ", CustomerName_OPT=" + CustomerName_OPT
        + ", InvoiceDate_NN=" + InvoiceDate_NN + ", InvoiceStatus_OPT=" + InvoiceStatus_OPT + "]";
  }
  
  

}
