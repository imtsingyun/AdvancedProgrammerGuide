package org.mindidea.algo.sort.a09dynamicprogramming;

/**
 * Longest Increasing Subsequence 最长上升子序列
 * 给定一个无序的整數序列，求出它最长上升子序列的长度（要求严格上升，相等的不算上升，无需连续）
 * 比如：[10, 2, 2, 5, 1, 7, 101, 18]
 * LIS 是：   2     5     7  101
 * 或者是：   2     5     7       18
 */
public class Demo04LongestIncrSubSeq {
	public static void main(String[] args) {
		int[] nums = {10, 2, 2, 5, 1, 7, 101, 18};
		System.out.println(solution(nums));
	}

	private static int solution(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		int max = dp[0] = 1;
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(dp[i], max);
		}
		return max;
	}
}
