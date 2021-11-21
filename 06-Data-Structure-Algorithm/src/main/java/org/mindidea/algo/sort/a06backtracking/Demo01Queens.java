package org.mindidea.algo.sort.a06backtracking;

public class Demo01Queens {
	public static void main(String[] args) {
		new Demo01Queens().initial(4);
	}

	/**
	 * 数组索引是行号，数组元素是列号
	 */
	int[] cols;
	int ways;

	void initial(int n) {
		if (n < 1) return;
		cols = new int[n];
		place(0);
		System.out.println(n + "皇后共有:" + ways + "种摆法。");
	}

	void place(int row) {
		if (row == cols.length) {
			ways++;
			show();
			// 此处 row 是 n + 1 行，不存在该行，return 后又回到最后一行
			return;
		}
		for (int col = 0; col < cols.length; col++) {
			if (isValid(row, col)) {
				cols[row] = col;
				place(row + 1);
			}
		}
	}

	boolean isValid(int row, int col) {
		for (int i = 0; i < row; i++) {
			// col 列已经有皇后
			if (cols[i] == col) {
				return false;
			}
			// a(x1, y1) b(x2, y2)
			// 如果 |x1 - x2| == |y1-y2| 则说明 a 点和 b 点在一条 45 度的对角线上
			// cols[i] 表示第 i 行摆放皇后的位置
			if (row - i == Math.abs(col - cols[i])) {
				return false;
			}
		}
		return true;
	}

	void show() {
		for (int i : cols) {
			for (int col = 0; col < cols.length; col++) {
				if (i == col) {
					System.out.print("1 ");
				} else {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}

		System.out.println("--------------------------");
	}
}