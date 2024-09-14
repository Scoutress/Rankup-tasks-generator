package com.scoutress.utils;

import java.util.Random;

public class Rng {
  public static int generateRandomNumber(Integer min, Integer max) {

    int minValue = min;
    int maxValue = max;

    Random random = new Random();

    int randomValue = random.nextInt((maxValue - minValue) + 1) + minValue;

    return randomValue;
  }
}
