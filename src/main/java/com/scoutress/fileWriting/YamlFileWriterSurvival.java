package com.scoutress.fileWriting;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import com.scoutress.utils.NextLevelPrefixPicker;
import com.scoutress.utils.RankupPriceAssigner;
import com.scoutress.utils.RomanNumbersPicker;

public final class YamlFileWriterSurvival {

  private final BufferedWriter writer;
  RomanNumbersPicker rnp = new RomanNumbersPicker();
  NextLevelPrefixPicker nlpp = new NextLevelPrefixPicker();
  RankupPriceAssigner rpa = new RankupPriceAssigner();

  public YamlFileWriterSurvival(String fileName) throws IOException {
    writer = new BufferedWriter(
        new OutputStreamWriter(
            new FileOutputStream(fileName), StandardCharsets.UTF_8));
    writeHeader();
  }

  public void writeHeader() throws IOException {
    writer.write("Ranks:\n");
  }

  public void writeRankName(int level) throws IOException {
    String levelName = level == 1
        ? "default"
        : rnp
            .getRomanNumeral(level);
    writer.write("  " + levelName + ":\n");
  }

  public void writeTasksPermission(int level) throws IOException {
    String permission = "ranks." + level;
    writer.write("    Permission: " + permission + "\n");
  }

  public void writeNextRankName(int level) throws IOException {
    String nextRankName = rnp.getRomanNumeral(level + 1);
    writer.write("    Next rank: " + nextRankName + "\n");
  }

  public void writeNextLevelPrefix(int level) throws IOException {
    String nextPrefix = nlpp.getNextPrefix(level + 1);
    writer.write("    Show on rankup: \"&3" + nextPrefix + "\"\n");
  }

  public void writeMoneyNeededToLevelUp(int level) throws IOException {
    double money = rpa.setRankupPrice(level);
    writer.write("    Needs money: " + money + "\n");
  }

  public void writeTasksHeader() throws IOException {
    writer.write("    Tasks:\n");
  }

  public void writeTask(String taskCategory, String itemName, int itemCountByTime) throws IOException {
    writer.write("      - " + taskCategory + " " + itemName + " " + itemCountByTime + "\n");
  }

  public void writeXpTask(int level) throws IOException {
    int xp = level * 2500;
    writer.write("      - xp gained " + xp + "\n");
  }

  public void writeLastRankName(int survivalRankupLevelsCount) throws IOException {
    String lastRankName = rnp.getRomanNumeral(survivalRankupLevelsCount);
    writer.write("  " + lastRankName + ":\n");
  }

  public void writeLastLevelPermission(int survivalRankupLevelsCount) throws IOException {
    String permission = "ranks." + survivalRankupLevelsCount;
    writer.write("    Permission: " + permission);
  }

  public void close() throws IOException {
    if (writer != null) {
      writer.close();
    }
  }
}
