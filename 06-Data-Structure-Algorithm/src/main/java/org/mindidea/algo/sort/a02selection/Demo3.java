package org.mindidea.algo.sort.a02selection;

public class Demo3 {
	public static void main(String[] args) {

	}

	public static void sort(Integer[] nums) {
		for (int end = nums.length - 1; end > 0; end--) {
			int maxIndex = 0;
			for (int begin = 1; begin <= end; begin++) {
				if (nums[begin] >= nums[begin - 1]) {
					maxIndex = begin;
				}
			}

		}
	}

	public static void swap(Integer[] nums, int i1, int i2) {
		int tmp = nums[i1];
		nums[i1] = nums[i2];
		nums[i2] = tmp;
	}
}
