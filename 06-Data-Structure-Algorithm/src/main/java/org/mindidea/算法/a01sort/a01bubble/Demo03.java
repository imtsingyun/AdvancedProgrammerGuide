package org.mindidea.算法.a01sort.a01bubble;

/**
 * Bubble sort
 * @author tsingyun
 * 2021-11-10 下午10:17
 */
public class Demo03 {
	public static void main(String[] args) {

	}

	@SuppressWarnings("DuplicatedCode")
	public static void sort(Integer[] nums) {
		for (int end = nums.length - 1; end >0; end--) {
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

	public static void swap(Integer[] nums, int i1, int i2) {
		int tmp = nums[i1];
		nums[i1] = nums[i2];
		nums[i2] = tmp;
	}
}
