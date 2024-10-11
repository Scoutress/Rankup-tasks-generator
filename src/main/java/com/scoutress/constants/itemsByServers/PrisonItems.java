package com.scoutress.constants.itemsByServers;

import com.scoutress.dto.Item;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class PrisonItems {

	private static final HashMap<String, List<Item>> items = new HashMap<>();

	static {
		items.put("dig", List.of(
				new Item("BIRCH_LOG", 0.02, 'A'),
				new Item("COBBLESTONE", 0.02, 'A'),
				new Item("COAL_ORE", 0.03, 'B'),
				new Item("IRON_ORE", 0.07, 'B'),
				new Item("COPPER_ORE", 0.05, 'D'),
				new Item("LAPIS_ORE", 0.08, 'F'),
				new Item("GOLD_ORE", 0.09, 'H'),
				new Item("REDSTONE_ORE", 0.2, 'J'),
				new Item("DIAMOND_ORE", 0.21, 'L'),
				new Item("BAMBOO", 0.02, 'L'),
				new Item("OAK_LOG", 0.03, 'O'),
				new Item("GLOWSTONE", 0.04, 'Q'),
				new Item("NETHER_QUARTZ_ORE", 0.12, 'Q'),
				new Item("ANCIENT_DEBRIS", 0.5, 'Q')));

		items.put("kill", List.of(
				new Item("PLAYER", 60, 'A')));

		items.put("furnace", List.of(
				new Item("IRON_INGOT", 5, 'A'),
				new Item("GOLD_INGOT", 5, 'A'),
				new Item("COPPER_INGOT", 5, 'A'),
				new Item("GOLD_NUGGET", 5, 'A'),
				new Item("NETHERITE_SCRAP", 5, 'A'),
				new Item("STONE", 5, 'A')));

		items.put("craft", List.of(
				new Item("WOODEN_PICKAXE", 1, 'A'),
				new Item("WOODEN_AXE", 1, 'A'),
				new Item("WOODEN_SWORD", 1, 'A'),
				new Item("STONE_PICKAXE", 1, 'A'),
				new Item("STONE_AXE", 1, 'A'),
				new Item("STONE_SWORD", 1, 'A'),
				new Item("IRON_PICKAXE", 2, 'A'),
				new Item("IRON_AXE", 2, 'A'),
				new Item("IRON_SWORD", 2, 'A'),
				new Item("GOLDEN_PICKAXE", 5, 'A'),
				new Item("GOLDEN_AXE", 5, 'A'),
				new Item("GOLDEN_SWORD", 5, 'A'),
				new Item("DIAMOND_PICKAXE", 10, 'A'),
				new Item("DIAMOND_AXE", 10, 'A'),
				new Item("DIAMOND_SWORD", 10, 'A'),
				new Item("OAK_PLANKS", 1, 'A'),
				new Item("BIRCH_PLANKS", 1, 'A'),
				new Item("STICK", 1, 'A'),
				new Item("SHIELD", 2, 'A'),
				new Item("BOW", 250, 'W'),
				new Item("CROSSBOW", 200, 'W'),
				new Item("FISHING_ROD", 175, 'T'),
				new Item("GOLDEN_APPLE", 5, 'Q')));

		items.put("fish", List.of(
				new Item("RAW_COD", 0.57, 'S'),
				new Item("RAW_SALMON", 1.38, 'S'),
				new Item("TROPICAL_FISH", 17.16, 'S'),
				new Item("PUFFERFISH", 2.64, 'S'),
				new Item("BOW", 21.60, 'S'),
				new Item("ENCHANTED_BOOK", 21.60, 'S'),
				new Item("NAME_TAG", 21.60, 'S'),
				new Item("NAUTILUS_SHELL", 21.60, 'S'),
				new Item("SADDLE", 21.60, 'S'),
				new Item("LILY_PAD", 24.31, 'S'),
				new Item("BOWL", 41.67, 'S'),
				new Item("FISHING_ROD", 150, 'S'),
				new Item("LEATHER", 41.67, 'S'),
				new Item("LEATHER_BOOTS", 41.67, 'S'),
				new Item("ROTTEN_FLESH", 41.67, 'S'),
				new Item("STICK", 83.33, 'S'),
				new Item("STRING", 83.33, 'S'),
				new Item("WATER_BOTTLE", 41.67, 'S'),
				new Item("BONE", 41.67, 'S'),
				new Item("INK_SAC", 416.67, 'S'),
				new Item("TRIPWIRE_HOOK", 41.67, 'S')));

		items.put("have", List.of(
				new Item("BIRCH_LOG", 1, 'A'),
				new Item("COBBLESTONE", 2, 'A'),
				new Item("COAL_ORE", 3, 'B'),
				new Item("IRON_ORE", 4, 'B'),
				new Item("COPPER_ORE", 5, 'D'),
				new Item("LAPIS_ORE", 6, 'F'),
				new Item("GOLD_ORE", 7, 'H'),
				new Item("REDSTONE_ORE", 8, 'J'),
				new Item("DIAMOND_ORE", 9, 'L'),
				new Item("BAMBOO", 10, 'L'),
				new Item("OAK_LOG", 11, 'O'),
				new Item("GLOWSTONE", 12, 'Q'),
				new Item("NETHER_QUARTZ_ORE", 13, 'Q'),
				new Item("ANCIENT_DEBRIS", 14, 'Q')));

		items.put("placefood", List.of(
				new Item("noname", 0.2, 'A')));

		items.put("cleanplate", List.of(
				new Item("noname", 0.2, 'A')));

		items.put("cleantoilets", List.of(
				new Item("noname", 0.1, 'A')));

		items.put("placedoctor", List.of(
				new Item("noname", 0.1, 'A')));
	}

	public static Item getRandomPrisonItem(String category, String difficulty) {
		String key = category + "_" + (difficulty.equals("easy") ? "ez" : "hd");
		List<Item> availableItems = items.get(key);

		if (availableItems == null || availableItems.isEmpty()) {
			throw new RuntimeException("No items found for category: " + key);
		}

		return availableItems.get(new Random().nextInt(availableItems.size()));
	}
}
