package org.mindidea.leetcode.动态规划._53最大子数组和;

public class Solution01 {
	public static void main(String[] args) {
		int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4, 9, 1, -10, 7, 23, 98, -30};
		System.out.println(new Solution01().maxSubArray(nums));
	}

	public int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length];
		// dp[0] 以 nums[0] 结尾的子数组，dp[0] = nums[0]
		// dp[1] 以 nums[1] 结尾的子数组，dp[1] = nums[1] + (dp[0] > 0 ? dp[0] : 0)
		dp[0] = nums[0];
		int max = dp[0];
		for (int i = 1; i < nums.length; i++) {
			if (dp[i - 1] > 0) {
				dp[i] = dp[i - 1] + nums[i];
			} else {
				dp[i] = nums[i];
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
