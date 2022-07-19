package org.mindidea.leetcode.动态规划._746使用最小花费爬楼梯;

public class Solution02 {
	public static void main(String[] args) {
		int[] cost = new int[]{10, 15, 20};
		System.out.println(new Solution01().minCostClimbingStairs(cost));
	}

	public int minCostClimbingStairs(int[] cost) {
		// cost[i] 表示离开第 i 阶时需要的费用
		// dp[i] 表示到达第 i 阶时需要的费用

		// dp[0] 表示到下标为 0 的台阶需要费用为 0
		// dp[1] 表示到达下标为 1 的台阶需要费用
		//      1) 直接到达第 1 级台阶（即从下标为 1 的台阶开始）dp[1] = 0
		//      2) 先到达第 0 级台阶（即从下标为 0 的台阶开始）dp[1] = cost[0]
		//      综上：dp[1] = Math.min(0, cost[0])
		// dp[2] 表示到达第 2 级台阶
		//      1) 从 1 爬一个台阶到达 2，dp[2] = dp[1] + cost[1] // 到达 1 的费用 + 离开 1 的费用
		//      2) 从 0 爬两个台阶到达 2，dp[2] = dp[0] + cost[0]
		//      综上：dp[2] = Math.min(dp[0] + cost[0], dp[1] + cost[1])
		// 所以：dp[n] = Math.min(dp[n - 2] + cost[n - 2], dp[n - 1] + cost[n - 1])
		int first = 0, second = 0;
		for (int i = 2; i <= cost.length; i++) {
			int next = Math.min(first + cost[i - 2], second + cost[i - 1]);
			first = second;
			second = next;
		}
		return second;
	}
}