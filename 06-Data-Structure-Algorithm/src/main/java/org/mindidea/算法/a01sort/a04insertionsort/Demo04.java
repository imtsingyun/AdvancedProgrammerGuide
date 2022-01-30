package org.mindidea.算法.a01sort.a04insertionsort;

import org.mindidea.算法.zcommon.Utils;

public class Demo04 {
	public static void main(String[] args) {
		Integer[] nums = Utils.generateArr(100, 10);
		test(nums);
		Utils.printArr(nums);
	}

	private static void test(Integer[] nums) {
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
