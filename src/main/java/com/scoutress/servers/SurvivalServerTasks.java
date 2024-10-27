package com.scoutress.servers;

import java.io.IOException;

import com.scoutress.UI;
import com.scoutress.dto.Item;
import com.scoutress.fileWriting.YamlFileWriterSurvival;
import com.scoutress.utils.ItemCheckerByItemType;
import com.scoutress.utils.ItemDataPicker;
import com.scoutress.utils.RequiredTimeForLevelAssigner;
import com.scoutress.utils.RequiredTimeForTaskAssigner;
import com.scoutress.utils.TaskCategoryAssigner;
import com.scoutress.utils.TaskItemDifficultyAssigner;

public class SurvivalServerTasks {

	private static String taskCategory;
	private static String itemDifficulty;
	private static String itemName;
	private static double itemTime;
	private static int itemCountByTime;
	private static double totalTimeForLevel;
	private static double levelTime;
	private static double requiredTimeForTask;
	private static double totalTimeForSingleTask;

	public static void generateAndPrintSurvivalTasks(
			int survivalRankupLevelsCount, int survivalRankupTimeForFirstLevel,
			int survivalRankupTimeForLastLevel, String mode, String server) {

		RequiredTimeForLevelAssigner rtla = new RequiredTimeForLevelAssigner();
		TaskCategoryAssigner tca = new TaskCategoryAssigner();
		TaskItemDifficultyAssigner tida = new TaskItemDifficultyAssigner();
		ItemDataPicker idp = new ItemDataPicker();
		RequiredTimeForTaskAssigner rtta = new RequiredTimeForTaskAssigner();
		ItemCheckerByItemType icit = new ItemCheckerByItemType();
		UI ui = new UI();

		try {

			YamlFileWriterSurvival yamlWriter = new YamlFileWriterSurvival("RankUp.yml");

			for (int level = 1; level < survivalRankupLevelsCount; level++) {

				totalTimeForLevel = 0;
				ui.printLevelTitle(mode, level);

				yamlWriter.writeRankName(level);
				yamlWriter.writeTasksPermission(level);
				yamlWriter.writeNextRankName(level);
				yamlWriter.writeNextLevelPrefix(level);
				yamlWriter.writeMoneyNeededToLevelUp(level);
				yamlWriter.writeTasksHeader();

				for (int currentTaskNumber = 1; currentTaskNumber <= 10; currentTaskNumber++) {

					levelTime = rtla.calculateTimeRequiredForLevel(server, level);
					taskCategory = tca.determineCurrentTaskCategory(currentTaskNumber, server);
					itemDifficulty = tida.determineCurrentTaskItemDifficulty(currentTaskNumber, server);

					Item item = idp.getItemData(server, taskCategory, itemDifficulty);

					itemName = item.getName();
					itemTime = item.getTime();

					requiredTimeForTask = rtta.calculateTimeRequiredForTask(server, itemDifficulty, levelTime);
					itemCountByTime = icit.calculateItemsByGivenTime(itemName, requiredTimeForTask, itemTime);

					totalTimeForSingleTask = itemTime * itemCountByTime;
					totalTimeForLevel += totalTimeForSingleTask;

					yamlWriter.writeTask(taskCategory, itemName, itemCountByTime);

					ui.printTasksForLevel(
							server, mode, currentTaskNumber, taskCategory, itemDifficulty,
							itemName, itemCountByTime, itemTime, totalTimeForSingleTask);

				}

				yamlWriter.writeXpTask(level);

				ui.printTotalTimeForLevel(mode, totalTimeForLevel);
				System.out.println();
			}
			yamlWriter.writeLastRankName(survivalRankupLevelsCount);
			yamlWriter.writeLastLevelPermission(survivalRankupLevelsCount);
			yamlWriter.close();

		} catch (IOException e) {
		}
	}
}
