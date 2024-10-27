package com.scoutress.servers;

import java.io.IOException;

import com.scoutress.UI;
import com.scoutress.dto.Item;
import com.scoutress.fileWriting.YamlFileWriterPrison;
import com.scoutress.utils.ItemCheckerByItemType;
import com.scoutress.utils.ItemDataPicker;
import com.scoutress.utils.RequiredTimeForLevelAssigner;
import com.scoutress.utils.RequiredTimeForTaskAssigner;
import com.scoutress.utils.TaskCategoryAssigner;

public class PrisonServerTasks {

	private static String taskCategory;
	private static String itemName;
	private static double itemTime;
	private static int itemCountByTime;
	private static double totalTimeForLevel;
	private static double levelTime;
	private static double requiredTimeForTask;
	private static double totalTimeForSingleTask;

	public static void generateAndPrintPrisonTasks(
			int prisonRankupLevelsCount, int prisonRankupTimeForFirstLevel,
			int prisonRankupTimeForLastLevel, String mode, String server) {

		RequiredTimeForLevelAssigner rtla = new RequiredTimeForLevelAssigner();
		TaskCategoryAssigner tca = new TaskCategoryAssigner();
		ItemDataPicker idp = new ItemDataPicker();
		RequiredTimeForTaskAssigner rtta = new RequiredTimeForTaskAssigner();
		ItemCheckerByItemType icit = new ItemCheckerByItemType();
		UI ui = new UI();

		String itemDifficulty = "normal";

		try {

			YamlFileWriterPrison yamlWriter = new YamlFileWriterPrison("RankUp.yml");

			for (int level = 1; level < prisonRankupLevelsCount; level++) {

				totalTimeForLevel = 0;
				ui.printLevelTitle(mode, level);

				yamlWriter.writeRankName(level);
				yamlWriter.writeTasksPermission(level);
				yamlWriter.writeNextRankName(level);
				yamlWriter.writeNextLevelPrefix(level);
				yamlWriter.writeNextCellNumber(level);
				yamlWriter.writeMoneyNeededToLevelUp(level);
				yamlWriter.writeTasksHeader();

				for (int currentTaskNumber = 1; currentTaskNumber <= 10; currentTaskNumber++) {

					levelTime = rtla.calculateTimeRequiredForLevel(server, level);
					taskCategory = tca.determineCurrentTaskCategory(currentTaskNumber, server);

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
				ui.printTotalTimeForLevel(mode, totalTimeForLevel);
				System.out.println();
			}
			yamlWriter.writeLastRankName(prisonRankupLevelsCount);
			yamlWriter.writeLastLevelPermission(prisonRankupLevelsCount);
			yamlWriter.close();

		} catch (IOException e) {
		}
	}
}
