package org.mindidea.算法.a01sort.a04insertionsort;

import org.mindidea.算法.zcommon.Utils;

public class Demo01 {
	public static void main(String[] args) {
		Integer[] nums = Utils.generateArr(100, 10);
		sort(nums);
		Utils.printArr(nums);
	}

	private static void sort(Integer[] nums) {
		// 判断略
		for (int begin = 1; begin < nums.length; begin++) {
			int cur = begin;
			Integer curVal = nums[cur];
			while (cur > 0 && curVal < nums[cur - 1]) {
				nums[cur] = nums[cur - 1];
				cur--;
			}
			nums[cur] = curVal;
		}
	}
}
