package com.scoutress.utils;

import com.scoutress.constants.LimitedCraftables;

public class ItemCheckerByItemType {

  private static int itemCountByTime;

  LimitedCraftables lc = new LimitedCraftables();

  public int calculateItemsByGivenTime(
      String itemName, double requiredTimeForTask, double itemTime) {

    if (lc.getItemNames().contains(itemName)) {
      itemCountByTime = lc.getMaxQuantity();
      if (itemCountByTime == 0) {
        itemCountByTime += 1;
      }
    } else {
      itemCountByTime = (int) Math.round(requiredTimeForTask / itemTime);
      if (itemCountByTime == 0) {
        itemCountByTime += 1;
      }
    }
    return itemCountByTime;
  }
}
