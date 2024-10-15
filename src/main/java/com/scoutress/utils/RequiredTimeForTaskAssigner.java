package com.scoutress.utils;

public class RequiredTimeForTaskAssigner {

  double timeForTask;

  public double calculateTimeRequiredForTask(String server, String difficulty, double levelTime) {
    switch (difficulty) {
      case "easy" -> {
        timeForTask = levelTime * 0.12;
      }
      case "hard" -> {
        timeForTask = levelTime * 0.053;
      }
      default -> {
        switch (server) {
          case "survival", "prison" -> {
            timeForTask = levelTime * 0.1;
          }
          case "skyblock" -> {
            timeForTask = levelTime * 0.125;
          }
        }
      }
    }
    return timeForTask;
  }
}
