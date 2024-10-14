package com.scoutress.servers;

import com.scoutress.UI;
import com.scoutress.constants.LimitedCraftables;
import com.scoutress.constants.itemsByServers.SkyblockItems;
import com.scoutress.dto.Item;
import com.scoutress.utils.TaskCategoryAssigner;
import java.util.List;
import java.util.Random;

public class SkyblockServerTasks {

  private static int level;
  private static int taskNumber;
  private static String taskCategory;
  private static String itemName;
  private static double timeForTask;
  private static double itemCountByTime;
  private static double totalTimeForLevel;
  private static double levelTime;

  public static void generateAndPrintSkyblockTasks(
      int skyblockRankupLevelsCount, int skyblockRankupTimeForFirstLevel,
      int skyblockRankupTimeForLastLevel, String mode, String server) {

    LimitedCraftables limitedCraftables = new LimitedCraftables();
    TaskCategoryAssigner tca = new TaskCategoryAssigner();
    UI ui = new UI();

    String itemDifficulty = null;

    for (int lvl = 1; lvl < skyblockRankupLevelsCount; lvl++) {
      setLevelForTasks(lvl);

      levelTime = skyblockRankupTimeForFirstLevel + (skyblockRankupTimeForLastLevel - skyblockRankupTimeForFirstLevel)
          * ((lvl - 1) / (double) (skyblockRankupLevelsCount - 1));

      ui.printLevelTitle(mode, level);
      totalTimeForLevel = 0;

      for (int currentTaskNumber = 1; currentTaskNumber <= 8; currentTaskNumber++) {
        setTaskNumberForLevel(currentTaskNumber);

        taskCategory = tca.determineCurrentTaskCategory(currentTaskNumber, server);

        List<Item> itemList = SkyblockItems.getItemsByCategory(taskCategory);

        if (itemList.isEmpty()) {
          System.out.printf("No items found for category '%s'. Skipping task %d.\n", taskCategory, currentTaskNumber);
        }

        Item item = getRandomItem(itemList);
        itemName = item.getName();

        setTimeRequiredForTask(levelTime, item);

        if (limitedCraftables.getItemNames().contains(itemName)) {
          itemCountByTime = limitedCraftables.getMaxQuantity();
        }

        ui.printTasksForLevel(
            server, mode, taskNumber, taskCategory, itemDifficulty,
            itemName, itemCountByTime, timeForTask, totalTimeForLevel);

        totalTimeForLevel += timeForTask * itemCountByTime;
      }
      ui.printTotalTimeForLevel(mode, totalTimeForLevel);
      System.out.println();
    }
  }

  private static void setLevelForTasks(int lvl) {
    level = lvl;
  }

  private static void setTaskNumberForLevel(int number) {
    taskNumber = number;
  }

  private static Item getRandomItem(List<Item> filteredItems) {
    Random random = new Random();
    return filteredItems.get(random.nextInt(filteredItems.size()));
  }

  private static void setTimeRequiredForTask(double levelTime, Item item) {
    double taskTime = levelTime / 10;

    if (item.isLimitedCraftable()) {
      itemCountByTime = item.getLimitedCraftableAmount();
      timeForTask = item.getTime();
    } else {
      itemCountByTime = Math.ceil(taskTime / item.getTime());
      timeForTask = item.getTime();
    }
  }

  // nauji metodai

}
