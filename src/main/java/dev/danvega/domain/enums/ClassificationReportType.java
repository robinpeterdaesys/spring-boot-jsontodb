package dev.danvega.domain.enums;

public enum ClassificationReportType {
  ZERO ("0"),
  ONE ("1"),
  ACCURACY("accuracy"),
  MACRO_AVG("macro avg"),
  WEIGHTED_AVG("weighted avg");

  private String value;

  ClassificationReportType(String value) { this.value = value; }

  public String getValue(){ return  this.value; }

}