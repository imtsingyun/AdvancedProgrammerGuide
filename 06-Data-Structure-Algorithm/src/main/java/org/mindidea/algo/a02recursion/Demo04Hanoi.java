package org.mindidea.algo.a02recursion;

/**
 * 当 n = 1 时，将盘子从 A 移到 C
 * 当 n > 1 时，分为以下几步：
 * 1. 将 n-1 个盘子从 A 移到 B
 * 2. 将编号为 n 的盘子从 A 移到 C
 * 3. 将 n-1 个盘子从 B 移到 C
 */
public class Demo04Hanoi {
	public static void main(String[] args) {
		new Demo04Hanoi().hanoi(2, "A", "B", "C");
	}

	/**
	 * 将 n 个盘子从 p1 挪到  p3, p2 作为中间柱
	 *
	 * @param n  盘子个数
	 * @param p1 起点
	 * @param p2 中间柱
	 * @param p3 终点
	 */
	private void hanoi(int n, String p1, String p2, String p3) {
		if (n == 1) {
			move(1, p1, p3);
			return;
		}
		hanoi(n - 1, p1, p3, p2);
		move(n, p1, p3);
		hanoi(n - 1, p2, p1, p3);
	}

	private void move(int n, String from, String to) {
		System.out.println("将" + n + "号盘子从" + from + "号柱子移到" + to + "柱子");
	}
}
