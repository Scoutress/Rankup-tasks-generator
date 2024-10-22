package com.scoutress.fileWriting;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public final class YamlFileWriterSkyblock {

  private final BufferedWriter writer;

  public YamlFileWriterSkyblock(String fileName) throws IOException {
    writer = new BufferedWriter(
        new OutputStreamWriter(
            new FileOutputStream(fileName), StandardCharsets.UTF_8));
    writeHeader();
  }

  public void writeHeader() throws IOException {
    writer.write("Challanges:\n");
  }

  public void writeRankName(int level) throws IOException {
    String levelName = Integer.toString(level);
    writer.write("  \"" + levelName + "\":\n");
  }

  public void writeTasksHeader() throws IOException {
    writer.write("    Tasks:\n");
  }

  public void writeTaskNumber(int currentTaskNumber) throws IOException {
    writer.write("      \"" + currentTaskNumber + "\":\n");
  }

  public void writeTaskType(String taskType) throws IOException {
    writer.write("        Type: " + taskType + "\n");
  }

  public void writeTaskAmount(int taskAmount) throws IOException {
    writer.write("        Amount: " + taskAmount + "\n");
  }

  public void writeTaskMaterial(String taskMaterial) throws IOException {
    writer.write("        Material: " + taskMaterial + "\n");
  }

  public void writeRewardsHeader() throws IOException {
    writer.write("    Rewards:\n");
  }

  public void writeSizeReward() throws IOException {
    int sizeReward = 2;
    writer.write("      Size: " + sizeReward + "\n");
  }

  public void writeCreditsReward() throws IOException {
    int creditsReward = 4;
    writer.write("      Credits: " + creditsReward + "\n");
  }

  public void writeLimitsHeader() throws IOException {
    writer.write("      Limits:\n");
  }

  public void writeLimitsReward(String limitsRewardName, int limitsRewardAmount) throws IOException {
    writer.write("        " + limitsRewardName + ": " + limitsRewardAmount + "\n");
  }

  public void writeRankupPrice(int level) throws IOException {
    double price = level * 100;
    writer.write("    Price: " + price + "\n");
  }

  public void close() throws IOException {
    if (writer != null) {
      writer.close();
    }
  }
}
