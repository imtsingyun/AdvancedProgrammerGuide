package org.mindidea.算法.a01sort.a02selection;

import org.mindidea.算法.zcommon.Utils;

public class Demo05 {
	public static void main(String[] args) {
		Integer[] nums = Utils.generateArr(100, 10);
		sort(nums);
		Utils.printArr(nums);
	}

	private static void sort(Integer[] nums) {
		for (int end = nums.length - 1; end > 0; end--) {
			int maxValueIndex = 0;
			for (int begin = 0; begin <= end; begin++) {
				if (nums[maxValueIndex] < nums[begin]) {
					maxValueIndex = begin;
				}
			}
			Utils.swap(nums, maxValueIndex, end);
		}
	}
}
