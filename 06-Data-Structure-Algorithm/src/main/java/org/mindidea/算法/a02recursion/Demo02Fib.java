package org.mindidea.算法.a02recursion;

/**
 * 递归：
 */
public class Demo02Fib {
	public static void main(String[] args) {
		System.out.println(fib1(5));
		System.out.println(fib2(5));
		System.out.println(fib3(5));
	}

	/**************************************************************************/
	public static int fib1(int n) {
		if (n <= 2) {
			return 1;
		}
		return fib1(n - 1) + fib1(n - 2);
	}

	/**************************************************************************/
	private static int fib2(int n) {
		if (n <= 2) {
			return 1;
		}
		int[] arr = new int[n];
		arr[0] = arr[1]	= 1;
		return fib2(arr, n);
	}

	private static int fib2(int[] arr, int n) {
		if (arr[n - 1] == 0) {
			arr[n - 1] = fib2(arr, n - 1) + fib2(arr, n - 2);
		}
		return arr[n - 1];
	}

	/**************************************************************************/
	public static int fib3(int n) {
		if (n <= 2) {
			return 1;
		}
		int first = 1;
		int second = 1;
		for (int i = 3; i <= n; i++) {
			second = first + second;
			first = second - first;
		}
		return second;
	}
}
