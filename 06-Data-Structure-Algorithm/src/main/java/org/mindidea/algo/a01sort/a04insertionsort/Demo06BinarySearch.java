package org.mindidea.algo.a01sort.a04insertionsort;

import org.mindidea.algo.zcommon.Utils;

public class Demo06BinarySearch {
	public static void main(String[] args) {
		Integer[] nums = Utils.generateArr(100, 10);
		test(nums);
		Utils.printArr(nums);
	}

	private static void test(Integer[] nums) {
		for (int begin = 1; begin < nums.length; begin++) {
			int curVal = nums[begin];
			int left = 0;
			int right = begin;
			while (left < right) {
				int mid = ((right - left) >> 1) + left;
				if (nums[begin] >= nums[mid]) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}

			for (int i = begin; i > left; i--) {
				nums[i] = nums[i - 1];
			}
			nums[left] = curVal;
		}
	}
}
