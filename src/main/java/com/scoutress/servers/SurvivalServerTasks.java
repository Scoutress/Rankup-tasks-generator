package com.scoutress.servers;

import com.scoutress.UI;
import com.scoutress.constants.LimitedCraftables;
import com.scoutress.dto.Item;
import com.scoutress.utils.ItemDataPicker;
import com.scoutress.utils.RequiredTimeForLevelAssigner;
import com.scoutress.utils.RequiredTimeForTaskAssigner;
import com.scoutress.utils.TaskCategoryAssigner;
import com.scoutress.utils.TaskItemDifficultyAssigner;

public class SurvivalServerTasks {

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

    RequiredTimeForLevelAssigner rtla = new RequiredTimeForLevelAssigner();
    LimitedCraftables lc = new LimitedCraftables();
    TaskCategoryAssigner tca = new TaskCategoryAssigner();
    TaskItemDifficultyAssigner tida = new TaskItemDifficultyAssigner();
    ItemDataPicker idp = new ItemDataPicker();
    RequiredTimeForTaskAssigner rtta = new RequiredTimeForTaskAssigner();
    UI ui = new UI();

    for (int level = 1; level < survivalRankupLevelsCount; level++) { // good one

      ui
          .printLevelTitle(mode, level); // good one

      for (int currentTaskNumber = 1; currentTaskNumber <= 10; currentTaskNumber++) { // good one

        levelTime = rtla
            .calculateTimeRequiredForLevel(server, level); // new

        taskCategory = tca
            .determineCurrentTaskCategory(currentTaskNumber, server); // new

        itemDifficulty = tida
            .determineCurrentTaskItemDifficulty(currentTaskNumber, server); // new

        Item item = idp.getItemData(server, taskCategory, itemDifficulty); // new
        itemName = item.getName(); // new

        double requiredTimeForTask = rtta
            .calculateTimeRequiredForTask(server, itemDifficulty, levelTime); // new

        if (lc.getItemNames().contains(itemName)) {
          itemCountByTime = lc.getMaxQuantity();
        } else {
          itemCountByTime = requiredTimeForTask / item.getTime();
        }

        totalTimeForLevel += timeForTask * itemCountByTime;

        ui.printTasksForLevel(
            server, mode, currentTaskNumber, taskCategory, itemDifficulty,
            itemName, itemCountByTime, timeForTask, totalTimeForLevel);

      }
      ui.printTotalTimeForLevel(mode, totalTimeForLevel);
      System.out.println();
    }
  }
}
