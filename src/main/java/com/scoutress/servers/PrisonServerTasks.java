package com.scoutress.servers;

import com.scoutress.UI;
import com.scoutress.constants.LimitedCraftables;
import com.scoutress.constants.itemsByServers.PrisonItems;
import com.scoutress.dto.Item;
import com.scoutress.utils.TaskCategoryAssigner;
import java.util.List;
import java.util.Random;

public class PrisonServerTasks {

  private static int level;
  private static int taskNumber;
  private static String taskCategory;
  private static String itemName;
  private static double timeForTask;
  private static double itemCountByTime;
  private static double totalTimeForLevel;
  private static double levelTime;

  public static void generateAndPrintPrisonTasks(
      int prisonRankupLevelsCount, int prisonRankupTimeForFirstLevel,
      int prisonRankupTimeForLastLevel, String mode, String server) {

    LimitedCraftables limitedCraftables = new LimitedCraftables();
    TaskCategoryAssigner tca = new TaskCategoryAssigner();
    UI ui = new UI();

    String itemDifficulty = null;

    for (int lvl = 1; lvl < prisonRankupLevelsCount; lvl++) {
      setLevelForTasks(lvl);

      levelTime = prisonRankupTimeForFirstLevel + (prisonRankupTimeForLastLevel - prisonRankupTimeForFirstLevel)
          * ((lvl - 1) / (double) (prisonRankupLevelsCount - 1));

      ui.printLevelTitle(mode, level);
      totalTimeForLevel = 0;

      for (int currentTaskNumber = 1; currentTaskNumber <= 10; currentTaskNumber++) {
        setTaskNumberForLevel(currentTaskNumber);

        taskCategory = tca.determineCurrentTaskCategory(currentTaskNumber, server);

        List<Item> itemList = PrisonItems.getItemsByCategory(taskCategory);

        List<Item> filteredItems = filterItemsByLevel(itemList, lvl);

        if (filteredItems.isEmpty()) {
          if (!mode.equals("file")) {
            System.out.printf("No items found for category '%s' at level %d. Skipping task %d.\n", taskCategory, lvl,
                currentTaskNumber);
          }
          continue;
        }

        Item item = getRandomItem(filteredItems);
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

  private static List<Item> filterItemsByLevel(List<Item> itemList, int lvl) {
    char levelLetter = (char) ('A' + (lvl - 1));
    return itemList.stream()
        .filter(item -> item.getLevel() <= levelLetter)
        .toList();
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

  private static void setLevelForTasks(int lvl) {
    level = lvl;
  }

  private static void setTaskNumberForLevel(int number) {
    taskNumber = number;
  }

  // nauji metodai

}
