package com.scoutress;

import com.scoutress.servers.PrisonServerTasks;
import com.scoutress.servers.SkyblockServerTasks;
import com.scoutress.servers.SurvivalServerTasks;

public class Controller {

	static String server = "survival";

	public static void startTasks() {
		switch (server) {

			case "survival" -> SurvivalServerTasks.generateAndPrintSurvivalTasks();

			case "skyblock" -> SkyblockServerTasks.generateAndPrintSkyblockTasks();

			case "prison" -> PrisonServerTasks.generateAndPrintPrisonTasks();

			default -> System.out.println("Wrong server name");
		}
	}
}
