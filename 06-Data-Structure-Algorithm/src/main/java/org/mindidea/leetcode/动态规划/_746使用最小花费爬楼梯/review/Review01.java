package org.mindidea.leetcode.动态规划._746使用最小花费爬楼梯.review;

@SuppressWarnings("DuplicatedCode")
public class Review01 {

	public static void main(String[] args) {
		int[] cost = new int[]{10, 15, 20};
		System.out.println(new Review01().minCostClimbingStairs(cost));
	}

	public int minCostClimbingStairs(int[] cost) {
		if (cost == null || cost.length == 0) {
			return 0;
		}
		int[] dp = new int[cost.length + 1];
		dp[0] = dp[1] = 0;

		for (int i = 2; i <= cost.length; i++) {
			dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
		}

		return dp[cost.length];
	}
}
