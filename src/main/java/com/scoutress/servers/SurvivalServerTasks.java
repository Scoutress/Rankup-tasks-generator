package com.scoutress.servers;

import com.scoutress.UI;
import com.scoutress.constants.LimitedCraftables;
import com.scoutress.constants.itemsByServers.SurvivalItems;
import com.scoutress.dto.Item;
import com.scoutress.utils.TaskCategoryAssigner;
import com.scoutress.utils.TaskItemDifficultyAssigner;
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

  public static void generateAndPrintSurvivalTasks(
      int survivalRankupLevelsCount, int survivalRankupTimeForFirstLevel,
      int survivalRankupTimeForLastLevel, String mode, String server) {

    LimitedCraftables limitedCraftables = new LimitedCraftables();
    TaskCategoryAssigner tca = new TaskCategoryAssigner();
    TaskItemDifficultyAssigner tida = new TaskItemDifficultyAssigner();
    UI ui = new UI();

    for (int lvl = 1; lvl < survivalRankupLevelsCount; lvl++) {
      setLevelForTasks(lvl);

      levelTime = survivalRankupTimeForFirstLevel + (survivalRankupTimeForLastLevel - survivalRankupTimeForFirstLevel)
          * ((lvl - 1) / (double) (survivalRankupLevelsCount - 1));

      ui.printLevelTitle(mode, level);
      totalTimeForLevel = 0;

      for (int currentTaskNumber = 1; currentTaskNumber <= 10; currentTaskNumber++) {
        setTaskNumberForLevel(currentTaskNumber);

        taskCategory = tca.determineCurrentTaskCategory(currentTaskNumber, server);

        itemDifficulty = tida.determineCurrentTaskItemDifficulty(currentTaskNumber, server);

        Item item = SurvivalItems.getRandomSurvivalItem(taskCategory, itemDifficulty);
        itemName = item.getName();

        setTimeRequiredForTask(levelTime, itemDifficulty, item);

        if (limitedCraftables.getItemNames().contains(itemName)) {
          itemCountByTime = limitedCraftables.getMaxQuantity();
        }

        totalTimeForLevel += timeForTask * itemCountByTime;

        ui.printTasksForLevel(
            server, mode, taskNumber, taskCategory, itemDifficulty,
            itemName, itemCountByTime, timeForTask, totalTimeForLevel);

      }
      ui.printTotalTimeForLevel(mode, totalTimeForLevel);
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

  // nauji metodai

}
