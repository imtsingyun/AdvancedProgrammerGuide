package org.mindidea.algo.a07dynamicprogramming2;

public class Demo01ClimbStairs {
	public static void main(String[] args) {
		System.out.println(climb(1));
		System.out.println(climb(2));
		System.out.println(climb(3));
		System.out.println(climb(4));
		System.out.println(climb(5));
		System.out.println(climb(6));
		System.out.println(climb(7));
	}

	private static int climb(int n) {
		if (n <=2 ) return n;

		int first = 1, second = 2;
		for (int i = 3; i <= n; i++) {
			second = first + second;
			first = second - first;
		}
		return second;
	}

	private static int climb2(int n) {
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
