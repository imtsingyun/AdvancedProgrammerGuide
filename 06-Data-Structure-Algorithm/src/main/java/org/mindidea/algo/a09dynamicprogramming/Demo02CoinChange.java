package org.mindidea.algo.a09dynamicprogramming;

/**
 * 动态规划
 * 假设有 25，20，5，1 分的硬币，现要找出 41 分的零钱，如何使硬币个数最少
 * dp(n) 凑够 n 分需要的最少硬币个数
 * 如果第 1 次选择了 25 分，则 dp(n) = dp(n - 25) + 1
 * 如果第 1 次选择了 20 分，则 dp(n) = dp(n - 20) + 1
 * 。。。以此类推
 * 如果第 1 次选择了 1 分，则 dp(n) = dp(n - 1) + 1
 * 所以 dp(n) = MIN { dp(n-25), dp(n-20), dp(n-5), dp(n-1) } + 1
 */
public class Demo02CoinChange {
	public static void main(String[] args) {
		System.out.println(coins1(41));
		System.out.println(coins2(41));
		System.out.println(coins3(41));
		System.out.println(coins4(41));
	}

	/**
	 * 递推（自底向上）+ 打印
	 * 从凑够 1 分开始，dp(1), dp(2), dp(3), dp(4) ... dp(n)
	 */
	private static int coins4(int n) {
		if (n < 1) return -1;
		int[] dp = new int[n + 1];
		int[] faces = new int[dp.length];
		for (int i = 1; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			if (i >= 1 && dp[i - 1] < min) {
				min = dp[i - 1];
				faces[i] = 1;
			}
			if (i >= 5 && dp[i - 5] < min) {
				min = dp[i - 5];
				faces[i] = 5;
			}
			if (i >= 20 && dp[i - 20] < min) {
				min = dp[i - 20];
				faces[i] = 20;
			}
			if (i >= 25 && dp[i - 25] < min) {
				min = dp[i - 25];
				faces[i] = 25;
			}
			dp[i] = min + 1;
			print(faces, i);
		}
		return dp[n];
	}

	static void print(int[] faces, int n) {
		System.out.print("[" + n + "] = ");
		while (n > 0) {
			System.out.print(faces[n] + ", ");
			n -= faces[n];
		}
		System.out.println();
	}

	/**
	 * 递推 (自底向上）
	 */
	private static int coins3(int n) {
		if (n < 1) return -1;
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			if (i >= 1) min = Math.min(dp[i - 1], min);
			if (i >= 5) min = Math.min(dp[i - 5], min);
			if (i >= 20) min = Math.min(dp[i - 20], min);
			if (i >= 25) min = Math.min(dp[i - 25], min);
			dp[i] = min + 1;
		}
		return dp[n];
	}

	/**
	 * 暴力递归（自顶向下调用，出现重叠子问题）
	 */
	private static int coins1(int n) {
		if (n < 1) return Integer.MAX_VALUE;
		if (n == 25 || n == 20 || n == 5 || n == 1) {
			return 1;
		}
		int min1 = Math.min(coins1(n - 25), coins1(n - 20));
		int min2 = Math.min(coins1(n - 5), coins1(n - 1));
		return Math.min(min1, min2) + 1;
	}

	/**
	 * 记忆化搜索（自顶向下）
	 */
	private static int coins2(int n) {
		if (n < 1) return -1;
		int[] dp = new int[n + 1];
		int[] faces = {1, 5, 20, 25};
		for (int face : faces) {
			if (n < face) break;
			dp[face] = 1;
		}
		return coins2(n, dp);
	}

	private static int coins2(int n, int[] dp) {
		if (n < 1) return Integer.MAX_VALUE;
		if (dp[n] == 0) {
			int min1 = Math.min(coins2(n - 25, dp), coins2(n - 20, dp));
			int min2 = Math.min(coins2(n - 5, dp), coins2(n - 1, dp));
			dp[n] = Math.min(min1, min2) + 1;
		}
		return dp[n];
	}
}
