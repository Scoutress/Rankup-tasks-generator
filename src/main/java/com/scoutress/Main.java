package com.scoutress;

import com.scoutress.generation.GenerateTaskTypes;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    GenerateTaskTypes generator = new GenerateTaskTypes();
    List<String> tasks = generator.getAllSurvivalTypesList();
    List<String> finalTasks = GenerateTaskTypes.generateSurvivalTaskTypes(tasks);
    for (int i = 0; i < finalTasks.size(); i++) {
      System.out.println((i + 1) + ". " + finalTasks.get(i));
    }
  }
}