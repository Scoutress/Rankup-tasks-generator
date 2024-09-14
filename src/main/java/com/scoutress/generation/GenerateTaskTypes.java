package com.scoutress.generation;

import com.scoutress.constants.SurvivalTypesAndItems;
import com.scoutress.utils.Ui;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class GenerateTaskTypes {

  public static List<String> generateSurvivalTaskTypes(List<String> list) {
    List<String> tasks = new ArrayList<>();
    Random rng = new Random();
    Map<String, Integer> typeCount = new HashMap<>();
    Set<String> taskSet = new HashSet<>();

    while (tasks.size() < 10) {
      String randomTaskType;
      do {
        randomTaskType = SurvivalTypesAndItems.getAllSurvivalTypesList()
            .get(rng.nextInt(SurvivalTypesAndItems.getAllSurvivalTypesList().size()));
      } while (typeCount.containsKey(randomTaskType) && typeCount.get(randomTaskType) >= 3);
      typeCount.put(randomTaskType, typeCount.getOrDefault(randomTaskType, 0) + 1);

      List<String> taskItems = SurvivalTypesAndItems.getTaskItems(randomTaskType);
      String randomTaskItem;
      do {
        randomTaskItem = taskItems.get(rng.nextInt(taskItems.size()));
      } while (taskSet.contains(randomTaskType + " " + randomTaskItem));
      taskSet.add(randomTaskType + " " + randomTaskItem);

      tasks.add(randomTaskType + " " + randomTaskItem);
    }
    return tasks;
  }

  public static void generateAndPrintSurvivalTasks() {
    for (int i = 2; i <= 13; i++) {
      List<String> levelTasks = generateSurvivalTaskTypes(SurvivalTypesAndItems.getAllSurvivalTypesList());
      Ui.printTasksWithNumbers("To level " + i, levelTasks);
    }
  }
}
