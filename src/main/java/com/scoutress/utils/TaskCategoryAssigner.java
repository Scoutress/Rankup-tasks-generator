package com.scoutress.utils;

import java.util.Random;

public class TaskCategoryAssigner {

  private static String taskCategory;

  static Random random = new Random();

  public String determineCurrentTaskCategory(int currentTaskNumber, String server) {
    switch (server) {
      case "survival" -> {
        switch (currentTaskNumber) {
          case 1, 2 -> taskCategory = "dig";
          case 3, 4 -> taskCategory = "kill";
          case 5, 6 -> taskCategory = "furnace";
          case 7 -> taskCategory = "craft";
          case 8 -> taskCategory = "fish";
          case 9 -> taskCategory = "place";
          case 10 -> taskCategory = "have";
        }
      }
      case "skyblock" -> {
        switch (currentTaskNumber) {
          case 1 -> taskCategory = "XP";
          case 2 -> taskCategory = "DIG";
          case 3 -> taskCategory = "PLACE";
          case 4 -> taskCategory = "KILL";
          case 5 -> taskCategory = "FISH";
          case 6 -> {
            String[] categories = { "SMELT", "COOK" };
            taskCategory = categories[random.nextInt(categories.length)];
          }
          case 7 -> {
            String[] categories = { "CRAFT", "HAVE" };
            taskCategory = categories[random.nextInt(categories.length)];
          }
          case 8 -> {
            String[] categories = { "WALK", "SWIM_WITH_BOAT", "RIDE_PIG", "RIDE_HORSE", "SWIM", "FLY_ELYTRA" };
            taskCategory = categories[random.nextInt(categories.length)];
          }
        }
      }
      case "prison" -> {
        switch (currentTaskNumber) {
          case 1 -> taskCategory = "dig";
          case 2 -> taskCategory = "kill";
          case 3 -> taskCategory = "furnace";
          case 4 -> taskCategory = "craft";
          case 5 -> taskCategory = "placedoctor";
          case 6 -> taskCategory = "cleantoilets";
          case 7 -> taskCategory = "cleanplate";
          case 8 -> taskCategory = "placefood";
          case 9 -> taskCategory = "have";
          case 10 -> taskCategory = "fish";
        }
      }
    }
    return taskCategory;
  }
}
