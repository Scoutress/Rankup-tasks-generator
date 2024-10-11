package com.scoutress.dto;

public class Item {

  private String name;
  private Double time;
  private char level;
  private int limitedCraftableAmount;

  public Item(String name, double time) {
    this.name = name;
    this.time = time;
  }

  public Item(String name, double time, char level) {
    this.name = name;
    this.time = time;
    this.level = level;
  }

  public Item(String name, double time, char level, int limitedCraftableAmount) {
    this.name = name;
    this.time = time;
    this.level = level;
    this.limitedCraftableAmount = limitedCraftableAmount;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getTime() {
    return time;
  }

  public void setTime(Double time) {
    this.time = time;
  }

  public char getLevel() {
    return level;
  }

  public void setLevel(char level) {
    this.level = level;
  }

  public boolean isLimitedCraftable() {
    return limitedCraftableAmount > 0;
  }

  public int getLimitedCraftableAmount() {
    return limitedCraftableAmount;
  }
}
