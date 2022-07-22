package org.mindidea.leetcode.动态规划._53最大子数组和.review;

import org.mindidea.leetcode.动态规划._53最大子数组和.Solution01;

public class Review01 {
	public static void main(String[] args) {
		int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4, 9, 1, -10, 7, 23, 98, -30};
		System.out.println(new Solution01().maxSubArray(nums));
	}

	public int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length];
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				dp[i] = dp[i - 1] + nums[i];
			} else {
				dp[i] = nums[i];
			}
			max = Math.max(dp[i], max);
		}
		return max;
	}
}
