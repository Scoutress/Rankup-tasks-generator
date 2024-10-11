package com.scoutress;

public class UI {

  public void printLevelTitle(String mode, int level) {
    if (!mode.equals("file")) {
      System.out.printf("Level: %d\n", level);
    }
  }

  public void printTasksForLevel(String server, String mode, int taskNumber, String taskCategory, String itemDifficulty,
      String itemName, double itemCountByTime, double timeForTask, double totalTimeForLevel) {

    if (!mode.equals("file")) {

      switch (server) {

        case "Survival" -> printTasksForSurvivalLevels(
            mode, taskCategory, taskNumber, itemCountByTime,
            timeForTask, totalTimeForLevel, itemName, itemDifficulty);

        case "Skyblock" -> printTasksForSkyblockLevels(
            mode, taskCategory, taskNumber, itemCountByTime,
            timeForTask, totalTimeForLevel, itemName);

        case "Prison" -> printTasksForPrisonLevels(
            mode, taskCategory, taskNumber, itemCountByTime,
            timeForTask, totalTimeForLevel, itemName);

        default -> printWrongServerForTasks();
      }
    }
  }

  public void printTasksForSurvivalLevels(
      String mode, String taskCategory, int taskNumber, double itemCountByTime,
      double timeForTask, double totalTimeForLevel, String itemName, String itemDifficulty) {
    switch (mode) {

      case "detailed" -> printTasksForSurvivalLevelDetailed(
          taskCategory, taskNumber, itemCountByTime,
          timeForTask, totalTimeForLevel, itemName, itemDifficulty);

      case "clean" -> printTasksForSurvivalLevelClean(
          taskCategory, taskNumber, itemCountByTime,
          timeForTask, totalTimeForLevel, itemName);

      default -> printWrongModeForTasks();
    }
  }

  public void printTasksForSkyblockLevels(
      String mode, String taskCategory, int taskNumber, double itemCountByTime,
      double timeForTask, double totalTimeForLevel, String itemName) {
    switch (mode) {
      case "detailed" -> printTasksForSkyblockLevelDetailed(
          taskCategory, taskNumber, itemCountByTime,
          timeForTask, totalTimeForLevel, itemName);

      case "clean" -> printTasksForSkyblockLevelClean(
          taskCategory, taskNumber, itemCountByTime,
          timeForTask, totalTimeForLevel, itemName);

      default -> printWrongModeForTasks();
    }
  }

  public void printTasksForPrisonLevels(
      String mode, String taskCategory, int taskNumber, double itemCountByTime,
      double timeForTask, double totalTimeForLevel, String itemName) {

    switch (mode) {
      case "detailed" -> printTasksForPrisonLevelDetailed(
          taskCategory, taskNumber, itemCountByTime,
          timeForTask, totalTimeForLevel, itemName);

      case "clean" -> printTasksForPrisonLevelClean(
          taskCategory, taskNumber, itemCountByTime,
          timeForTask, totalTimeForLevel, itemName);

      default -> printWrongModeForTasks();
    }
  }

  public void printTasksForSurvivalLevelDetailed(
      String taskCategory, int taskNumber, double itemCountByTime,
      double timeForTask, double totalTimeForLevel, String itemName, String itemDifficulty) {

    System.out.printf("%d. %s %s %s %.0f items (%.2f mins/item, %.2f mins total)\n",
        taskNumber, taskCategory, itemDifficulty, itemName, itemCountByTime, timeForTask,
        totalTimeForLevel);
  }

  public void printTasksForSurvivalLevelClean(
      String taskCategory, int taskNumber, double itemCountByTime,
      double timeForTask, double totalTimeForLevel, String itemName) {

    System.out.printf("%d. %s %s %.0f\n", taskNumber, taskCategory, itemName, itemCountByTime);
  }

  public void printTasksForSkyblockLevelDetailed(
      String taskCategory, int taskNumber, double itemCountByTime,
      double timeForTask, double totalTimeForLevel, String itemName) {

    switch (taskCategory) {

      case "DIG", "CRAFT", "FISH", "PLACE", "HAVE", "SMELT", "COOK" ->
        System.out.printf("%d. Type: %s; Amount: %.0f; Material: %s; (%.2f mins/item, %.2f mins total)\n",
            taskNumber, taskCategory, itemCountByTime, itemName, timeForTask, totalTimeForLevel);

      case "KILL" ->
        System.out.printf("%d. Type: %s; Amount: %.0f; Entity: %s; (%.2f mins/item, %.2f mins total)\n",
            taskNumber, taskCategory, itemCountByTime, itemName, timeForTask, totalTimeForLevel);

      default ->
        System.out.printf("%d. Type: %s; Amount: %.0f; (%.2f mins/item, %.2f mins total)\n",
            taskNumber, taskCategory, itemCountByTime, timeForTask, totalTimeForLevel);
    }
  }

  public void printTasksForSkyblockLevelClean(
      String taskCategory, int taskNumber, double itemCountByTime,
      double timeForTask, double totalTimeForLevel, String itemName) {

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

  public void printTasksForPrisonLevelDetailed(
      String taskCategory, int taskNumber, double itemCountByTime,
      double timeForTask, double totalTimeForLevel, String itemName) {

    if (taskCategory.equals("placefood") ||
        taskCategory.equals("cleanplate") ||
        taskCategory.equals("cleantoilets") ||
        taskCategory.equals("placedoctor")) {
      System.out.printf("%d. %s %.0f items (%.2f mins/item, %.2f mins total)\n",
          taskNumber, taskCategory, itemCountByTime, timeForTask,
          totalTimeForLevel);

    } else {
      System.out.printf("%d. %s %s %.0f items (%.2f mins/item, %.2f mins total)\n",
          taskNumber, taskCategory, itemName, itemCountByTime, timeForTask,
          totalTimeForLevel);
    }
  }

  public void printTasksForPrisonLevelClean(
      String taskCategory, int taskNumber, double itemCountByTime,
      double timeForTask, double totalTimeForLevel, String itemName) {

    if (taskCategory.equals("placefood") ||
        taskCategory.equals("cleanplate") ||
        taskCategory.equals("cleantoilets") ||
        taskCategory.equals("placedoctor")) {
      System.out.printf("%d. %s %.0f\n", taskNumber, taskCategory, itemCountByTime);

    } else {
      System.out.printf("%d. %s %s %.0f\n", taskNumber, taskCategory, itemName, itemCountByTime);
    }
  }

  public void printTotalTimeForLevel(String mode, double totalTimeForLevel) {
    double totalHours = totalTimeForLevel / 60;
    double totalDays = totalHours / 8;

    if (!mode.equals("file")) {
      System.out.printf("Total: %.2f mins (%.2f hours, %.2f days)\n",
          totalTimeForLevel, totalHours, totalDays);
    }
  }

  public void printWrongModeForTasks() {
    System.out.println("Wrong mode");
  }

  public void printWrongServerForTasks() {
    System.out.println("Wrong server");
  }
}
