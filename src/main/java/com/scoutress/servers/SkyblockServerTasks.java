package com.scoutress.servers;

import com.scoutress.UI;
import com.scoutress.dto.Item;
import com.scoutress.utils.ItemCheckerByItemType;
import com.scoutress.utils.ItemDataPicker;
import com.scoutress.utils.RequiredTimeForLevelAssigner;
import com.scoutress.utils.RequiredTimeForTaskAssigner;
import com.scoutress.utils.TaskCategoryAssigner;

public class SkyblockServerTasks {

  private static String taskCategory;
  private static String itemName;
  private static double itemTime;
  private static int itemCountByTime;
  private static double totalTimeForLevel;
  private static double levelTime;
  private static double requiredTimeForTask;
  private static double totalTimeForSingleTask;

  public static void generateAndPrintSkyblockTasks(
      int skyblockRankupLevelsCount, int skyblockRankupTimeForFirstLevel,
      int skyblockRankupTimeForLastLevel, String mode, String server) {

    RequiredTimeForLevelAssigner rtla = new RequiredTimeForLevelAssigner();
    TaskCategoryAssigner tca = new TaskCategoryAssigner();
    ItemDataPicker idp = new ItemDataPicker();
    RequiredTimeForTaskAssigner rtta = new RequiredTimeForTaskAssigner();
    ItemCheckerByItemType icit = new ItemCheckerByItemType();
    UI ui = new UI();

    String itemDifficulty = "normal";

    for (int level = 1; level < skyblockRankupLevelsCount; level++) {

      ui
          .printLevelTitle(mode, level);

      for (int currentTaskNumber = 1; currentTaskNumber <= 8; currentTaskNumber++) {

        levelTime = rtla
            .calculateTimeRequiredForLevel(server, level);

        taskCategory = tca
            .determineCurrentTaskCategory(currentTaskNumber, server);

        Item item = idp
            .getItemData(server, taskCategory, itemDifficulty);
        itemName = item.getName();
        itemTime = item.getTime();

        requiredTimeForTask = rtta
            .calculateTimeRequiredForTask(server, itemDifficulty, levelTime);

        itemCountByTime = icit
            .calculateItemsByGivenTime(itemName, requiredTimeForTask, itemTime);

        totalTimeForSingleTask = itemTime * itemCountByTime;
        totalTimeForLevel += totalTimeForSingleTask;

        ui
            .printTasksForLevel(
                server, mode, currentTaskNumber, taskCategory, itemDifficulty,
                itemName, itemCountByTime, itemTime, totalTimeForSingleTask);

      }
      ui
          .printTotalTimeForLevel(mode, totalTimeForLevel);
      System.out.println();
    }
  }
}
