package com.scoutress;

import com.scoutress.constants.RankupLevels;
import com.scoutress.constants.TheoreticalRankupTime;
import com.scoutress.servers.PrisonServerTasks;
import com.scoutress.servers.SkyblockServerTasks;
import com.scoutress.servers.SurvivalServerTasks;

public class Controller {

	static String server = "prison"; // survival, skyblock, prison.
	static String mode = "detailed"; // detailed, clean.

	RankupLevels rankupLevels = new RankupLevels();
	TheoreticalRankupTime teorRankupTime = new TheoreticalRankupTime();

	public int survivalRankupLevels = rankupLevels.survivalRankupLevelsCount;
	public int skyblockRankupLevels = rankupLevels.skyblockRankupLevelsCount;
	public int prisonRankupLevels = rankupLevels.prisonRankupLevelsCount;

	public int survivalFirstLevelTime = teorRankupTime.survivalRankupTimeForFirstLevel;
	public int survivalLastLevelTime = teorRankupTime.survivalRankupTimeForLastLevel;
	public int skyblockFirstLevelTime = teorRankupTime.skyblockRankupTimeForFirstLevel;
	public int skyblockLastLevelTime = teorRankupTime.skyblockRankupTimeForLastLevel;
	public int prisonFirstLevelTime = teorRankupTime.prisonRankupTimeForFirstLevel;
	public int prisonLastLevelTime = teorRankupTime.prisonRankupTimeForLastLevel;

	public void startTasks() {
		switch (server) {

			case "survival" -> SurvivalServerTasks
					.generateAndPrintSurvivalTasks(
							survivalRankupLevels,
							survivalFirstLevelTime,
							survivalLastLevelTime,
							mode,
							server);

			case "skyblock" -> SkyblockServerTasks
					.generateAndPrintSkyblockTasks(
							skyblockRankupLevels,
							skyblockFirstLevelTime,
							skyblockLastLevelTime,
							mode,
							server);

			case "prison" -> PrisonServerTasks
					.generateAndPrintPrisonTasks(
							prisonRankupLevels,
							prisonFirstLevelTime,
							prisonLastLevelTime,
							mode,
							server);

			default -> System.out.println("Wrong server name");
		}
	}
}
