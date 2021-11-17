package org.mindidea.algo.sort.a05recursion;

/**
 * 递归：
 */
public class Demo02Fib {
	public static void main(String[] args) {
		System.out.println(fib1(6));
		System.out.println(fib2(6));
	}

	public static int fib1(int n) {
		if (n <= 2) {
			return n;
		}
		return fib1(n - 1) + fib1(n - 2);
	}

	public static int fib2(int n) {
		if (n <= 2) {
			return 1;
		}
		int first = 1;
		int second = 1;
		int result = 2;
		for (int i = 3; i <= n; i++) {
			first = second;
			second = result;
			result = first + second;
		}
		return result;
	}
}
