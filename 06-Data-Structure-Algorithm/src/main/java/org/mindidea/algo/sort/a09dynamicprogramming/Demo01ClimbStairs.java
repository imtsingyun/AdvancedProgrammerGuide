package org.mindidea.algo.sort.a09dynamicprogramming;

/**
 * 爬楼梯，每次只能走 1 个台阶，或 2 个台阶
 * 共 n 个台阶，问共有多少种走法？
 * 假设有 dp(n) 种走法，则：
 * 1. 如果第一步走一个台阶，则有 dp(n - 1) 种走法
 * 2. 如果第一步走两个台阶，则有 dp(n - 2) 种走法
 * 所以 dp(n) = dp(n - 1) + dp(n - 2)
 */
public class Demo01ClimbStairs {
	public static void main(String[] args) {
		System.out.println(climb(2));
		System.out.println(climb(3));
		System.out.println(climb(4));
		System.out.println(climb(5));
		System.out.println(climb(6));
		System.out.println(climb(7));
	}

	private static int climb(int n) {
		if (n < 0) return -1;
		if (n == 1) return 1;
		if (n == 2) return 2;

		int s1 = 1;
		int s2 = 2;
		for (int i = 3; i <= n; i++) {
			s2 = s1 + s2;
			s1 = s2 - s1;
		}
		return s2;
	}
}
