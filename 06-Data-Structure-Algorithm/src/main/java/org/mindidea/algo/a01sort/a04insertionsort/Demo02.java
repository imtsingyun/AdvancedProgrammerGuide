package org.mindidea.algo.a01sort.a04insertionsort;

import org.mindidea.algo.zcommon.Utils;

public class Demo02 {
	public static void main(String[] args) {
		Integer[] nums = Utils.generateArr(100, 10);
		sort(nums);
		Utils.printArr(nums);
	}

	private static void sort(Integer[] nums) {
		for (int begin = 1; begin < nums.length; begin++) {
			int curIndex = begin;
			int curValue = nums[curIndex];
			while (curIndex > 0 && curValue < nums[curIndex - 1]) {
				nums[curIndex] = nums[curIndex - 1];
				curIndex--;
			}
			nums[curIndex] = curValue;
		}
	}
}
