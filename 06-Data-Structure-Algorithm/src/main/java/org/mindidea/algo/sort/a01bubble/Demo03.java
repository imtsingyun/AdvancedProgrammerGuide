package org.mindidea.algo.sort.a01bubble;

public class Demo03 {
	@SuppressWarnings("DuplicatedCode")
	public static void bubbleSort(Integer[] arr) {
		for (int end = arr.length - 1; end > 0; end--) {
			int lastChangeIndex = 0;
			for (int begin = 1; begin <= end; begin++) {
				if (arr[begin] < arr[begin - 1]) {
					int tmp = arr[begin];
					arr[begin] = arr[begin - 1];
					arr[begin - 1] = tmp;
					lastChangeIndex = begin;
				}
			}
			end = lastChangeIndex;
		}
	}
}
