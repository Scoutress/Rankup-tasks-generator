package com.scoutress.utils;

import java.util.Random;

import com.scoutress.dto.RewardResult;

public class LimitsRewardPicker {

  public RewardResult pickLimitsRewardForOneSkyblockLevel(
      int spawnersAmountSum, int robotsAmountSum, int villagersAmountSum,
      int minecartHoppersAmountSum, int pistonsAmountSum, int stickyPistonsAmountSum,
      int hoppersAmountSum, int animalsAmountSum) {

    Random random = new Random();
    String rewardName = null;
    int rewardValue = 0;

    boolean rewardSelected = false;
    while (!rewardSelected) {
      int limitName = random.nextInt(8) + 1;

      switch (limitName) {
        case 1 -> {
          if (spawnersAmountSum > 0) {
            rewardName = "SPAWNERS";
            rewardValue = spawnersAmountSum - 1;
            rewardSelected = true;
          }
        }
        case 2 -> {
          if (robotsAmountSum > 0) {
            rewardName = "ROBOTS";
            rewardValue = robotsAmountSum - 1;
            rewardSelected = true;
          }
        }
        case 3 -> {
          if (villagersAmountSum > 0) {
            rewardName = "VILLAGERS";
            rewardValue = villagersAmountSum - 1;
            rewardSelected = true;
          }
        }
        case 4 -> {
          if (minecartHoppersAmountSum > 0) {
            rewardName = "MINECART_HOPPERS";
            rewardValue = minecartHoppersAmountSum - 1;
            rewardSelected = true;
          }
        }
        case 5 -> {
          if (pistonsAmountSum > 0) {
            rewardName = "PISTONS";
            rewardValue = pistonsAmountSum - 1;
            rewardSelected = true;
          }
        }
        case 6 -> {
          if (stickyPistonsAmountSum > 0) {
            rewardName = "STICKY_PISTONS";
            rewardValue = stickyPistonsAmountSum - 1;
            rewardSelected = true;
          }
        }
        case 7 -> {
          if (hoppersAmountSum > 0) {
            rewardName = "HOPPERS";
            rewardValue = hoppersAmountSum - 1;
            rewardSelected = true;
          }
        }
        case 8 -> {
          if (animalsAmountSum > 0) {
            rewardName = "ANIMALS";
            rewardValue = animalsAmountSum - 1;
            rewardSelected = true;
          }
        }
      }
    }

    return new RewardResult(rewardName, rewardValue);
  }
}
