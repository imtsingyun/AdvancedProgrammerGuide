package org.mindidea.algo.a06dynamicprogramming;

/**
 * Longest Increasing Subsequence 最长上升子序列
 * 给定一个无序的整數序列，求出它最长上升子序列的长度（要求严格上升，相等的不算上升，无需连续）
 * 比如：[10, 2, 2, 5, 1, 7, 101, 18], LIS 是：2 5 7 101 或者是：2 5 7 18
 * dp[i] 是以 nums[i] 结尾的最大上升子序列长度
 * 以 nums[0] 10 结尾的最长上升子序列是 10, dp[0] = 1
 * 以 nums[1] 2 结尾的最长上升子序列是 2, dp[1] = 1
 * 以 nums[2] 2 结尾的最长上升子序列是 2, dp[2] = 1
 * 以 nums[3] 5 结尾的最长上升子序列是 2 5, dp[3] = dp[1] + 1 = dp[2] + 1 = 2
 * 以 nums[4] 1 结尾的最长上升子序列是 1, dp[4] = 1
 * 以 nums[5] 7 结尾的最长上升子序列是 7, dp[5] = dp[3] + 1 = 3
 * 以 nums[6] 101 结尾的最长上升子序列是 101, dp[6] = dp[5] + 1 = 4
 * 以 nums[7] 181结尾的最长上升子序列是 18, dp[7] = dp[5] + 1 = 4
 */
public class Demo04LongestIncrSubSeq {
	public static void main(String[] args) {
		int[] nums = {10, 2, 2, 5, 1, 7, 101, 18};
		System.out.println(solution1(nums));
		System.out.println(solution2(nums));
		System.out.println(solution3(nums));
		System.out.println(solution4(nums));
		System.out.println(solution5(nums));
		System.out.println(solution6(nums));
	}

	private static int solution6(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		int max = 1;
		for (int i = 0; i < nums.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	private static int solution5(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		int max = 1;
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

	private static int solution4(int[] nums) {
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

	private static int solution3(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		int max = 1;
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

	private static int solution2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		int max = 1;
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

	private static int solution1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		int max = dp[0] = 1;
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				// 遍历前面所有小于当前元素 nums[i] 的数据, 表示 i 元素可以拼接到 j 元素后面
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(dp[i], max);
		}
		return max;
	}
}
