package org.mindidea.algo.a01sort.a02selection;

import org.mindidea.algo.zcommon.Utils;

public class Demo07 {
	public static void main(String[] args) {
		Integer[] nums = Utils.generateArr(100, 10);
		sort(nums);
		Utils.printArr(nums);
	}

	private static void sort(Integer[] nums) {
		for (int end = nums.length - 1; end > 0; end--) {
			int maxIndex = 0;
			for (int begin = 1; begin <= end; begin++) {
				if (nums[begin] > nums[maxIndex]) {
					maxIndex = begin;
				}
			}
			Utils.swap(nums, maxIndex, end);
		}
	}
}
