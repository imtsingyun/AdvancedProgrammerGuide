package org.mindidea.算法.a01sort.a02selection;

import org.mindidea.算法.zcommon.Utils;

public class Demo04 {
	public static void main(String[] args) {
		Integer[] nums = Utils.generateArr(100, 10);
		sort(nums);
		Utils.printArr(nums);
	}

	private static void sort(Integer[] nums) {
		for (int end = nums.length - 1; end > 0; end--) {
			int max = 0;
			for (int begin = 1; begin <= end; begin++) {
				if (nums[begin] >= nums[max]) {
					max = begin;
				}
			}
			Integer temp = nums[max];
			nums[max] = nums[end];
			nums[end] = temp;
		}
	}
}
