package org.mindidea.算法.a03backtracking;

public class Demo03Queens {

	int[] cols;
	public int ways = 0;

	public static void main(String[] args) {
		new Demo03Queens().init(8);
	}


	/**
	 * 初始化
	 *
	 * @param n 皇后数量
	 */
	void init(int n) {
		if (n < 1) {
			throw new IllegalArgumentException("The number of queens must be greater than zero.");
		}
		cols = new int[n];
		place(0);
		System.out.println(n + "皇后共有:" + ways + "种摆法。");
	}

	void place(int row) {
		if (row == cols.length) {
			ways++;
			show();
			return;
		}
		for (int col = 0; col < cols.length; col++) {
			if (isValid(col, row)) {
				cols[row] = col;
				place(row + 1);
			}
		}
	}

	boolean isValid(int col, int row) {
		for (int i = 0; i < row; i++) {
			if (cols[i] == col) {
				return false;
			}
			if (row - i == Math.abs(cols[i] - col)) {
				return false;
			}
		}
		return true;
	}

	void show() {
		for (int i = 0; i < cols.length; i++) {
			for (int col : cols) {
				if (i == col) {
					System.out.print("*  ");
				} else {
					System.out.print("-  ");
				}
			}
			System.out.println();
		}
		System.out.println("========================");
	}
}
