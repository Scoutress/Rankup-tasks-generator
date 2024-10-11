package com.scoutress.servers;

import com.scoutress.UI;
import com.scoutress.constants.LimitedCraftables;
import com.scoutress.constants.itemsByServers.SkyblockItems;
import com.scoutress.dto.Item;
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

    Random random = new Random();
    LimitedCraftables limitedCraftables = new LimitedCraftables();
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
            String[] categories = { "WALK" }; // will be added more later
            taskCategory = categories[random.nextInt(categories.length)];
          }
        }

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
}
