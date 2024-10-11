package com.scoutress.servers;

import com.scoutress.constants.LimitedCraftables;
import com.scoutress.constants.itemsByServers.PrisonItems;
import com.scoutress.dto.Item;
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
  private static final LimitedCraftables limitedCraftables = new LimitedCraftables();

  public static void generateAndPrintPrisonTasks(int prisonRankupLevelsCount, int prisonRankupTimeForFirstLevel,
      int prisonRankupTimeForLastLevel, String mode) {

    for (int lvl = 1; lvl < prisonRankupLevelsCount; lvl++) {
      setLevelForTasks(lvl);

      levelTime = prisonRankupTimeForFirstLevel + (prisonRankupTimeForLastLevel - prisonRankupTimeForFirstLevel)
          * ((lvl - 1) / (double) (prisonRankupLevelsCount - 1));

      printLevelTitle(mode);
      totalTimeForLevel = 0;

      for (int currentTaskNumber = 1; currentTaskNumber <= 10; currentTaskNumber++) {
        setTaskNumberForLevel(currentTaskNumber);

        switch (currentTaskNumber) {
          case 1 -> taskCategory = "dig";
          case 2 -> taskCategory = "kill";
          case 3 -> taskCategory = "furnace";
          case 4 -> taskCategory = "craft";
          case 5 -> taskCategory = "placedoctor";
          case 6 -> taskCategory = "cleantoilets";
          case 7 -> taskCategory = "cleanplate";
          case 8 -> taskCategory = "placefood";
          case 9 -> taskCategory = "have";
          case 10 -> taskCategory = "fish";
        }

        List<Item> itemList = PrisonItems.getItemsByCategory(taskCategory);

        List<Item> filteredItems = filterItemsByLevel(itemList, lvl);

        if (filteredItems.isEmpty()) {
          System.out.printf("No items found for category '%s' at level %d. Skipping task %d.\n", taskCategory, lvl,
              currentTaskNumber);
          continue;
        }

        Item item = getRandomItem(filteredItems);
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

  private static void printLevelTitle(String mode) {
    if (!mode.equals("file")) {
      System.out.printf("Level: %d\n", level);
    }
  }

  private static void printTasksForLevel(String mode) {
    if (!mode.equals("file")) {
      switch (mode) {
        case "detailed" -> {
          if (taskCategory.equals("placefood") ||
              taskCategory.equals("cleanplate") ||
              taskCategory.equals("cleantoilets") ||
              taskCategory.equals("placedoctor")) {
            System.out.printf("%d. %s %.0f items (%.2f mins/item, %.2f mins total)\n",
                taskNumber, taskCategory, itemCountByTime, timeForTask,
                timeForTask * itemCountByTime);
          } else {
            System.out.printf("%d. %s %s %.0f items (%.2f mins/item, %.2f mins total)\n",
                taskNumber, taskCategory, itemName, itemCountByTime, timeForTask,
                timeForTask * itemCountByTime);
          }
        }

        case "clean" -> {
          if (taskCategory.equals("placefood") ||
              taskCategory.equals("cleanplate") ||
              taskCategory.equals("cleantoilets") ||
              taskCategory.equals("placedoctor")) {
            System.out.printf("%d. %s %.0f\n", taskNumber, taskCategory, itemCountByTime);
          } else {
            System.out.printf("%d. %s %s %.0f\n", taskNumber, taskCategory, itemName, itemCountByTime);
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
