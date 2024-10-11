package com.scoutress.servers;

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

  public static void generateAndPrintSkyblockTasks(int skyblockRankupLevelsCount, int skyblockRankupTimeForFirstLevel,
      int skyblockRankupTimeForLastLevel, String mode) {

    Random random = new Random();
    LimitedCraftables limitedCraftables = new LimitedCraftables();

    for (int lvl = 1; lvl < skyblockRankupLevelsCount; lvl++) {
      setLevelForTasks(lvl);

      levelTime = skyblockRankupTimeForFirstLevel + (skyblockRankupTimeForLastLevel - skyblockRankupTimeForFirstLevel)
          * ((lvl - 1) / (double) (skyblockRankupLevelsCount - 1));

      printLevelTitle(mode);
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

        printTasksForLevel(mode);

        totalTimeForLevel += timeForTask * itemCountByTime;
      }
      printTotalTimeForLevel(mode);
      System.out.println();
    }
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

  private static void printTasksForLevel(String mode) {
    if (!mode.equals("file")) {
      switch (mode) {
        case "detailed" -> {
          switch (taskCategory) {
            case "DIG", "CRAFT", "FISH", "PLACE", "HAVE", "SMELT", "COOK" ->
              System.out.printf("%d. Type: %s; Amount: %.0f; Material: %s; (%.2f mins/item, %.2f mins total)\n",
                  taskNumber, taskCategory, itemCountByTime, itemName, timeForTask, timeForTask * itemCountByTime);
            case "KILL" ->
              System.out.printf("%d. Type: %s; Amount: %.0f; Entity: %s; (%.2f mins/item, %.2f mins total)\n",
                  taskNumber, taskCategory, itemCountByTime, itemName, timeForTask, timeForTask * itemCountByTime);
            default ->
              System.out.printf("%d. Type: %s; Amount: %.0f; (%.2f mins/item, %.2f mins total)\n",
                  taskNumber, taskCategory, itemCountByTime, timeForTask, timeForTask * itemCountByTime);
          }
        }

        case "clean" -> {
          switch (taskCategory) {
            case "DIG", "CRAFT", "FISH", "PLACE", "HAVE", "SMELT", "COOK" ->
              System.out.printf("%d. Type: %s; Amount: %.0f; Material: %s;\n",
                  taskNumber, taskCategory, itemCountByTime, itemName);
            case "KILL" ->
              System.out.printf("%d. Type: %s; Amount: %.0f; Entity: %s;\n",
                  taskNumber, taskCategory, itemCountByTime, itemName);
            default ->
              System.out.printf("%d. Type: %s; Amount: %.0f;\n",
                  taskNumber, taskCategory, itemCountByTime);
          }
        }

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
