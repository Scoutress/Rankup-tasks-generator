package com.scoutress.fileWriting;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import com.scoutress.utils.AlphabetLetter;
import com.scoutress.utils.RankupPriceAssigner;

public final class YamlFileWriterPrison {

  private final BufferedWriter writer;
  AlphabetLetter al = new AlphabetLetter();
  RankupPriceAssigner rpa = new RankupPriceAssigner();

  public YamlFileWriterPrison(String fileName) throws IOException {
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
        : al.getLetterByNumber(level).toLowerCase();
    writer.write("  " + levelName + ":\n");
  }

  public void writeTasksPermission(int level) throws IOException {
    String permission = "ranks." + level;
    writer.write("    Permission: " + permission + "\n");
  }

  public void writeNextRankName(int level) throws IOException {
    String nextRankName = al.getLetterByNumber(level + 1);
    writer.write("    Next rank: " + nextRankName + "\n");
  }

  public void writeNextLevelPrefix(int level) throws IOException {
    String nextRankName = al.getLetterByNumber(level + 1);
    writer.write("    Show on rankup: \"&3" + nextRankName + "\"\n");
  }

  public void writeNextCellNumber(int level) throws IOException {
    int nextCellLevel = level + 1;
    writer.write("    Upgrade to cell: " + nextCellLevel + "\n");
  }

  public void writeMoneyNeededToLevelUp(int level) throws IOException {
    int basePrice = 2500;
    double money = rpa.setRankupPrice(level, basePrice);
    writer.write("    Needs money: " + money + "\n");
  }

  public void writeTasksHeader() throws IOException {
    writer.write("    Tasks:\n");
  }

  public void writeTask(String taskCategory, String itemName, int itemCountByTime) throws IOException {
    writer.write("      - " + taskCategory + " " + itemName + " " + itemCountByTime + "\n");
  }

  public void writeLastRankName(int prisonRankupLevelsCount) throws IOException {
    String lastRankName = al.getLetterByNumber(prisonRankupLevelsCount).toLowerCase();
    writer.write("  " + lastRankName + ":\n");
  }

  public void writeLastLevelPermission(int prisonRankupLevelsCount) throws IOException {
    String permission = "ranks." + prisonRankupLevelsCount;
    writer.write("    Permission: " + permission);
  }

  public void close() throws IOException {
    if (writer != null) {
      writer.close();
    }
  }
}
