package org.mindidea.算法.a01sort.a04insertionsort;

import org.mindidea.算法.zcommon.Utils;

public class Demo05BinarySearch {
	public static void main(String[] args) {
		Integer[] nums = Utils.generateArr(100, 15);
		sort(nums);
		Utils.printArr(nums);
	}

	private static void sort(Integer[] nums) {
		for (int begin = 1; begin < nums.length; begin++) {
			Integer curVal = nums[begin];

			int left = 0;
			int right = begin;

			while (left < right) {
				int mid = ((right - left) >> 1) + left;
				if (nums[begin] >= nums[mid]) {
					left = mid + 1;
				} else if (nums[begin] < nums[mid]) {
					right = mid;
				}
			}
			for (int j = begin; j > left; j--) {
				nums[j] = nums[j - 1];
			}
			nums[left] = curVal;
		}
	}
}
