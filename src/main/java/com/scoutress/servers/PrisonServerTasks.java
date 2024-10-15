package com.scoutress.servers;

import com.scoutress.UI;
import com.scoutress.constants.LimitedCraftables;
import com.scoutress.dto.Item;
import com.scoutress.utils.ItemDataPicker;
import com.scoutress.utils.RequiredTimeForLevelAssigner;
import com.scoutress.utils.RequiredTimeForTaskAssigner;
import com.scoutress.utils.TaskCategoryAssigner;

public class PrisonServerTasks {

  private static String taskCategory;
  private static String itemName;
  private static double timeForTask;
  private static double itemCountByTime;
  private static double totalTimeForLevel;
  private static double levelTime;
  private static double requiredTimeForTask;

  public static void generateAndPrintPrisonTasks(
      int prisonRankupLevelsCount, int prisonRankupTimeForFirstLevel,
      int prisonRankupTimeForLastLevel, String mode, String server) {

    RequiredTimeForLevelAssigner rtla = new RequiredTimeForLevelAssigner();
    LimitedCraftables lc = new LimitedCraftables();
    TaskCategoryAssigner tca = new TaskCategoryAssigner();
    ItemDataPicker idp = new ItemDataPicker();
    RequiredTimeForTaskAssigner rtta = new RequiredTimeForTaskAssigner();
    UI ui = new UI();

    String itemDifficulty = "normal";

    for (int level = 1; level < prisonRankupLevelsCount; level++) { // good one

      ui
          .printLevelTitle(mode, level); // good one

      for (int currentTaskNumber = 1; currentTaskNumber <= 10; currentTaskNumber++) { // good one

        levelTime = rtla
            .calculateTimeRequiredForLevel(server, level); // new

        taskCategory = tca
            .determineCurrentTaskCategory(currentTaskNumber, server); // new

        Item item = idp.getItemData(server, taskCategory, itemDifficulty); // new
        itemName = item.getName(); // new

        requiredTimeForTask = rtta
            .calculateTimeRequiredForTask(server, itemDifficulty, levelTime); // new

        if (lc.getItemNames().contains(itemName)) {
          itemCountByTime = lc.getMaxQuantity();
        } else {
          itemCountByTime = requiredTimeForTask / item.getTime();
        }

        timeForTask = itemCountByTime * item.getTime();

        ui.printTasksForLevel(
            server, mode, currentTaskNumber, taskCategory, itemDifficulty,
            itemName, itemCountByTime, timeForTask, totalTimeForLevel);

        totalTimeForLevel += timeForTask;
      }
      ui.printTotalTimeForLevel(mode, totalTimeForLevel);
      System.out.println();
    }
  }
}
