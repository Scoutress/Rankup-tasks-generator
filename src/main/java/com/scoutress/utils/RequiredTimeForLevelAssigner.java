package com.scoutress.utils;

import com.scoutress.Controller;

public class RequiredTimeForLevelAssigner {

  public double calculateTimeRequiredForLevel(String server, int level) {

    Controller ctrl = new Controller();

    int survivalRankupTimeForFirstLevel = ctrl.survivalFirstLevelTime;
    int survivalRankupTimeForLastLevel = ctrl.survivalLastLevelTime;
    int survivalRankupLevelsCount = ctrl.survivalRankupLevels;
    int skyblockRankupTimeForFirstLevel = ctrl.skyblockFirstLevelTime;
    int skyblockRankupTimeForLastLevel = ctrl.skyblockLastLevelTime;
    int skyblockRankupLevelsCount = ctrl.skyblockRankupLevels;
    int prisonRankupTimeForFirstLevel = ctrl.prisonFirstLevelTime;
    int prisonRankupTimeForLastLevel = ctrl.prisonLastLevelTime;
    int prisonRankupLevelsCount = ctrl.prisonRankupLevels;

    double timeForFirstLevel = 0;
    double timeForLastLevel = 0;
    int levelsCount = 0;

    switch (server) {
      case "survival" -> {
        timeForFirstLevel = survivalRankupTimeForFirstLevel;
        timeForLastLevel = survivalRankupTimeForLastLevel;
        levelsCount = survivalRankupLevelsCount;
      }

      case "skyblock" -> {
        timeForFirstLevel = skyblockRankupTimeForFirstLevel;
        timeForLastLevel = skyblockRankupTimeForLastLevel;
        levelsCount = skyblockRankupLevelsCount;
      }

      case "prison" -> {
        timeForFirstLevel = prisonRankupTimeForFirstLevel;
        timeForLastLevel = prisonRankupTimeForLastLevel;
        levelsCount = prisonRankupLevelsCount;
      }
    }

    double levelTime = timeForFirstLevel +
        (timeForLastLevel - timeForFirstLevel) *
            ((level - 1) / (double) (levelsCount - 2));

    return levelTime;
  }
}
