package org.mindidea.leetcode._02_75_SortColors;

public class Solution {
	public static void main(String[] args) {
		Solution s1 = new Solution();
		int[] nums = new int[]{2, 0, 2, 1, 1, 0};
		s1.sortColors(nums);
		System.out.println(nums);
	}

	public void sortColors(int[] nums) {
		int i = 0;
		int l = 0;
		int r = nums.length - 1;

		while (i <= r) {
			int v = nums[i];
			if (v == 0) {
				swap(nums, i++, l++);
			} else if (v == 1) {
				i++;
			} else {
				swap(nums, i, r--);
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
