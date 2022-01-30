package org.mindidea.算法.a01sort.a01bubble;

import org.mindidea.算法.zcommon.Utils;

public class Demo08 {
	public static void main(String[] args) {
		Integer[] nums = Utils.generateArr(100, 12);
		sort(nums);
		Utils.printArr(nums);
	}

	private static void sort(Integer[] nums) {
		for (int end = nums.length - 1; end >= 0; end--) {
			int lastChangedIndex = 0;
			for (int begin = 1; begin <= end; begin++) {
				if (nums[begin - 1] > nums[begin]) {
					Utils.swap(nums, begin, begin - 1);
					lastChangedIndex = begin;
				}
			}
			end = lastChangedIndex;
		}
	}
}
