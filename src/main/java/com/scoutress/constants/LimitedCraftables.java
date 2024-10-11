package com.scoutress.constants;

import java.util.ArrayList;
import java.util.List;

public class LimitedCraftables {
  private static final int MAX_QUANTITY = 5;
  private final List<String> itemNames;

  public LimitedCraftables() {
    itemNames = new ArrayList<>();
    initializeItems();
  }

  private void initializeItems() {
    itemNames.add("WOODEN_SHOVEL");
    itemNames.add("STONE_SHOVEL");
    itemNames.add("IRON_SHOVEL");
    itemNames.add("GOLDEN_SHOVEL");
    itemNames.add("DIAMOND_SHOVEL");
    itemNames.add("NETHERITE_SHOVEL");
    itemNames.add("WOODEN_PICKAXE");
    itemNames.add("STONE_PICKAXE");
    itemNames.add("IRON_PICKAXE");
    itemNames.add("GOLDEN_PICKAXE");
    itemNames.add("DIAMOND_PICKAXE");
    itemNames.add("NETHERITE_PICKAXE");
    itemNames.add("WOODEN_AXE");
    itemNames.add("STONE_AXE");
    itemNames.add("IRON_AXE");
    itemNames.add("GOLDEN_AXE");
    itemNames.add("DIAMOND_AXE");
    itemNames.add("NETHERITE_AXE");
    itemNames.add("WOODEN_SWORD");
    itemNames.add("STONE_SWORD");
    itemNames.add("IRON_SWORD");
    itemNames.add("GOLDEN_SWORD");
    itemNames.add("DIAMOND_SWORD");
    itemNames.add("NETHERITE_SWORD");
    itemNames.add("FISHING_ROD");
    itemNames.add("BOW");
    itemNames.add("CROSSBOW");
    itemNames.add("SHEARS");
    itemNames.add("FLINT_AND_STEEL");
    itemNames.add("COMPASS");
    itemNames.add("CLOCK");
    itemNames.add("LEATHER_HELMET");
    itemNames.add("IRON_HELMET");
    itemNames.add("GOLDEN_HELMET");
    itemNames.add("DIAMOND_HELMET");
    itemNames.add("NETHERITE_HELMET");
    itemNames.add("LEATHER_CHESTPLATE");
    itemNames.add("IRON_CHESTPLATE");
    itemNames.add("GOLDEN_CHESTPLATE");
    itemNames.add("DIAMOND_CHESTPLATE");
    itemNames.add("NETHERITE_CHESTPLATE");
    itemNames.add("LEATHER_LEGGINGS");
    itemNames.add("IRON_LEGGINGS");
    itemNames.add("GOLDEN_LEGGINGS");
    itemNames.add("DIAMOND_LEGGINGS");
    itemNames.add("NETHERITE_LEGGINGS");
    itemNames.add("LEATHER_BOOTS");
    itemNames.add("IRON_BOOTS");
    itemNames.add("GOLDEN_BOOTS");
    itemNames.add("DIAMOND_BOOTS");
    itemNames.add("NETHERITE_BOOTS");
    itemNames.add("SHIELD");
  }

  public List<String> getItemNames() {
    return itemNames;
  }

  public int getMaxQuantity() {
    return MAX_QUANTITY;
  }
}
