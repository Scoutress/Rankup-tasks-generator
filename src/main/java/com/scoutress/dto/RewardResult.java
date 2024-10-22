package com.scoutress.dto;

public class RewardResult {
  private final String rewardName;
  private final int rewardValue;

  public RewardResult(String rewardName, int rewardValue) {
    this.rewardName = rewardName;
    this.rewardValue = rewardValue;
  }

  public String getRewardName() {
    return rewardName;
  }

  public int getRewardValue() {
    return rewardValue;
  }
}
