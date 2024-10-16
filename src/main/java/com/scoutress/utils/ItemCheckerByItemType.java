package com.scoutress.utils;

import com.scoutress.constants.LimitedCraftables;

public class ItemCheckerByItemType {

  private static int itemCountByTime;

  LimitedCraftables lc = new LimitedCraftables();

  public int calculateItemsByGivenTime(
      String itemName, double requiredTimeForTask, double itemTime) {

    if (lc.getItemNames().contains(itemName)) {
      itemCountByTime = lc.getMaxQuantity();
    } else {
      itemCountByTime = (int) (requiredTimeForTask / itemTime);
    }
    return itemCountByTime;
  }
}
