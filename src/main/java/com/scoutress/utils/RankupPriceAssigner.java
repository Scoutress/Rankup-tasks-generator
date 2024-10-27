package com.scoutress.utils;

public class RankupPriceAssigner {

  public double setRankupPrice(int level, int basePrice) {
    double price = level * basePrice;
    return price;
  }

}
