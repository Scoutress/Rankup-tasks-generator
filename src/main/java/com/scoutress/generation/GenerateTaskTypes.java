package com.scoutress.generation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GenerateTaskTypes {

  private final List<String> allSurvivalTypesList;

  public GenerateTaskTypes() {
    allSurvivalTypesList = new ArrayList<>();
    allSurvivalTypesList.add("DIG");
    allSurvivalTypesList.add("KILL");
    allSurvivalTypesList.add("FURNACE");
    allSurvivalTypesList.add("CRAFT");
    allSurvivalTypesList.add("FISH");
    allSurvivalTypesList.add("PLACE");
    allSurvivalTypesList.add("HAVE");
    System.out.println("test");
  }

  public List<String> getAllSurvivalTypesList() {
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
}
