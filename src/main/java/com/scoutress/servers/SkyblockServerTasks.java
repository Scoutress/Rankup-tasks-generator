package com.scoutress.servers;

import com.scoutress.UI;
import com.scoutress.constants.LimitedCraftables;
import com.scoutress.constants.itemsByServers.SkyblockItems;
import com.scoutress.dto.Item;
import com.scoutress.utils.RequiredTimeForLevelAssigner;
import com.scoutress.utils.RequiredTimeForTaskAssigner;
import com.scoutress.utils.TaskCategoryAssigner;
import java.util.List;
import java.util.Random;

public class SkyblockServerTasks {

  private static int taskNumber;
  private static String taskCategory;
  private static String itemName;
  private static double timeForTask;
  private static double itemCountByTime;
  private static double totalTimeForLevel;
  private static double levelTime;
  private static double requiredTimeForTask;

  public static void generateAndPrintSkyblockTasks(
      int skyblockRankupLevelsCount, int skyblockRankupTimeForFirstLevel,
      int skyblockRankupTimeForLastLevel, String mode, String server) {

    RequiredTimeForLevelAssigner rtla = new RequiredTimeForLevelAssigner();
    LimitedCraftables lc = new LimitedCraftables();
    TaskCategoryAssigner tca = new TaskCategoryAssigner();
    RequiredTimeForTaskAssigner rtta = new RequiredTimeForTaskAssigner();
    UI ui = new UI();

    String itemDifficulty = "normal";

    for (int level = 1; level < skyblockRankupLevelsCount; level++) {

      levelTime = rtla
          .calculateTimeRequiredForLevel(server, level); // new

      ui.printLevelTitle(mode, level);
      totalTimeForLevel = 0;

      for (int currentTaskNumber = 1; currentTaskNumber <= 8; currentTaskNumber++) {
        setTaskNumberForLevel(currentTaskNumber);

        taskCategory = tca.determineCurrentTaskCategory(currentTaskNumber, server); // new

        List<Item> itemList = SkyblockItems.getItemsByCategory(taskCategory);

        if (itemList.isEmpty()) {
          System.out.printf("No items found for category '%s'. Skipping task %d.\n", taskCategory, currentTaskNumber);
        }

        Item item = getRandomItem(itemList);
        itemName = item.getName();

        // TODO: not used
        requiredTimeForTask = rtta
            .calculateTimeRequiredForTask(server, itemDifficulty, levelTime); // new

        if (lc.getItemNames().contains(itemName)) {
          itemCountByTime = lc.getMaxQuantity();
        } else {
          itemCountByTime = requiredTimeForTask / item.getTime();
        }

        timeForTask = itemCountByTime * item.getTime();

        ui.printTasksForLevel(
            server, mode, taskNumber, taskCategory, itemDifficulty,
            itemName, itemCountByTime, timeForTask, totalTimeForLevel);

        totalTimeForLevel += timeForTask;
      }
      ui.printTotalTimeForLevel(mode, totalTimeForLevel);
      System.out.println();
    }
  }

  private static void setTaskNumberForLevel(int number) {
    taskNumber = number;
  }

  private static Item getRandomItem(List<Item> filteredItems) {
    Random random = new Random();
    return filteredItems.get(random.nextInt(filteredItems.size()));
  }
}
