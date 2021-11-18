package org.mindidea.algo.sort.a05recursion;

/**
 * 爬楼梯
 * 共 n 阶台阶，假设共有 f(n) 种走法
 * 第一步分为两种走法
 * 1. 第一步走 1 阶，则有 f(n - 1) 种走法
 * 2. 第一步走 2 阶，则有 f(n - 2) 种走法
 * 所以：f(n) = f(n - 1) + f(n - 2)
 */
public class Demo03ClimbStairs {

	public static void main(String[] args) {
		Demo03ClimbStairs d = new Demo03ClimbStairs();
		System.out.println(d.climbStairs(4));
	}

	private int climbStairs(int n) {
		if (n <= 2) {
			return n;
		}
		int first = 1;
		int second = 2;
		for (int i = 3; i <= n; i++) {
			second = first + second;
			first = second - first;
		}
		return second;
	}
}
