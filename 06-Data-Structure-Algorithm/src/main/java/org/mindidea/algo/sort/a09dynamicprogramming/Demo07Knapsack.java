package org.mindidea.algo.sort.a09dynamicprogramming;

/**
 * 0-1 背包问题
 * 有 n 件物品和一个最大承重为 W 的背包，每件物品的重量是 Wi，价值为 Vi
 * 在总重量不超过 W 的前提下，获取背包中物品的最大总价值是多少
 * 注意：每个物品只有 1 个
 * <p>
 * 假设 values 是价值数组，weights 是重量数组
 * 编号为 k 的物品，价值为 values[k]，重量为 weight[k], k 包含于 [0, n)
 * <p>
 * 假设 dp(i, j) 是 最大承重为 j，有前 i 件物品可选时的最大总价值
 * 比如： dp(3, 7) 最大承重为 7，有前 3 件物品可以选择时的最大价值
 * dp(i, 0) 和 dp(0, j) 都是 0
 */
public class Demo07Knapsack {
	public static void main(String[] args) {
		int[] values = {6, 3, 5, 4, 6};
		int[] weights = {2, 2, 6, 5, 4};
		int capacity = 10;

		System.out.println(maxValue(values, weights, capacity));
	}

	static int maxValue(int[] values, int[] weights, int capacity) {
		if (values == null || weights == null || values.length == 0
				|| weights.length == 0 || capacity <= 0 || weights.length != values.length) {
			return 0;
		}

		int[][] dp = new int[values.length + 1][capacity + 1];
		for (int i = 1; i <= values.length; i++) {
			for (int j = 1; j <= capacity; j++) {
				if (j < weights[i - 1]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
				}
			}
		}
		return dp[values.length][capacity];
	}
}
