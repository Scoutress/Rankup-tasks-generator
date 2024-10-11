package com.scoutress.constants.itemsByServers;

import com.scoutress.dto.Item;
import java.util.HashMap;
import java.util.List;

public class SkyblockItems {

	private static final HashMap<String, List<Item>> items = new HashMap<>();

	static {
		items.put("DIG", List.of(
				new Item("ITEM1", 1),
				new Item("ITEM2", 2)));

		items.put("KILL", List.of(
				new Item("ITEM1", 1),
				new Item("ITEM2", 2)));

		items.put("CRAFT", List.of(
				new Item("ITEM1", 1),
				new Item("ITEM2", 2)));

		items.put("FISH", List.of(
				new Item("ITEM1", 1),
				new Item("ITEM2", 2)));

		items.put("PLACE", List.of(
				new Item("ITEM1", 1),
				new Item("ITEM2", 2)));

		items.put("HAVE", List.of(
				new Item("ITEM1", 1),
				new Item("ITEM2", 2)));

		items.put("XP", List.of(
				new Item("ITEM1", 1),
				new Item("ITEM2", 2)));

		items.put("WALK", List.of(
				new Item("ITEM1", 1),
				new Item("ITEM2", 2)));

		items.put("SMELT", List.of(
				new Item("ITEM1", 1),
				new Item("ITEM2", 2)));

		items.put("COOK", List.of(
				new Item("ITEM1", 1),
				new Item("ITEM2", 2)));
	}

	public static List<Item> getItemsByCategory(String taskCategory) {
		List<Item> availableItems = items.get(taskCategory);

		if (availableItems == null || availableItems.isEmpty()) {
			throw new RuntimeException("No items found for category: " + taskCategory);
		}

		return availableItems;
	}
}
