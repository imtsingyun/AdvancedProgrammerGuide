package org.mindidea.algo.a01sort.a01bubble;

import org.mindidea.algo.zcommon.Utils;

/**
 * @author tsingyun
 */
public class Demo04 {
	public static void main(String[] args) {
		Integer[] nums = Utils.generateArr(10, 25);
		sort(nums);
		Utils.printArr(nums);
	}

	@SuppressWarnings("DuplicatedCode")
	public static void sort(Integer[] nums) {
		for (int end = nums.length - 1; end > 0; end--) {
			int lastChangeIndex = 0;
			for (int begin = 1; begin <= end; begin++) {
				if (nums[begin - 1] > nums[begin]) {
					swap(nums, begin - 1, begin);
					lastChangeIndex = begin;
				}
			}
			end = lastChangeIndex;
		}
	}

	public static void swap(Integer[] nums, int index1, int index2) {
		int tmp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = tmp;
	}
}