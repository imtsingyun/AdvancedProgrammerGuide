package org.mindidea.algo.a01sort.a01bubble;

import org.mindidea.algo.zcommon.Utils;

public class Demo09 {
	public static void main(String[] args) {
		Integer[] nums = Utils.generateArr(100, 10);
		sort(nums);
		Utils.printArr(nums);
	}

	private static void sort(Integer[] nums) {
		// 判断(略)
		for (int end = nums.length - 1; end >= 0; end--) {
			int lastChangeIndex = 0;
			for (int begin = 1; begin <= end; begin++) {
				if (nums[begin - 1] > nums[begin]) {
					Utils.swap(nums, begin, begin - 1);
					lastChangeIndex = begin;
				}
			}
			end = lastChangeIndex;
		}
	}
}
