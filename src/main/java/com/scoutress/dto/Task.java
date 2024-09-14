package com.scoutress.dto;

public class Task {
	private final String type;
	private final String itemName;
	private final int quantity;
	private final double totalTime;

	public Task(String type, String itemName, int quantity, double totalTime) {
		this.type = type;
		this.itemName = itemName;
		this.quantity = quantity;
		this.totalTime = totalTime;
	}

	public String getType() {
		return type;
	}

	public String getItemName() {
		return itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getTotalTime() {
		return totalTime;
	}

	@Override
	public String toString() {
		return String.format("%s %s (x%d) - %.2f minutės", type, itemName, quantity, totalTime);
	}
}
