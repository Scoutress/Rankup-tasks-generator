package com.scoutress.servers;

import com.scoutress.UI;
import com.scoutress.constants.LimitedCraftables;
import com.scoutress.constants.itemsByServers.SurvivalItems;
import com.scoutress.dto.Item;
import com.scoutress.utils.RequiredTimeForTaskAssigner;
import com.scoutress.utils.TaskCategoryAssigner;
import com.scoutress.utils.TaskItemDifficultyAssigner;

public class SurvivalServerTasks {

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

    LimitedCraftables lc = new LimitedCraftables();
    TaskCategoryAssigner tca = new TaskCategoryAssigner();
    TaskItemDifficultyAssigner tida = new TaskItemDifficultyAssigner();
    RequiredTimeForTaskAssigner rtta = new RequiredTimeForTaskAssigner();
    UI ui = new UI();

    for (int level = 1; level < survivalRankupLevelsCount; level++) {

      levelTime = survivalRankupTimeForFirstLevel + (survivalRankupTimeForLastLevel - survivalRankupTimeForFirstLevel)
          * ((level - 1) / (double) (survivalRankupLevelsCount - 1));

      ui.printLevelTitle(mode, level);

      for (int currentTaskNumber = 1; currentTaskNumber <= 10; currentTaskNumber++) {
        setTaskNumberForLevel(currentTaskNumber);

        taskCategory = tca
            .determineCurrentTaskCategory(currentTaskNumber, server); // new

        itemDifficulty = tida
            .determineCurrentTaskItemDifficulty(currentTaskNumber, server); // new

        Item item = SurvivalItems.getRandomSurvivalItem(taskCategory, itemDifficulty);
        itemName = item.getName();

        // TODO: not used
        double requiredTimeForTask = rtta
            .calculateTimeRequiredForTask(server, itemDifficulty, levelTime); // new

        if (lc.getItemNames().contains(itemName)) {
          itemCountByTime = lc.getMaxQuantity();
        } else {
          itemCountByTime = requiredTimeForTask / item.getTime();
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

  private static void setTaskNumberForLevel(int number) {
    taskNumber = number;
  }
}
