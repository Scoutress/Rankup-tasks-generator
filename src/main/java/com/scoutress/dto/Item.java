package com.scoutress.dto;

public class Item {

  String name;
  Double time;

  public Item(String name, double d) {
    this.name = name;
    this.time = d;
  }

  public String getName() {
    return name;
  }

  public Double getTime() {
    return time;
  }
}
