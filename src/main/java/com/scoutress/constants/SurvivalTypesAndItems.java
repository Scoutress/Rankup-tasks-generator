package com.scoutress.constants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SurvivalTypesAndItems {

	public static List<String> getAllSurvivalTypesList() {
		return allSurvivalTypesList;
	}

	public static Map<String, List<ItemTime>> getTaskItemsMap() {
		return taskItemsMap;
	}

	public static List<ItemTime> getTaskItems(String type) {
		return taskItemsMap.get(type);
	}

	private static final List<String> allSurvivalTypesList = Arrays.asList(
			"dig", "kill", "furnace", "craft", "fish", "place", "have");

	private static final Map<String, List<ItemTime>> taskItemsMap = new HashMap<>();
	static {
		taskItemsMap.put("dig", Arrays.asList(
				new ItemTime("ACACIA_LOG", 3.5),
				new ItemTime("ACACIA_WOOD", 3.5),
				new ItemTime("AMETHYST_CLUSTER", 17.5),
				new ItemTime("ANDESITE", 0.58),
				new ItemTime("AZALEA_LEAVES", 3.5),
				new ItemTime("BAMBOO", 5.83),
				new ItemTime("BEE_NEST", 8.75),
				new ItemTime("BELL", 35),
				new ItemTime("BIG_DRIPLEAF", 17.5),
				new ItemTime("BIRCH_LEAVES", 1.75),
				new ItemTime("BIRCH_LOG", 1.75),
				new ItemTime("BLACK_TERRACOTTA", 17.5),
				new ItemTime("BLOCK_OF_AMETHYST", 17.5),
				new ItemTime("BLOCK_OF_RAW_COPPER", 8.75),
				new ItemTime("BLOCK_OF_RAW_IRON", 8.75),
				new ItemTime("BLUE_ICE", 35),
				new ItemTime("BLUE_TERRACOTTA", 17.5),
				new ItemTime("BONE_BLOCK", 17.5),
				new ItemTime("BOOKSHELF", 35),
				new ItemTime("BRAIN_CORAL", 35),
				new ItemTime("BRAIN_CORAL_BLOCK", 35),
				new ItemTime("BRICKS", 35),
				new ItemTime("BROWN_MUSHROOM", 5.83),
				new ItemTime("BROWN_MUSHROOM_BLOCK", 8.75),
				new ItemTime("BROWN_TERRACOTTA", 17.5),
				new ItemTime("BUBBLE_CORAL", 35),
				new ItemTime("BUBBLE_CORAL_BLOCK", 35),
				new ItemTime("BUDDING_AMETHYST", 17.5),
				new ItemTime("CACTUS", 5.83),
				new ItemTime("CALCITE", 17.5),
				new ItemTime("CHEST", 8.75),
				new ItemTime("CHISELED_STONE_BRICKS", 17.5),
				new ItemTime("CYAN_TERRACOTTA", 17.5),
				new ItemTime("CLAY_BLOCK", 3.5),
				new ItemTime("COAL_ORE", 0.58),
				new ItemTime("COARSE_DIRT", 3.5),
				new ItemTime("COBBLED_DEEPSLATE", 0.88),
				new ItemTime("COBBLESTONE", 0.58),
				new ItemTime("COBWEB", 35),
				new ItemTime("COCOA", 5.83),
				new ItemTime("COPPER_ORE", 3.5),
				new ItemTime("CRACKED_STONE_BRICKS", 17.5),
				new ItemTime("CRYING_OBSIDIAN", 35),
				new ItemTime("DARK_OAK_LEAVES", 3.5),
				new ItemTime("DARK_OAK_LOG", 3.5),
				new ItemTime("DARK_PRISMARINE", 35),
				new ItemTime("DEEPSLATE", 0.88),
				new ItemTime("DEEPSLATE_COAL_ORE", 3.5),
				new ItemTime("DEEPSLATE_COPPER_ORE", 3.5),
				new ItemTime("DEEPSLATE_DIAMOND_ORE", 17.5),
				new ItemTime("DEEPSLATE_EMERALD_ORE", 35),
				new ItemTime("DEEPSLATE_GOLD_ORE", 17.5),
				new ItemTime("DEEPSLATE_IRON_ORE", 3.5),
				new ItemTime("DEEPSLATE_LAPIS_LAZULI_ORE", 17.5),
				new ItemTime("DEEPSLATE_REDSTONE_ORE", 17.5),
				new ItemTime("DIAMOND_ORE", 17.5),
				new ItemTime("DIORITE", 0.58),
				new ItemTime("DIRT", 0.35),
				new ItemTime("DIRT_PATH", 8.75),
				new ItemTime("DRIPSTONE_BLOCK", 3.5),
				new ItemTime("EMERALD_ORE", 35),
				new ItemTime("FARMLAND", 8.75),
				new ItemTime("FIRE_CORAL", 35),
				new ItemTime("FIRE_CORAL_BLOCK", 35),
				new ItemTime("FLOWERING_AZALEA_LEAVES", 3.5),
				new ItemTime("GLOW_LICHEN", 3.5),
				new ItemTime("GOLD_ORE", 3.5),
				new ItemTime("GRAY_TERRACOTTA", 17.5),
				new ItemTime("GRANITE", 0.58),
				new ItemTime("GRASS", 0.35),
				new ItemTime("GRASS_BLOCK", 0.35),
				new ItemTime("GRAVEL", 0.58),
				new ItemTime("GREEN_TERRACOTTA", 17.5),
				new ItemTime("HAY_BALE", 17.5),
				new ItemTime("HANGING_ROOTS", 3.5),
				new ItemTime("HORN_CORAL", 35),
				new ItemTime("HORN_CORAL_BLOCK", 35),
				new ItemTime("ICE", 3.5),
				new ItemTime("YELLOW_TERRACOTTA", 17.5),
				new ItemTime("INFESTED_CHISELED_STONE_BRICKS", 35),
				new ItemTime("INFESTED_COBBLESTONE", 35),
				new ItemTime("INFESTED_MOSSY_STONE_BRICKS", 35),
				new ItemTime("INFESTED_STONE_BRICKS", 35),
				new ItemTime("IRON_BARS", 35),
				new ItemTime("IRON_ORE", 0.58),
				new ItemTime("JUNGLE_LEAVES", 3.5),
				new ItemTime("JUNGLE_LOG", 3.5),
				new ItemTime("KELP", 3.5),
				new ItemTime("LAPIS_LAZULI_ORE", 8.75),
				new ItemTime("LARGE_AMETHYST_BUD", 17.5),
				new ItemTime("LIGHT_GRAY_TERRACOTTA", 17.5),
				new ItemTime("LILY_PAD", 5.83),
				new ItemTime("LIME_TERRACOTTA", 17.5),
				new ItemTime("MANGROVE_LEAVES", 8.75),
				new ItemTime("MANGROVE_LOG", 8.75),
				new ItemTime("MANGROVE_ROOTS", 8.75),
				new ItemTime("MEDIUM_AMETHYST_BUD", 17.5),
				new ItemTime("MELON", 8.75),
				new ItemTime("MYCELIUM", 35),
				new ItemTime("MONSTER_SPAWNER", 35),
				new ItemTime("MOSS_BLOCK", 17.5),
				new ItemTime("MOSS_CARPET", 17.5),
				new ItemTime("MOSSY_COBBLESTONE", 8.75),
				new ItemTime("MOSSY_STONE_BRICKS", 17.5),
				new ItemTime("MUD", 8.75),
				new ItemTime("MUDDY_MANGROVE_ROOTS", 8.75),
				new ItemTime("MUSHROOM_STEM", 8.75),
				new ItemTime("NETHERRACK", 1.75),
				new ItemTime("OAK_LEAVES", 1.75),
				new ItemTime("OAK_LOG", 1.75),
				new ItemTime("OAK_WOOD", 1.75),
				new ItemTime("OBSIDIAN", 8.75),
				new ItemTime("ORANGE_TERRACOTTA", 17.5),
				new ItemTime("PACKED_ICE", 17.5),
				new ItemTime("PODZOL", 8.75),
				new ItemTime("POINTED_DRIPSTONE", 8.75),
				new ItemTime("POLISHED_ANDESITE", 5.83),
				new ItemTime("POLISHED_DIORITE", 5.83),
				new ItemTime("POLISHED_GRANITE", 5.83),
				new ItemTime("POWDER_SNOW", 8.75),
				new ItemTime("PRISMARINE", 17.5),
				new ItemTime("PRISMARINE_BRICKS", 35),
				new ItemTime("PUMPKIN", 5.83),
				new ItemTime("RAIL", 17.5),
				new ItemTime("RED_MUSHROOM", 5.83),
				new ItemTime("RED_MUSHROOM_BLOCK", 8.75),
				new ItemTime("RED_SAND", 17.5),
				new ItemTime("RED_SANDSTONE", 17.5),
				new ItemTime("RED_TERRACOTTA", 17.5),
				new ItemTime("REDSTONE_ORE", 3.5),
				new ItemTime("ROOTED_DIRT", 8.75),
				new ItemTime("SAND", 1.75),
				new ItemTime("SANDSTONE", 3.5),
				new ItemTime("SCULK", 35),
				new ItemTime("SCULK_CATALYST", 35),
				new ItemTime("SCULK_SENSOR", 35),
				new ItemTime("SCULK_SHRIEKER", 35),
				new ItemTime("SCULK_VEIN", 35),
				new ItemTime("SEA_LANTERN", 35),
				new ItemTime("SEA_PICKLE", 17.5),
				new ItemTime("SMALL_AMETHYST_BUD", 17.5),
				new ItemTime("SMALL_DRIPLEAF", 17.5),
				new ItemTime("SMOOTH_BASALT", 17.5),
				new ItemTime("SNOW", 3.5),
				new ItemTime("SNOW_BLOCK", 5.83),
				new ItemTime("SOUL_SAND", 8.75),
				new ItemTime("SPRUCE_LEAVES", 3.5),
				new ItemTime("SPRUCE_LOG", 3.5),
				new ItemTime("SPRUCE_WOOD", 3.5),
				new ItemTime("STONE", 0.35),
				new ItemTime("STONE_BRICKS", 8.75),
				new ItemTime("STRIPPED_ACACIA_LOG", 3.5),
				new ItemTime("STRIPPED_OAK_LOG", 1.75),
				new ItemTime("STRIPPED_OAK_WOOD", 1.75),
				new ItemTime("STRIPPED_SPRUCE_LOG", 3.5),
				new ItemTime("STRIPPED_SPRUCE_WOOD", 3.5),
				new ItemTime("SUGAR_CANE", 3.5),
				new ItemTime("SUSPICIOUS_GRAVEL", 35),
				new ItemTime("SUSPICIOUS_SAND", 35),
				new ItemTime("TERRACOTTA", 17.5),
				new ItemTime("TUBE_CORAL", 17.5),
				new ItemTime("TUBE_CORAL_BLOCK", 17.5),
				new ItemTime("TUFT", 8.75),
				new ItemTime("VINES", 3.5),
				new ItemTime("WHITE_TERRACOTTA", 17.5)));

		taskItemsMap.put("kill", Arrays.asList(
				new ItemTime("PLAYER", 60),
				new ItemTime("ALLAY", 180),
				new ItemTime("AXOLOTL", 30),
				new ItemTime("BAT", 30),
				new ItemTime("BEE", 60),
				new ItemTime("CAMEL", 180),
				new ItemTime("CAT", 60),
				new ItemTime("CAVE_SPIDER", 15),
				new ItemTime("CHICKEN", 30),
				new ItemTime("CHICKEN_JOCKEY", 180),
				new ItemTime("COD", 60),
				new ItemTime("COW", 30),
				new ItemTime("CREEPER", 30),
				new ItemTime("DOLPHIN", 60),
				new ItemTime("DONKEY", 120),
				new ItemTime("DROWNED", 30),
				new ItemTime("ELDER_GUARDIAN", 45),
				new ItemTime("ENDERMANN", 20),
				new ItemTime("EVOKER", 60),
				new ItemTime("FOX", 60),
				new ItemTime("FROG", 60),
				new ItemTime("GLOW_SQUID", 30),
				new ItemTime("GOAT", 30),
				new ItemTime("GUARDIAN", 30),
				new ItemTime("HORSE", 45),
				new ItemTime("HUSK", 30),
				new ItemTime("IRON_GOLEM", 30),
				new ItemTime("LLAMA", 60),
				new ItemTime("MOOSHROOM", 120),
				new ItemTime("OCELOT", 60),
				new ItemTime("PANDA", 60),
				new ItemTime("PARROT", 60),
				new ItemTime("PHANTOM", 60),
				new ItemTime("PIG", 30),
				new ItemTime("PILLAGER", 60),
				new ItemTime("POLAR_BEAR", 60),
				new ItemTime("PUFFERFISH", 60),
				new ItemTime("RABBIT", 60),
				new ItemTime("RAVAGER", 120),
				new ItemTime("RAVAGER_JOCKEY", 300),
				new ItemTime("SALMON", 60),
				new ItemTime("SHEEP", 30),
				new ItemTime("SILVERFISH", 60),
				new ItemTime("SKELETON", 20),
				new ItemTime("SKELETON_HORSE", 120),
				new ItemTime("SKELETON_HORSEMAN", 180),
				new ItemTime("SLIME ", 60),
				new ItemTime("SNIFFER", 60),
				new ItemTime("SNOW_GOLEM", 30),
				new ItemTime("SPIDER", 20),
				new ItemTime("SPIDER_JOCKEY", 120),
				new ItemTime("SQUID", 15),
				new ItemTime("STRAY", 180),
				new ItemTime("TADPOLE", 60),
				new ItemTime("TRADER_LLAMA", 120),
				new ItemTime("TROPICAL_FISH", 60),
				new ItemTime("TURTLE", 30),
				new ItemTime("VEX", 120),
				new ItemTime("VILLAGER", 60),
				new ItemTime("VINDICATOR", 120),
				new ItemTime("WANDERING_TRADER", 180),
				new ItemTime("WARDEN", 60),
				new ItemTime("WITCH", 60),
				new ItemTime("WOLF", 60),
				new ItemTime("ZOMBIE", 20),
				new ItemTime("ZOMBIE_VILLAGER", 120),
				new ItemTime("ZOMBIFIED_PIGLIN", 30)));

		taskItemsMap.put("furnace", Arrays.asList(
				new ItemTime("BEEF", 3.67),
				new ItemTime("COOKED_CHICKEN", 3.67),
				new ItemTime("COOKED_PORKCHOP", 3.67),
				new ItemTime("COOKED_MUTTON", 3.67),
				new ItemTime("COOKED_RABBIT", 7.67),
				new ItemTime("COOKED_COD", 5.17),
				new ItemTime("COOKED_SALMON", 5.17),
				new ItemTime("BAKED_POTATO", 7.67),
				new ItemTime("DRIED_KELP", 4.17),
				new ItemTime("IRON_INGOT", 12.67),
				new ItemTime("GOLD_INGOT", 17.67),
				new ItemTime("COPPER_INGOT", 12.67),
				new ItemTime("GOLD_NUGGET", 12.67),
				new ItemTime("NETHERITE_SCRAP", 45.17),
				new ItemTime("GLASS", 2.17),
				new ItemTime("BRICK", 7.67),
				new ItemTime("STONE", 1.67),
				new ItemTime("NETHER_BRICK", 7.67),
				new ItemTime("CACTUS_GREEN", 7.67),
				new ItemTime("CHARCOAL", 3.67),
				new ItemTime("SPONGE", 15.17),
				new ItemTime("SMOOTH_SANDSTONE", 7.67),
				new ItemTime("SMOOTH_STONE", 1.83),
				new ItemTime("TERRACOTTA", 7.67)));

		taskItemsMap.put("craft", Arrays.asList(
				new ItemTime("DIAMOND_PICKAXE", 23),
				new ItemTime("DIAMOND_SWORD", 15),
				new ItemTime("IRON_PICKAXE", 17),
				new ItemTime("IRON_SWORD", 11),
				new ItemTime("LEATHER_HELMET", 10),
				new ItemTime("LEATHER_CHESTPLATE", 16),
				new ItemTime("LEATHER_LEGGINGS", 14),
				new ItemTime("LEATHER_BOOTS", 8),
				new ItemTime("WOODEN_PLANKS", 1),
				new ItemTime("CRAFTING_TABLE", 4),
				new ItemTime("STICK", 2),
				new ItemTime("WOODEN_PICKAXE", 7),
				new ItemTime("STONE_PICKAXE", 8),
				new ItemTime("WOODEN_SWORD", 3),
				new ItemTime("STONE_SWORD", 4),
				new ItemTime("WOODEN_AXE", 7),
				new ItemTime("STONE_AXE", 8),
				new ItemTime("IRON_AXE", 17),
				new ItemTime("DIAMOND_AXE", 23),
				new ItemTime("WOODEN_SHOVEL", 2),
				new ItemTime("STONE_SHOVEL", 4),
				new ItemTime("IRON_SHOVEL", 11),
				new ItemTime("DIAMOND_SHOVEL", 15),
				new ItemTime("NETHERITE_PICKAXE", 42),
				new ItemTime("NETHERITE_SWORD", 34),
				new ItemTime("NETHERITE_AXE", 42),
				new ItemTime("NETHERITE_SHOVEL", 34),
				new ItemTime("SHIELD", 7),
				new ItemTime("BOW", 13),
				new ItemTime("CROSSBOW", 15),
				new ItemTime("FISHING_ROD", 5),
				new ItemTime("FLINT_AND_STEEL", 6),
				new ItemTime("SHEARS", 12),
				new ItemTime("ANVIL", 45),
				new ItemTime("ENCHANTING_TABLE", 27),
				new ItemTime("BREWING_STAND", 10),
				new ItemTime("FURNACE", 8),
				new ItemTime("BLAST_FURNACE", 15),
				new ItemTime("SMOKER", 12),
				new ItemTime("STONECUTTER", 5),
				new ItemTime("GRINDSTONE", 5),
				new ItemTime("CARTOGRAPHY_TABLE", 3),
				new ItemTime("LOOM", 3),
				new ItemTime("BARREL", 5),
				new ItemTime("COMPOSTER", 4),
				new ItemTime("CHEST", 12),
				new ItemTime("DISPENSER", 18),
				new ItemTime("DROPPER", 10),
				new ItemTime("OBSERVER", 25),
				new ItemTime("PISTON", 20),
				new ItemTime("STICKY_PISTON", 22),
				new ItemTime("LEVER", 2),
				new ItemTime("BUTTON", 1),
				new ItemTime("PRESSURE_PLATE", 2),
				new ItemTime("TRAPDOOR", 3),
				new ItemTime("DOOR", 5),
				new ItemTime("FENCE_GATE", 5),
				new ItemTime("LADDER", 4),
				new ItemTime("SIGN", 6),
				new ItemTime("MINECART", 20),
				new ItemTime("BOAT", 3),
				new ItemTime("RAILS", 18),
				new ItemTime("POWERED_RAIL", 25),
				new ItemTime("DETECTOR_RAIL", 20),
				new ItemTime("ACTIVATOR_RAIL", 22),
				new ItemTime("FIREWORK_ROCKET", 5),
				new ItemTime("BED", 7),
				new ItemTime("PAINTING", 5),
				new ItemTime("ITEM_FRAME", 4),
				new ItemTime("BANNER", 6),
				new ItemTime("LANTERN", 8),
				new ItemTime("CAMPFIRE", 7),
				new ItemTime("SOUL_CAMPFIRE", 8),
				new ItemTime("LECTERN", 12),
				new ItemTime("BOOK", 12),
				new ItemTime("BOOKSHELF", 20),
				new ItemTime("CLOCK", 15),
				new ItemTime("COMPASS", 12),
				new ItemTime("MAP", 15),
				new ItemTime("GOLDEN_APPLE", 35),
				new ItemTime("CAKE", 25),
				new ItemTime("COOKIE", 7),
				new ItemTime("PUMPKIN_PIE", 10),
				new ItemTime("BREAD", 6),
				new ItemTime("GOLDEN_CARROT", 15),
				new ItemTime("ARROW", 5),
				new ItemTime("EYE_OF_ENDER", 25),
				new ItemTime("IRON_DOOR", 15),
				new ItemTime("IRON_TRAPDOOR", 12),
				new ItemTime("STONE_BRICK", 7),
				new ItemTime("NETHER_BRICK", 18),
				new ItemTime("RED_NETHER_BRICK", 22),
				new ItemTime("QUARTZ_BLOCK", 15),
				new ItemTime("SHULKER_BOX", 40),
				new ItemTime("END_CRYSTAL", 50),
				new ItemTime("FIRE_CHARGE", 10),
				new ItemTime("SCAFFOLDING", 5),
				new ItemTime("LOOM", 3),
				new ItemTime("WHITE_CONCRETE", 25),
				new ItemTime("ORANGE_CONCRETE", 25),
				new ItemTime("MAGENTA_CONCRETE", 25),
				new ItemTime("LIGHT_BLUE_CONCRETE", 25),
				new ItemTime("YELLOW_CONCRETE", 25),
				new ItemTime("LIME_CONCRETE", 25),
				new ItemTime("PINK_CONCRETE", 25),
				new ItemTime("GRAY_CONCRETE", 25),
				new ItemTime("LIGHT_GRAY_CONCRETE", 25),
				new ItemTime("CYAN_CONCRETE", 25),
				new ItemTime("PURPLE_CONCRETE", 25),
				new ItemTime("BLUE_CONCRETE", 25),
				new ItemTime("BROWN_CONCRETE", 25),
				new ItemTime("GREEN_CONCRETE", 25),
				new ItemTime("RED_CONCRETE", 25),
				new ItemTime("BLACK_CONCRETE", 25),
				new ItemTime("WHITE_TERRACOTTA", 30),
				new ItemTime("ORANGE_TERRACOTTA", 30),
				new ItemTime("MAGENTA_TERRACOTTA", 30),
				new ItemTime("LIGHT_BLUE_TERRACOTTA", 30),
				new ItemTime("YELLOW_TERRACOTTA", 30),
				new ItemTime("LIME_TERRACOTTA", 30),
				new ItemTime("PINK_TERRACOTTA", 30),
				new ItemTime("GRAY_TERRACOTTA", 30),
				new ItemTime("LIGHT_GRAY_TERRACOTTA", 30),
				new ItemTime("CYAN_TERRACOTTA", 30),
				new ItemTime("PURPLE_TERRACOTTA", 30),
				new ItemTime("BLUE_TERRACOTTA", 30),
				new ItemTime("BROWN_TERRACOTTA", 30),
				new ItemTime("GREEN_TERRACOTTA", 30),
				new ItemTime("RED_TERRACOTTA", 30),
				new ItemTime("BLACK_TERRACOTTA", 30)));

		taskItemsMap.put("fish", Arrays.asList(
				new ItemTime("RAW_COD", 0.57),
				new ItemTime("RAW_SALMON", 1.38),
				new ItemTime("TROPICAL_FISH", 17.16),
				new ItemTime("PUFFERFISH", 2.64),
				new ItemTime("BOW", 21.6),
				new ItemTime("ENCHANTED_BOOK", 21.6),
				new ItemTime("FISHING_ROD", 21.6),
				new ItemTime("NAME_TAG", 21.6),
				new ItemTime("NAUTILUS_SHELL", 21.6),
				new ItemTime("SADDLE", 21.6),
				new ItemTime("LILY_PAD", 24.31),
				new ItemTime("BOWL", 41.67),
				new ItemTime("FISHING_ROD", 194.44),
				new ItemTime("LEATHER", 41.67),
				new ItemTime("LEATHER_BOOTS", 41.67),
				new ItemTime("ROTTEN_FLESH", 41.67),
				new ItemTime("STICK", 83.33),
				new ItemTime("STRING", 83.33),
				new ItemTime("WATER_BOTTLE", 41.67),
				new ItemTime("BONE", 41.67),
				new ItemTime("INK_SAC", 416.67),
				new ItemTime("TRIPWIRE_HOOK", 41.67)));

		taskItemsMap.put("place", Arrays.asList(
				new ItemTime("ACACIA_LOG", 3.5),
				new ItemTime("ACACIA_WOOD", 3.5),
				new ItemTime("AMETHYST_CLUSTER", 17.5),
				new ItemTime("ANDESITE", 0.58),
				new ItemTime("AZALEA_LEAVES", 3.5),
				new ItemTime("BAMBOO", 5.83),
				new ItemTime("BEE_NEST", 8.75),
				new ItemTime("BELL", 35),
				new ItemTime("BIG_DRIPLEAF", 17.5),
				new ItemTime("BIRCH_LEAVES", 1.75),
				new ItemTime("BIRCH_LOG", 1.75),
				new ItemTime("BLACK_TERRACOTTA", 17.5),
				new ItemTime("BLOCK_OF_AMETHYST", 17.5),
				new ItemTime("BLOCK_OF_RAW_COPPER", 8.75),
				new ItemTime("BLOCK_OF_RAW_IRON", 8.75),
				new ItemTime("BLUE_ICE", 35),
				new ItemTime("BLUE_TERRACOTTA", 17.5),
				new ItemTime("BONE_BLOCK", 17.5),
				new ItemTime("BOOKSHELF", 35),
				new ItemTime("BRAIN_CORAL", 35),
				new ItemTime("BRAIN_CORAL_BLOCK", 35),
				new ItemTime("BRICKS", 35),
				new ItemTime("BROWN_MUSHROOM", 5.83),
				new ItemTime("BROWN_MUSHROOM_BLOCK", 8.75),
				new ItemTime("BROWN_TERRACOTTA", 17.5),
				new ItemTime("BUBBLE_CORAL", 35),
				new ItemTime("BUBBLE_CORAL_BLOCK", 35),
				new ItemTime("BUDDING_AMETHYST", 17.5),
				new ItemTime("CACTUS", 5.83),
				new ItemTime("CALCITE", 17.5),
				new ItemTime("CHEST", 8.75),
				new ItemTime("CHISELED_STONE_BRICKS", 17.5),
				new ItemTime("CYAN_TERRACOTTA", 17.5),
				new ItemTime("CLAY_BLOCK", 3.5),
				new ItemTime("COAL_ORE", 0.58),
				new ItemTime("COARSE_DIRT", 3.5),
				new ItemTime("COBBLED_DEEPSLATE", 0.88),
				new ItemTime("COBBLESTONE", 0.58),
				new ItemTime("COBWEB", 35),
				new ItemTime("COCOA", 5.83),
				new ItemTime("COPPER_ORE", 3.5),
				new ItemTime("CRACKED_STONE_BRICKS", 17.5),
				new ItemTime("CRYING_OBSIDIAN", 35),
				new ItemTime("DARK_OAK_LEAVES", 3.5),
				new ItemTime("DARK_OAK_LOG", 3.5),
				new ItemTime("DARK_PRISMARINE", 35),
				new ItemTime("DEEPSLATE", 0.88),
				new ItemTime("DEEPSLATE_COAL_ORE", 3.5),
				new ItemTime("DEEPSLATE_COPPER_ORE", 3.5),
				new ItemTime("DEEPSLATE_DIAMOND_ORE", 17.5),
				new ItemTime("DEEPSLATE_EMERALD_ORE", 35),
				new ItemTime("DEEPSLATE_GOLD_ORE", 17.5),
				new ItemTime("DEEPSLATE_IRON_ORE", 3.5),
				new ItemTime("DEEPSLATE_LAPIS_LAZULI_ORE", 17.5),
				new ItemTime("DEEPSLATE_REDSTONE_ORE", 17.5),
				new ItemTime("DIAMOND_ORE", 17.5),
				new ItemTime("DIORITE", 0.58),
				new ItemTime("DIRT", 0.35),
				new ItemTime("DIRT_PATH", 8.75),
				new ItemTime("DRIPSTONE_BLOCK", 3.5),
				new ItemTime("EMERALD_ORE", 35),
				new ItemTime("FARMLAND", 8.75),
				new ItemTime("FIRE_CORAL", 35),
				new ItemTime("FIRE_CORAL_BLOCK", 35),
				new ItemTime("FLOWERING_AZALEA_LEAVES", 3.5),
				new ItemTime("GLOW_LICHEN", 3.5),
				new ItemTime("GOLD_ORE", 3.5),
				new ItemTime("GRAY_TERRACOTTA", 17.5),
				new ItemTime("GRANITE", 0.58),
				new ItemTime("GRASS", 0.35),
				new ItemTime("GRASS_BLOCK", 0.35),
				new ItemTime("GRAVEL", 0.58),
				new ItemTime("GREEN_TERRACOTTA", 17.5),
				new ItemTime("HAY_BALE", 17.5),
				new ItemTime("HANGING_ROOTS", 3.5),
				new ItemTime("HORN_CORAL", 35),
				new ItemTime("HORN_CORAL_BLOCK", 35),
				new ItemTime("ICE", 3.5),
				new ItemTime("YELLOW_TERRACOTTA", 17.5),
				new ItemTime("INFESTED_CHISELED_STONE_BRICKS", 35),
				new ItemTime("INFESTED_COBBLESTONE", 35),
				new ItemTime("INFESTED_MOSSY_STONE_BRICKS", 35),
				new ItemTime("INFESTED_STONE_BRICKS", 35),
				new ItemTime("IRON_BARS", 35),
				new ItemTime("IRON_ORE", 0.58),
				new ItemTime("JUNGLE_LEAVES", 3.5),
				new ItemTime("JUNGLE_LOG", 3.5),
				new ItemTime("KELP", 3.5),
				new ItemTime("LAPIS_LAZULI_ORE", 8.75),
				new ItemTime("LARGE_AMETHYST_BUD", 17.5),
				new ItemTime("LIGHT_GRAY_TERRACOTTA", 17.5),
				new ItemTime("LILY_PAD", 5.83),
				new ItemTime("LIME_TERRACOTTA", 17.5),
				new ItemTime("MANGROVE_LEAVES", 8.75),
				new ItemTime("MANGROVE_LOG", 8.75),
				new ItemTime("MANGROVE_ROOTS", 8.75),
				new ItemTime("MEDIUM_AMETHYST_BUD", 17.5),
				new ItemTime("MELON", 8.75),
				new ItemTime("MYCELIUM", 35),
				new ItemTime("MONSTER_SPAWNER", 35),
				new ItemTime("MOSS_BLOCK", 17.5),
				new ItemTime("MOSS_CARPET", 17.5),
				new ItemTime("MOSSY_COBBLESTONE", 8.75),
				new ItemTime("MOSSY_STONE_BRICKS", 17.5),
				new ItemTime("MUD", 8.75),
				new ItemTime("MUDDY_MANGROVE_ROOTS", 8.75),
				new ItemTime("MUSHROOM_STEM", 8.75),
				new ItemTime("NETHERRACK", 1.75),
				new ItemTime("OAK_LEAVES", 1.75),
				new ItemTime("OAK_LOG", 1.75),
				new ItemTime("OAK_WOOD", 1.75),
				new ItemTime("OBSIDIAN", 8.75),
				new ItemTime("ORANGE_TERRACOTTA", 17.5),
				new ItemTime("PACKED_ICE", 17.5),
				new ItemTime("PODZOL", 8.75),
				new ItemTime("POINTED_DRIPSTONE", 8.75),
				new ItemTime("POLISHED_ANDESITE", 5.83),
				new ItemTime("POLISHED_DIORITE", 5.83),
				new ItemTime("POLISHED_GRANITE", 5.83),
				new ItemTime("POWDER_SNOW", 8.75),
				new ItemTime("PRISMARINE", 17.5),
				new ItemTime("PRISMARINE_BRICKS", 35),
				new ItemTime("PUMPKIN", 5.83),
				new ItemTime("RAIL", 17.5),
				new ItemTime("RED_MUSHROOM", 5.83),
				new ItemTime("RED_MUSHROOM_BLOCK", 8.75),
				new ItemTime("RED_SAND", 17.5),
				new ItemTime("RED_SANDSTONE", 17.5),
				new ItemTime("RED_TERRACOTTA", 17.5),
				new ItemTime("REDSTONE_ORE", 3.5),
				new ItemTime("ROOTED_DIRT", 8.75),
				new ItemTime("SAND", 1.75),
				new ItemTime("SANDSTONE", 3.5),
				new ItemTime("SCULK", 35),
				new ItemTime("SCULK_CATALYST", 35),
				new ItemTime("SCULK_SENSOR", 35),
				new ItemTime("SCULK_SHRIEKER", 35),
				new ItemTime("SCULK_VEIN", 35),
				new ItemTime("SEA_LANTERN", 35),
				new ItemTime("SEA_PICKLE", 17.5),
				new ItemTime("SMALL_AMETHYST_BUD", 17.5),
				new ItemTime("SMALL_DRIPLEAF", 17.5),
				new ItemTime("SMOOTH_BASALT", 17.5),
				new ItemTime("SNOW", 3.5),
				new ItemTime("SNOW_BLOCK", 5.83),
				new ItemTime("SOUL_SAND", 8.75),
				new ItemTime("SPRUCE_LEAVES", 3.5),
				new ItemTime("SPRUCE_LOG", 3.5),
				new ItemTime("SPRUCE_WOOD", 3.5),
				new ItemTime("STONE", 0.35),
				new ItemTime("STONE_BRICKS", 8.75),
				new ItemTime("STRIPPED_ACACIA_LOG", 3.5),
				new ItemTime("STRIPPED_OAK_LOG", 1.75),
				new ItemTime("STRIPPED_OAK_WOOD", 1.75),
				new ItemTime("STRIPPED_SPRUCE_LOG", 3.5),
				new ItemTime("STRIPPED_SPRUCE_WOOD", 3.5),
				new ItemTime("SUGAR_CANE", 3.5),
				new ItemTime("SUSPICIOUS_GRAVEL", 35),
				new ItemTime("SUSPICIOUS_SAND", 35),
				new ItemTime("TERRACOTTA", 17.5),
				new ItemTime("TUBE_CORAL", 17.5),
				new ItemTime("TUBE_CORAL_BLOCK", 17.5),
				new ItemTime("TUFT", 8.75),
				new ItemTime("VINES", 3.5),
				new ItemTime("WHITE_TERRACOTTA", 17.5),
				new ItemTime("QUARTZ_BLOCK", 20),
				new ItemTime("GLASS", 10),
				new ItemTime("SPONGE", 120),
				new ItemTime("WHITE_WOOL", 5),
				new ItemTime("ORANGE_WOOL", 7),
				new ItemTime("MAGENTA_WOOL", 10),
				new ItemTime("LIGHT_BLUE_WOOL", 7),
				new ItemTime("YELLOW_WOOL", 7),
				new ItemTime("LIME_WOOL", 10),
				new ItemTime("PINK_WOOL ", 7),
				new ItemTime("GRAY_WOOL", 10),
				new ItemTime("LIGHT_GRAY_WOOL", 7),
				new ItemTime("CYAN_WOOL", 15),
				new ItemTime("PURPLE_WOOL", 10),
				new ItemTime("BLUE_WOOL", 5),
				new ItemTime("BROWN_WOOL", 10),
				new ItemTime("GREEN_WOOL", 15),
				new ItemTime("RED_WOOL", 5),
				new ItemTime("BLACK_WOOL", 10),
				new ItemTime("PURPUR_BLOCK", 240),
				new ItemTime("GLOWSTONE", 25),
				new ItemTime("MAGMA_BLOCK", 20),
				new ItemTime("CRIMSON_STEM", 25),
				new ItemTime("CRIMSON_NYLIUM", 25),
				new ItemTime("CRIMSON_HYPHAE", 25),
				new ItemTime("SHROOM_LIGHT", 25),
				new ItemTime("SOUL_SOIL", 30),
				new ItemTime("WARPED_HYPHAE", 25),
				new ItemTime("WARPED_NYLIUM", 25),
				new ItemTime("WARPED_STEM", 25),
				new ItemTime("WARPED_WART_BLOCK", 25),
				new ItemTime("BASALT", 25),
				new ItemTime("BLACKSTONE", 25),
				new ItemTime("HONEYCOMB_BLOCK", 45),
				new ItemTime("HONEY_BLOCK", 45),
				new ItemTime("OCHRE_FROGLIGHT", 120),
				new ItemTime("VERDANT_FROGLIGHT", 120),
				new ItemTime("PEARLESCENT_FROGLIGHT", 120),
				new ItemTime("PACKED_MUD", 20),
				new ItemTime("MUD_BRICKS", 25),
				new ItemTime("GILDED_BLACKSTONE", 60),
				new ItemTime("CHERRY_LOG", 30),
				new ItemTime("BAMBOO_BLOCK", 30)));

		taskItemsMap.put("have", Arrays.asList(
				new ItemTime("ACACIA_LOG", 3.5),
				new ItemTime("ACACIA_WOOD", 3.5),
				new ItemTime("AMETHYST_CLUSTER", 17.5),
				new ItemTime("ANDESITE", 0.58),
				new ItemTime("AZALEA_LEAVES", 3.5),
				new ItemTime("BAMBOO", 5.83),
				new ItemTime("BEE_NEST", 8.75),
				new ItemTime("BELL", 35),
				new ItemTime("BIG_DRIPLEAF", 17.5),
				new ItemTime("BIRCH_LEAVES", 1.75),
				new ItemTime("BIRCH_LOG", 1.75),
				new ItemTime("BLACK_TERRACOTTA", 17.5),
				new ItemTime("BLOCK_OF_AMETHYST", 17.5),
				new ItemTime("BLOCK_OF_RAW_COPPER", 8.75),
				new ItemTime("BLOCK_OF_RAW_IRON", 8.75),
				new ItemTime("BLUE_ICE", 35),
				new ItemTime("BLUE_TERRACOTTA", 17.5),
				new ItemTime("BONE_BLOCK", 17.5),
				new ItemTime("BOOKSHELF", 35),
				new ItemTime("BRAIN_CORAL", 35),
				new ItemTime("BRAIN_CORAL_BLOCK", 35),
				new ItemTime("BRICKS", 35),
				new ItemTime("BROWN_MUSHROOM", 5.83),
				new ItemTime("BROWN_MUSHROOM_BLOCK", 8.75),
				new ItemTime("BROWN_TERRACOTTA", 17.5),
				new ItemTime("BUBBLE_CORAL", 35),
				new ItemTime("BUBBLE_CORAL_BLOCK", 35),
				new ItemTime("BUDDING_AMETHYST", 17.5),
				new ItemTime("CACTUS", 5.83),
				new ItemTime("CALCITE", 17.5),
				new ItemTime("CHEST", 8.75),
				new ItemTime("CHISELED_STONE_BRICKS", 17.5),
				new ItemTime("CYAN_TERRACOTTA", 17.5),
				new ItemTime("CLAY_BLOCK", 3.5),
				new ItemTime("COAL_ORE", 0.58),
				new ItemTime("COARSE_DIRT", 3.5),
				new ItemTime("COBBLED_DEEPSLATE", 0.88),
				new ItemTime("COBBLESTONE", 0.58),
				new ItemTime("COBWEB", 35),
				new ItemTime("COCOA", 5.83),
				new ItemTime("COPPER_ORE", 3.5),
				new ItemTime("CRACKED_STONE_BRICKS", 17.5),
				new ItemTime("CRYING_OBSIDIAN", 35),
				new ItemTime("DARK_OAK_LEAVES", 3.5),
				new ItemTime("DARK_OAK_LOG", 3.5),
				new ItemTime("DARK_PRISMARINE", 35),
				new ItemTime("DEEPSLATE", 0.88),
				new ItemTime("DEEPSLATE_COAL_ORE", 3.5),
				new ItemTime("DEEPSLATE_COPPER_ORE", 3.5),
				new ItemTime("DEEPSLATE_DIAMOND_ORE", 17.5),
				new ItemTime("DEEPSLATE_EMERALD_ORE", 35),
				new ItemTime("DEEPSLATE_GOLD_ORE", 17.5),
				new ItemTime("DEEPSLATE_IRON_ORE", 3.5),
				new ItemTime("DEEPSLATE_LAPIS_LAZULI_ORE", 17.5),
				new ItemTime("DEEPSLATE_REDSTONE_ORE", 17.5),
				new ItemTime("DIAMOND_ORE", 17.5),
				new ItemTime("DIORITE", 0.58),
				new ItemTime("DIRT", 0.35),
				new ItemTime("DIRT_PATH", 8.75),
				new ItemTime("DRIPSTONE_BLOCK", 3.5),
				new ItemTime("EMERALD_ORE", 35),
				new ItemTime("FARMLAND", 8.75),
				new ItemTime("FIRE_CORAL", 35),
				new ItemTime("FIRE_CORAL_BLOCK", 35),
				new ItemTime("FLOWERING_AZALEA_LEAVES", 3.5),
				new ItemTime("GLOW_LICHEN", 3.5),
				new ItemTime("GOLD_ORE", 3.5),
				new ItemTime("GRAY_TERRACOTTA", 17.5),
				new ItemTime("GRANITE", 0.58),
				new ItemTime("GRASS", 0.35),
				new ItemTime("GRASS_BLOCK", 0.35),
				new ItemTime("GRAVEL", 0.58),
				new ItemTime("GREEN_TERRACOTTA", 17.5),
				new ItemTime("HAY_BALE", 17.5),
				new ItemTime("HANGING_ROOTS", 3.5),
				new ItemTime("HORN_CORAL", 35),
				new ItemTime("HORN_CORAL_BLOCK", 35),
				new ItemTime("ICE", 3.5),
				new ItemTime("YELLOW_TERRACOTTA", 17.5),
				new ItemTime("INFESTED_CHISELED_STONE_BRICKS", 35),
				new ItemTime("INFESTED_COBBLESTONE", 35),
				new ItemTime("INFESTED_MOSSY_STONE_BRICKS", 35),
				new ItemTime("INFESTED_STONE_BRICKS", 35),
				new ItemTime("IRON_BARS", 35),
				new ItemTime("IRON_ORE", 0.58),
				new ItemTime("JUNGLE_LEAVES", 3.5),
				new ItemTime("JUNGLE_LOG", 3.5),
				new ItemTime("KELP", 3.5),
				new ItemTime("LAPIS_LAZULI_ORE", 8.75),
				new ItemTime("LARGE_AMETHYST_BUD", 17.5),
				new ItemTime("LIGHT_GRAY_TERRACOTTA", 17.5),
				new ItemTime("LILY_PAD", 5.83),
				new ItemTime("LIME_TERRACOTTA", 17.5),
				new ItemTime("MANGROVE_LEAVES", 8.75),
				new ItemTime("MANGROVE_LOG", 8.75),
				new ItemTime("MANGROVE_ROOTS", 8.75),
				new ItemTime("MEDIUM_AMETHYST_BUD", 17.5),
				new ItemTime("MELON", 8.75),
				new ItemTime("MYCELIUM", 35),
				new ItemTime("MONSTER_SPAWNER", 35),
				new ItemTime("MOSS_BLOCK", 17.5),
				new ItemTime("MOSS_CARPET", 17.5),
				new ItemTime("MOSSY_COBBLESTONE", 8.75),
				new ItemTime("MOSSY_STONE_BRICKS", 17.5),
				new ItemTime("MUD", 8.75),
				new ItemTime("MUDDY_MANGROVE_ROOTS", 8.75),
				new ItemTime("MUSHROOM_STEM", 8.75),
				new ItemTime("NETHERRACK", 1.75),
				new ItemTime("OAK_LEAVES", 1.75),
				new ItemTime("OAK_LOG", 1.75),
				new ItemTime("OAK_WOOD", 1.75),
				new ItemTime("OBSIDIAN", 8.75),
				new ItemTime("ORANGE_TERRACOTTA", 17.5),
				new ItemTime("PACKED_ICE", 17.5),
				new ItemTime("PODZOL", 8.75),
				new ItemTime("POINTED_DRIPSTONE", 8.75),
				new ItemTime("POLISHED_ANDESITE", 5.83),
				new ItemTime("POLISHED_DIORITE", 5.83),
				new ItemTime("POLISHED_GRANITE", 5.83),
				new ItemTime("POWDER_SNOW", 8.75),
				new ItemTime("PRISMARINE", 17.5),
				new ItemTime("PRISMARINE_BRICKS", 35),
				new ItemTime("PUMPKIN", 5.83),
				new ItemTime("RAIL", 17.5),
				new ItemTime("RED_MUSHROOM", 5.83),
				new ItemTime("RED_MUSHROOM_BLOCK", 8.75),
				new ItemTime("RED_SAND", 17.5),
				new ItemTime("RED_SANDSTONE", 17.5),
				new ItemTime("RED_TERRACOTTA", 17.5),
				new ItemTime("REDSTONE_ORE", 3.5),
				new ItemTime("ROOTED_DIRT", 8.75),
				new ItemTime("SAND", 1.75),
				new ItemTime("SANDSTONE", 3.5),
				new ItemTime("SCULK", 35),
				new ItemTime("SCULK_CATALYST", 35),
				new ItemTime("SCULK_SENSOR", 35),
				new ItemTime("SCULK_SHRIEKER", 35),
				new ItemTime("SCULK_VEIN", 35),
				new ItemTime("SEA_LANTERN", 35),
				new ItemTime("SEA_PICKLE", 17.5),
				new ItemTime("SMALL_AMETHYST_BUD", 17.5),
				new ItemTime("SMALL_DRIPLEAF", 17.5),
				new ItemTime("SMOOTH_BASALT", 17.5),
				new ItemTime("SNOW", 3.5),
				new ItemTime("SNOW_BLOCK", 5.83),
				new ItemTime("SOUL_SAND", 8.75),
				new ItemTime("SPRUCE_LEAVES", 3.5),
				new ItemTime("SPRUCE_LOG", 3.5),
				new ItemTime("SPRUCE_WOOD", 3.5),
				new ItemTime("STONE", 0.35),
				new ItemTime("STONE_BRICKS", 8.75),
				new ItemTime("STRIPPED_ACACIA_LOG", 3.5),
				new ItemTime("STRIPPED_OAK_LOG", 1.75),
				new ItemTime("STRIPPED_OAK_WOOD", 1.75),
				new ItemTime("STRIPPED_SPRUCE_LOG", 3.5),
				new ItemTime("STRIPPED_SPRUCE_WOOD", 3.5),
				new ItemTime("SUGAR_CANE", 3.5),
				new ItemTime("SUSPICIOUS_GRAVEL", 35),
				new ItemTime("SUSPICIOUS_SAND", 35),
				new ItemTime("TERRACOTTA", 17.5),
				new ItemTime("TUBE_CORAL", 17.5),
				new ItemTime("TUBE_CORAL_BLOCK", 17.5),
				new ItemTime("TUFT", 8.75),
				new ItemTime("VINES", 3.5),
				new ItemTime("WHITE_TERRACOTTA", 17.5),
				new ItemTime("QUARTZ_BLOCK", 20),
				new ItemTime("GLASS", 10),
				new ItemTime("SPONGE", 120),
				new ItemTime("WHITE_WOOL", 5),
				new ItemTime("ORANGE_WOOL", 7),
				new ItemTime("MAGENTA_WOOL", 10),
				new ItemTime("LIGHT_BLUE_WOOL", 7),
				new ItemTime("YELLOW_WOOL", 7),
				new ItemTime("LIME_WOOL", 10),
				new ItemTime("PINK_WOOL ", 7),
				new ItemTime("GRAY_WOOL", 10),
				new ItemTime("LIGHT_GRAY_WOOL", 7),
				new ItemTime("CYAN_WOOL", 15),
				new ItemTime("PURPLE_WOOL", 10),
				new ItemTime("BLUE_WOOL", 5),
				new ItemTime("BROWN_WOOL", 10),
				new ItemTime("GREEN_WOOL", 15),
				new ItemTime("RED_WOOL", 5),
				new ItemTime("BLACK_WOOL", 10),
				new ItemTime("PURPUR_BLOCK", 240),
				new ItemTime("GLOWSTONE", 25),
				new ItemTime("MAGMA_BLOCK", 20),
				new ItemTime("CRIMSON_STEM", 25),
				new ItemTime("CRIMSON_NYLIUM", 25),
				new ItemTime("CRIMSON_HYPHAE", 25),
				new ItemTime("SHROOM_LIGHT", 25),
				new ItemTime("SOUL_SOIL", 30),
				new ItemTime("WARPED_HYPHAE", 25),
				new ItemTime("WARPED_NYLIUM", 25),
				new ItemTime("WARPED_STEM", 25),
				new ItemTime("WARPED_WART_BLOCK", 25),
				new ItemTime("BASALT", 25),
				new ItemTime("BLACKSTONE", 25),
				new ItemTime("HONEYCOMB_BLOCK", 45),
				new ItemTime("HONEY_BLOCK", 45),
				new ItemTime("OCHRE_FROGLIGHT", 120),
				new ItemTime("VERDANT_FROGLIGHT", 120),
				new ItemTime("PEARLESCENT_FROGLIGHT", 120),
				new ItemTime("PACKED_MUD", 20),
				new ItemTime("MUD_BRICKS", 25),
				new ItemTime("GILDED_BLACKSTONE", 60),
				new ItemTime("CHERRY_LOG", 30),
				new ItemTime("BAMBOO_BLOCK", 30)));
	}

	public static class ItemTime {
		private final String name;
		private final double timeInMinutes;

		public ItemTime(String name, double timeInMinutes) {
			this.name = name;
			this.timeInMinutes = timeInMinutes;
		}

		public String getName() {
			return name;
		}

		public double getTimeInMinutes() {
			return timeInMinutes;
		}
	}
}