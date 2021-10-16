package org.mindidea.algo.sort.zcommon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Utils {

	public static void printArr(Integer[] arr) {
		for (int j : arr) {
			System.out.print(j + ", ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		printArr(generateArr(10, 20));
	}

	public static Integer[] generateArr(int begin, int end) {
		List<Integer> collect = IntStream.rangeClosed(begin, end).boxed().collect(Collectors.toList());
		List<Integer> list = randomList(collect);
		Integer[] arr = new Integer[list.size()];
		list.toArray(arr);
		return arr;
	}

	private static List<Integer> randomList(List<Integer> sourceList) {
		if (sourceList == null || sourceList.size() == 0) {
			return sourceList;
		}
		ArrayList<Integer> randomList = new ArrayList<>(sourceList.size());
		do {
			int randomIndex = Math.abs(new Random().nextInt(sourceList.size()));
			randomList.add(sourceList.remove(randomIndex));
		} while (sourceList.size() > 0);
		return randomList;
	}
}
