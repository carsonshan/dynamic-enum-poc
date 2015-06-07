package com.selesy.poc.dynamicenumpoc;

public enum ComplexEnum {
  
  ONE("1", "One"),
  TWO("2", "Two"),
  THREE("3", "Three"),
  FOUR("4", "Four"),
  FIVE("5", "Five");

  String stringEnglish;
  String stringOrdinal;
  
  private ComplexEnum(String stringOrdinal, String stringEnglish) {
    this.stringEnglish = stringEnglish;
    this.stringOrdinal = stringOrdinal;
  }
  
  public String getStringEnglish() {
    return this.stringEnglish;
  }
  
  public String getStringOString() {
    return this.stringOrdinal;
  }

}
