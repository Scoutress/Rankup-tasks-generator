package com.scoutress.generation;

import com.scoutress.constants.SurvivalTypesAndItems;
import com.scoutress.constants.SurvivalTypesAndItems.ItemTime;
import com.scoutress.dto.Task;
import com.scoutress.utils.Ui;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class GenerateTaskTypes {

	public static List<Task> generateSurvivalTaskTypes(double totalTimeForTasks) {
		List<Task> tasks = new ArrayList<>();
		Random rng = new Random();
		Map<String, Integer> typeCount = new HashMap<>();
		Set<String> taskSet = new HashSet<>();
		double remainingTime = totalTimeForTasks;

		for (int i = 0; i < 10; i++) {
			String randomTaskType;
			do {
				randomTaskType = SurvivalTypesAndItems.getAllSurvivalTypesList()
						.get(rng.nextInt(SurvivalTypesAndItems.getAllSurvivalTypesList().size()));
			} while (typeCount.containsKey(randomTaskType) && typeCount.get(randomTaskType) >= 3);
			typeCount.put(randomTaskType, typeCount.getOrDefault(randomTaskType, 0) + 1);

			List<ItemTime> taskItems = SurvivalTypesAndItems.getTaskItems(randomTaskType);
			ItemTime randomTaskItem;
			do {
				randomTaskItem = taskItems.get(rng.nextInt(taskItems.size()));
			} while (taskSet.contains(randomTaskType + " " + randomTaskItem.getName()));
			taskSet.add(randomTaskType + " " + randomTaskItem.getName());

			double taskTime;
			if (i == 9) {
				taskTime = remainingTime;
			} else {
				taskTime = rng.nextDouble() * (remainingTime / (10 - i));
				remainingTime -= taskTime;
			}

			double itemTime = randomTaskItem.getTimeInMinutes();
			int itemCount = calculateItemCount(taskTime, itemTime, randomTaskType);

			if (itemCount > 0) {
				tasks.add(new Task(randomTaskType, randomTaskItem.getName(), itemCount, itemTime * itemCount));
			}
		}

		while (tasks.size() < 10) {
			String randomTaskType = SurvivalTypesAndItems.getAllSurvivalTypesList()
					.get(rng.nextInt(SurvivalTypesAndItems.getAllSurvivalTypesList().size()));
			ItemTime randomTaskItem = SurvivalTypesAndItems.getTaskItems(randomTaskType)
					.get(rng.nextInt(SurvivalTypesAndItems.getTaskItems(randomTaskType).size()));
			double itemTime = randomTaskItem.getTimeInMinutes();
			int itemCount = calculateItemCount(totalTimeForTasks / 10, itemTime, randomTaskType);

			if (itemCount > 0) {
				tasks.add(new Task(randomTaskType, randomTaskItem.getName(), itemCount, itemTime * itemCount));
			}
		}

		return tasks;
	}

	private static int calculateItemCount(double taskTime, double itemTime, String taskType) {
		int itemCount = itemTime > 0 ? (int) (taskTime / itemTime) : 0;

		if ("craft".equals(taskType)) {
			itemCount = Math.min(itemCount, 5);
		}

		return itemCount;
	}

	public static void generateAndPrintSurvivalTasks() {
		for (int i = 2; i <= 13; i++) {
			double totalTimeForTasks = calculateTotalTimeForRank(i);
			List<Task> levelTasks = generateSurvivalTaskTypes(totalTimeForTasks);
			Ui.printTasksWithNumbers("To level " + i, levelTasks);

			double actualTotalTime = calculateActualTotalTime(levelTasks);
			System.out.println(
					"Faktinė laiko suma tam lygiui: " + actualTotalTime + " minutės (" + (actualTotalTime / 60) + " valandos)");
			System.out.println();
		}
	}

	private static double calculateTotalTimeForRank(int rank) {
		return 16 * 60.0 + (rank - 1) * 2 * 60.0;
	}

	private static double calculateActualTotalTime(List<Task> tasks) {
		double totalTime = 0;
		for (Task task : tasks) {
			totalTime += task.getTotalTime();
		}
		return totalTime;
	}
}
