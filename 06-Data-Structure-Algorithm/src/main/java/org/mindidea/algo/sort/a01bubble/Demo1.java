package org.mindidea.algo.sort.a01bubble;

import org.mindidea.algo.sort.zcommon.Utils;

/**
 * 冒泡排序：
 * 1. index=1 的元素和 index=0 的比较，如果 1 上的元素比 0 上的元素小，则交换位置
 * 2. 一轮下来后，最后一个元素一定是最大的
 * 3. 然后再从 index=1 开始，和 index=0 比较，以此类推
 */
@SuppressWarnings("DuplicatedCode")
public class Demo1 {
	public static void main(String[] args) {
		Integer[] arr = Utils.generateArr(10, 30);
		Utils.printArr(arr);
		bubbleSort1(arr);
		bubbleSort2(arr);
		Utils.printArr(arr);
	}

	public static void bubbleSort1(Integer[] arr) {
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

	public static void bubbleSort2(Integer[] arr) {
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
