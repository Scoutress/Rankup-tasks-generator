package com.scoutress.dto;

public class Item {

  String name;
  Double time;
  char level;

  public Item(String name, double time) {
    this.name = name;
    this.time = time;
  }

  public Item(String name, double time, char level) {
    this.name = name;
    this.time = time;
    this.level = level;
  }

  public String getName() {
    return name;
  }

  public Double getTime() {
    return time;
  }

  public char level() {
    return level;
  }
}
