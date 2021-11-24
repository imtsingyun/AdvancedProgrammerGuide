package org.mindidea.algo.sort.a09dynamicprogramming;

/**
 * 最大连续子序列和
 * 给定长度为 n 的数组，求最大连续子序列的和
 * 比如：-2, 1, -3, 4, -1, 2, 1, -5, 4
 * 假设 dp(i) 是以 nums[i] 结尾的最大连续子序列和
 * 以 nums[0], -2 结尾的最大连续子序列是 -2，所以 dp(0) = -2
 * 以 nums[1], 1 结尾的最大连续子序列是 1，所以 dp(1) = 1
 * 以 nums[2], -3 结尾的最大连续子序列是 1、-3，所以 dp(2) = dp(1) + (-3) = -2
 * 以 nums[3], 4 结尾的最大连续子序列是 4，所以 dp(3) = 4
 * 以 nums[4], -1 结尾的最大连续子序列是 4、-1，所以 dp(4) = dp(3) + (-1) = 3
 * 以 nums[5], 2 结尾的最大连续子序列是 4、-1、2，所以 dp(5) = dp(4) + 2 = 5
 * 以 nums[6], 1 结尾的最大连续子序列是 4、-1、2、1，所以 dp(6) = dp(5) + 1 = 6
 * 以 nums[7], -5 结尾的最大连续子序列是 4、-1、2、1、-5，所以 dp(7) = dp(6) + (-5) = 1
 * 以 nums[8], 4 结尾的最大连续子序列是 4、-1、2、1、-5、4，所以 dp(8) = dp(7) + 4 = 5
 *
 * dp(i-1) <= 0, 则 dp(i) = nums[i]
 * dp(i-1) > 0, 则 dp(i) = dp(i - 1) + nums[i]
 */
public class Demo03MaxSubArray {
	public static void main(String[] args) {
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(solution1(nums));
		System.out.println(solution2(nums));
	}

	// 去掉数组，优化空间
	private static int solution2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int dp = nums[0];
		int max = dp;
		for (int i = 1; i < nums.length; i++) {
			if (dp <= 0) {
				dp = nums[i];
			} else {
				dp = dp + nums[i];
			}
			max = Math.max(dp, max);
			System.out.println("dp[" + i + "] = " + dp);
		}
		return max;
	}

	private static int solution1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = dp[0];
		System.out.println("dp[0] = " + dp[0]);
		for (int i = 1; i < dp.length; i++) {
			if (dp[i - 1] <= 0) {
				dp[i] = nums[i];
			} else {
				dp[i] = dp[i - 1] + nums[i];
			}
			max = Math.max(dp[i], max);
			System.out.println("dp[" + i + "] = " + dp[i]);
		}
		return max;
	}

}
