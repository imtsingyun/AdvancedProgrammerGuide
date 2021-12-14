package org.mindidea.algo.a01sort.a01bubble;

import org.mindidea.algo.zcommon.Utils;

public class Demo07 {
	public static void main(String[] args) {
		Integer[] nums = Utils.generateArr(100, 15);
		bubbleSort(nums);
		Utils.printArr(nums);
	}

	private static void bubbleSort(Integer[] nums) {
		for (int end = nums.length - 1; end > 0; end--) {
			int lastChangeIndex = 0;
			for (int begin = 1; begin <= end; begin++) {
				if (nums[begin - 1] > nums[begin]) {
					Utils.swap(nums, begin - 1, begin);
					lastChangeIndex = begin;
				}
			}
			end = lastChangeIndex;
		}
	}
}
