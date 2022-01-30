package org.mindidea.算法.a02recursion;

public class Demo01Sum {

	public static void main(String[] args) {
		System.out.println(sum(10));
	}

	/**
	 * 计算 1 + 2 + 3 + 4 + ... n
	 * @param n 总数
	 * @return sum
	 */
	public static int sum(int n) {
		if (n <= 1) {
			return n;
		}
		return n + sum(n - 1);
	}
}
