package org.mindidea.algo.a01sort.a04insertionsort;

import org.mindidea.algo.zcommon.Utils;

public class Demo03 {
	public static void main(String[] args) {
		Integer[] nums = Utils.generateArr(100, 10);
		sort(nums);
		Utils.printArr(nums);
	}

	private static void sort(Integer[] nums) {
		for (int begin = 1; begin < nums.length; begin++) {
			int curIdx = begin;
			int curVal = nums[curIdx];
			while (curIdx > 0 && curVal < nums[curIdx - 1]) {
				nums[curIdx] = nums[curIdx - 1];
				curIdx--;
			}
			nums[curIdx] = curVal;
		}
	}
}
