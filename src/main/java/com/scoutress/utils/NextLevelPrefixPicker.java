package com.scoutress.utils;

public class NextLevelPrefixPicker {

  public String getNextPrefix(int level) {
    String[] prefix = { "n/a", "②", "③", "④", "⑤", "⑥", "⑦", "⑧", "⑨", "⑩", "⑪", "⑫", "⑬" };
    return prefix[level - 1];
  }
}
