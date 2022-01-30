package org.mindidea.算法.a03backtracking;

public class Demo02Queens {

	public static void main(String[] args) {
		// 	皇后数量
		int n = 8;
		new Demo02Queens().initial(n);
	}

	/**
	 * 标记某一行上是否有皇后
	 */
	boolean[] cols;
	// 标记某一条斜线步是否有皇后（左上角 -> 右下角）
	boolean[] leftTop;
	// 标记某一条斜线上是否有皇后（右上角 -> 左下角）
	boolean[] rightTop;
	int ways;

	void initial(int n) {
		if (n < 1) return;
		cols = new boolean[n];
		// n << 1; n * 2
		leftTop = new boolean[(n << 1) - 1];
		rightTop = new boolean[leftTop.length];
		place(0);
		System.out.println(n + "皇后共有:" + ways + "种摆法。");
	}

	void place(int row) {
		if (row == cols.length) {
			ways++;
			// 此处 row 是 n + 1 行，不存在该行，return 后又回到最后一行
			return;
		}
		for (int col = 0; col < cols.length; col++) {
			if (cols[col]) continue;
			int ltIndex = row - col + cols.length - 1;
			if (leftTop[ltIndex]) continue;
			int rtIndex = row + col;
			if (rightTop[rtIndex]) continue;

			cols[col] = true;
			leftTop[ltIndex] = true;
			rightTop[rtIndex] = true;
			place(row + 1);
			cols[col] = false;
			leftTop[ltIndex] = false;
			rightTop[rtIndex] = false;
		}
	}
}
