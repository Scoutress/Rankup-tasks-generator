package com.scoutress.servers;

import java.io.IOException;

import com.scoutress.UI;
import com.scoutress.dto.Item;
import com.scoutress.dto.RewardResult;
import com.scoutress.fileWriting.YamlFileWriterSkyblock;
import com.scoutress.utils.ItemCheckerByItemType;
import com.scoutress.utils.ItemDataPicker;
import com.scoutress.utils.LimitsRewardPicker;
import com.scoutress.utils.RequiredTimeForLevelAssigner;
import com.scoutress.utils.RequiredTimeForTaskAssigner;
import com.scoutress.utils.TaskCategoryAssigner;

public class SkyblockServerTasks {

	private static String taskCategory;
	private static String itemName;
	private static double itemTime;
	private static int itemCountByTime;
	private static double totalTimeForLevel;
	private static double levelTime;
	private static double requiredTimeForTask;
	private static double totalTimeForSingleTask;
	private static String limitsRewardName;
	private static int limitsRewardAmount;

	public static void generateAndPrintSkyblockTasks(
			int skyblockRankupLevelsCount, int skyblockRankupTimeForFirstLevel,
			int skyblockRankupTimeForLastLevel, String mode, String server) {

		RequiredTimeForLevelAssigner rtla = new RequiredTimeForLevelAssigner();
		TaskCategoryAssigner tca = new TaskCategoryAssigner();
		ItemDataPicker idp = new ItemDataPicker();
		RequiredTimeForTaskAssigner rtta = new RequiredTimeForTaskAssigner();
		ItemCheckerByItemType icit = new ItemCheckerByItemType();
		LimitsRewardPicker lrp = new LimitsRewardPicker();
		UI ui = new UI();

		String itemDifficulty = "normal";

		try {

			YamlFileWriterSkyblock yamlWriter = new YamlFileWriterSkyblock("Challanges.yml");

			int spawnersAmountSum = 31;
			int robotsAmountSum = 31;
			int villagersAmountSum = 32;
			int minecartHoppersAmountSum = 31;
			int pistonsAmountSum = 31;
			int stickyPistonsAmountSum = 31;
			int hoppersAmountSum = 31;
			int animalsAmountSum = 32;

			for (int level = 1; level <= skyblockRankupLevelsCount; level++) {

				totalTimeForLevel = 0;

				yamlWriter.writeRankName(level);
				yamlWriter.writeTasksHeader();

				ui.printLevelTitle(mode, level);

				for (int currentTaskNumber = 1; currentTaskNumber <= 8; currentTaskNumber++) {

					levelTime = rtla.calculateTimeRequiredForLevel(server, level);

					taskCategory = tca.determineCurrentTaskCategory(currentTaskNumber, server);

					Item item = idp.getItemData(server, taskCategory, itemDifficulty);
					itemName = item.getName();
					itemTime = item.getTime();

					requiredTimeForTask = rtta.calculateTimeRequiredForTask(
							server, itemDifficulty, levelTime);

					itemCountByTime = icit.calculateItemsByGivenTime(
							itemName, requiredTimeForTask, itemTime);

					totalTimeForSingleTask = itemTime * itemCountByTime;
					totalTimeForLevel += totalTimeForSingleTask;

					RewardResult rewardResult = lrp.pickLimitsRewardForOneSkyblockLevel(
							spawnersAmountSum, robotsAmountSum, villagersAmountSum,
							minecartHoppersAmountSum, pistonsAmountSum, stickyPistonsAmountSum,
							hoppersAmountSum, animalsAmountSum);

					limitsRewardName = rewardResult.getRewardName();
					limitsRewardAmount = rewardResult.getRewardValue();

					ui.printTasksForLevel(
							server, mode, currentTaskNumber, taskCategory, itemDifficulty, itemName, itemCountByTime, itemTime,
							totalTimeForSingleTask);

					yamlWriter.writeTaskNumber(currentTaskNumber);
					yamlWriter.writeTaskType(taskCategory);
					yamlWriter.writeTaskAmount(itemCountByTime);

					switch (taskCategory) {
						case "DIG", "KILL", "CRAFT", "FISH", "PLACE", "HAVE", "SMELT", "COOK" -> {
							yamlWriter.writeTaskMaterial(itemName);
						}
						case "WALK", "SWIM_WITH_BOAT", "RIDE_PIG", "RIDE_HORSE", "SWIM", "FLY_ELYTRA", "XP" -> {
						}
					}
				}

				switch (limitsRewardName) {
					case "SPAWNERS" -> spawnersAmountSum = limitsRewardAmount;
					case "ROBOTS" -> robotsAmountSum = limitsRewardAmount;
					case "VILLAGERS" -> villagersAmountSum = limitsRewardAmount;
					case "MINECART_HOPPERS" -> minecartHoppersAmountSum = limitsRewardAmount;
					case "PISTONS" -> pistonsAmountSum = limitsRewardAmount;
					case "STICKY_PISTONS" -> stickyPistonsAmountSum = limitsRewardAmount;
					case "HOPPERS" -> hoppersAmountSum = limitsRewardAmount;
					case "ANIMALS" -> animalsAmountSum = limitsRewardAmount;
				}

				yamlWriter.writeRewardsHeader();
				yamlWriter.writeSizeReward();
				yamlWriter.writeCreditsReward();
				yamlWriter.writeLimitsHeader();
				yamlWriter.writeLimitsReward(limitsRewardName, 1);
				yamlWriter.writeRankupPrice(level);

				ui.printTotalTimeForLevel(mode, totalTimeForLevel);
				System.out.println();
			}
			yamlWriter.close();
		} catch (IOException e) {
		}
	}
}
