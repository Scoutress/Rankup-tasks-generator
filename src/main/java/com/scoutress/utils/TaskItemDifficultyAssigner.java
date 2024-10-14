package com.scoutress.utils;

public class TaskItemDifficultyAssigner {

  private static String itemDifficulty;

  public String determineCurrentTaskItemDifficulty(int currentTaskNumber, String server) {
    switch (server) {
      case "survival" -> {
        switch (currentTaskNumber) {
          case 1, 3, 5, 7, 8, 9, 10 -> itemDifficulty = "easy";
          case 2, 4, 6 -> itemDifficulty = "hard";
        }
      }
    }
    return itemDifficulty;
  }
}
