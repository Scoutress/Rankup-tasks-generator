package com.scoutress.utils;

import com.scoutress.dto.Task;
import java.util.List;

public class Ui {

	public static void printTasksWithNumbers(String header, List<Task> tasks) {
		System.out.println(header);
		for (int i = 0; i < tasks.size(); i++) {
			System.out.println((i + 1) + ". " + tasks.get(i));
		}
		System.out.println();
	}
}
