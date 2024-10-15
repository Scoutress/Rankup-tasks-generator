package com.scoutress.utils;

import com.scoutress.constants.itemsByServers.PrisonItems;
import com.scoutress.constants.itemsByServers.SkyblockItems;
import com.scoutress.constants.itemsByServers.SurvivalItems;
import com.scoutress.dto.Item;
import java.util.List;
import java.util.Random;

public class ItemDataPicker {

  public Item getItemData(String server, String category, String difficulty) {

    List<Item> availableItems = null;

    switch (server) {
      case "survival" -> {
        SurvivalItems sui = new SurvivalItems();
        availableItems = sui.getItemsByCategory(category, difficulty);
      }

      case "skyblock" -> {
        SkyblockItems ski = new SkyblockItems();
        availableItems = ski.getItemsByCategory(category, difficulty);
      }

      case "prison" -> {
        PrisonItems pi = new PrisonItems();
        availableItems = pi.getItemsByCategory(category, difficulty);
      }

    }

    if (availableItems == null || availableItems.isEmpty()) {
      throw new RuntimeException("No items found for the given category and difficulty.");
    }

    return availableItems.get(new Random().nextInt(availableItems.size()));
  }
}
