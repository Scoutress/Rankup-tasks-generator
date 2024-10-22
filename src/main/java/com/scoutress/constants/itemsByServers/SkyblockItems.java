package com.scoutress.constants.itemsByServers;

import java.util.HashMap;
import java.util.List;

import com.scoutress.dto.Item;

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

		items.put("SWIM_WITH_BOAT", List.of(
				new Item("ITEM1", 1),
				new Item("ITEM2", 2)));

		items.put("RIDE_PIG", List.of(
				new Item("ITEM1", 1),
				new Item("ITEM2", 2)));

		items.put("RIDE_HORSE", List.of(
				new Item("ITEM1", 1),
				new Item("ITEM2", 2)));

		items.put("SWIM", List.of(
				new Item("ITEM1", 1),
				new Item("ITEM2", 2)));

		items.put("FLY_ELYTRA", List.of(
				new Item("ITEM1", 1),
				new Item("ITEM2", 2)));

		items.put("SMELT", List.of(
				new Item("ITEM1", 1),
				new Item("ITEM2", 2)));

		items.put("COOK", List.of(
				new Item("ITEM1", 1),
				new Item("ITEM2", 2)));
	}

	public List<Item> getItemsByCategory(String taskCategory, String difficulty) {
		List<Item> availableItems = items.get(taskCategory);

		return availableItems;
	}
}
