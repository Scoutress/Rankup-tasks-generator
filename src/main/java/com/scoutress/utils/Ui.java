package com.scoutress.utils;

import java.util.List;

public class Ui {
  public static void printTasksWithNumbers(List<String> tasks) {
    for (int i = 0; i < tasks.size(); i++) {
      System.out.println((i + 1) + ". " + tasks.get(i));
    }
  }
}
