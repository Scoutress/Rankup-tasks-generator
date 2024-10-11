package com.scoutress.servers;

import com.scoutress.constants.SurvivalItems;
import com.scoutress.dto.Item;
import java.util.Random;

public class SurvivalServerTasks {

  private static int level;
  private static int taskNumber;
  private static String taskCategory;
  private static String itemDifficulty;
  private static String itemName;
  private static double timeForTask;
  private static double itemCountByTime;
  private static double totalTimeForLevel;
  private static double levelTime;

  public static void generateAndPrintSurvivalTasks(int survivalRankupLevelsCount, int survivalRankupTimeForFirstLevel,
      int survivalRankupTimeForLastLevel, String mode) {

    for (int lvl = 1; lvl < survivalRankupLevelsCount; lvl++) {
      setLevelForTasks(lvl);

      levelTime = survivalRankupTimeForFirstLevel + (survivalRankupTimeForLastLevel - survivalRankupTimeForFirstLevel)
          * ((lvl - 1) / (double) (survivalRankupLevelsCount - 1));

      printLevelTitle(mode);
      totalTimeForLevel = 0;

      for (int currentTaskNumber = 1; currentTaskNumber <= 10; currentTaskNumber++) {
        setTaskNumberForLevel(currentTaskNumber);

        switch (currentTaskNumber) {
          case 1, 2 -> taskCategory = "dig";
          case 3, 4 -> taskCategory = "kill";
          case 5, 6 -> taskCategory = "furnace";
          case 7 -> taskCategory = "craft";
          case 8 -> taskCategory = "fish";
          case 9 -> taskCategory = "place";
          case 10 -> taskCategory = "have";
        }

        switch (currentTaskNumber) {
          case 1, 3, 5, 7, 8, 9, 10 -> itemDifficulty = "easy";
          case 2, 4, 6 -> itemDifficulty = "hard";
        }

        Item item = SurvivalItems.getRandomSurvivalItem(taskCategory, itemDifficulty);
        itemName = item.getName();

        setTimeRequiredForTask(levelTime, itemDifficulty, item);

        printTasksForLevel(mode);

        totalTimeForLevel += timeForTask * itemCountByTime;
      }
      printTotalTimeForLevel(mode);
      System.out.println();
    }
  }

  private static void setTimeRequiredForTask(double levelTime, String difficulty, Item item) {
    double randomPercentage = difficulty.equals("easy")
        ? 0.10 + (new Random().nextDouble() * 0.05)
        : 0.05 + (new Random().nextDouble() * 0.05);

    double adjustedTime = levelTime * randomPercentage;
    double itemCount = Math.ceil(adjustedTime / item.getTime());

    timeForTask = item.getTime();
    itemCountByTime = itemCount;
  }

  private static void setLevelForTasks(int lvl) {
    level = lvl;
  }

  private static void setTaskNumberForLevel(int number) {
    taskNumber = number;
  }

  private static void printLevelTitle(String mode) {
    if (!mode.equals("file")) {
      System.out.printf("Level: %d\n", level);
    }
  }

  private static void printTasksForLevel(String mode) {
    if (!mode.equals("file")) {
      switch (mode) {
        case "detailed" -> System.out.printf("%d. %s %s %s %.0f items (%.2f mins/item, %.2f mins total)\n",
            taskNumber, taskCategory, itemDifficulty, itemName, itemCountByTime, timeForTask,
            timeForTask * itemCountByTime);
        case "clean" -> System.out.printf("%d. %s %s %.0f\n", taskNumber, taskCategory, itemName, itemCountByTime);
        default -> System.out.println("Wrong mode");
      }
    }
  }

  private static void printTotalTimeForLevel(String mode) {
    double totalHours = totalTimeForLevel / 60;
    double totalDays = totalHours / 8;

    if (!mode.equals("file")) {
      System.out.printf("Total: %.2f mins (%.2f hours, %.2f days)\n", totalTimeForLevel, totalHours, totalDays);
    }
  }
}
