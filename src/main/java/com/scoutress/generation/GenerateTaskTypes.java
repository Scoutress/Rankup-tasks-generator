package com.scoutress.generation;

import com.scoutress.utils.Ui;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GenerateTaskTypes {

  private static final List<String> allSurvivalTypesList = Arrays.asList("DIG", "KILL", "FURNACE", "CRAFT", "FISH",
      "PLACE", "HAVE");

  public static List<String> getAllSurvivalTypesList() {
    return allSurvivalTypesList;
  }

  public static List<String> generateSurvivalTaskTypes(List<String> list) {
    List<String> tasks = new ArrayList<>(list);
    Random rng = new Random();

    while (tasks.size() < 10) {
      String randomTask = list.get(rng.nextInt(list.size()));
      if (Collections.frequency(tasks, randomTask) < 3) {
        tasks.add(randomTask);
      }
    }

    return tasks;
  }

  public static void generateAndPrintSurvivalTasks() {
    List<String> taskList = getAllSurvivalTypesList();
    for (int i = 2; i <= 13; i++) {
      List<String> levelTasks = generateSurvivalTaskTypes(taskList);
      Ui.printTasksWithNumbers("To level " + i, levelTasks);
    }
  }
}
