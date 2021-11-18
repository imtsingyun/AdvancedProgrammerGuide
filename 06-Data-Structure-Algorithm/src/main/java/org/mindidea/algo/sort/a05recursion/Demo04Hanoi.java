package org.mindidea.algo.sort.a05recursion;

/**
 * 当 n = 1 时，将盘子从 A 移到 C
 * 当 n > 1 时，分为以下几步：
 * 1. 将 n-1 个盘子从 A 移到 B
 * 2. 将编号为 n 的盘子从 A 移到 C
 * 3. 将 n-1 个盘子从 B 移到 C
 */
public class Demo04Hanoi {
	public static void main(String[] args) {

	}

	/**
	 * 将 n 个盘子从 p1 挪到  p3, p2 作为中间柱
	 * @param n  盘子个数
	 * @param p1 起点
	 * @param p2 中间柱
	 * @param p3 终点
	 */
	private void hanoi(int n, String p1, String p2, String p3) {

	}
}
