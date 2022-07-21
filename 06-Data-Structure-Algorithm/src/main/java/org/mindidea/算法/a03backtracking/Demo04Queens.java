package org.mindidea.算法.a03backtracking;

public class Demo04Queens {

	public static void main(String[] args) {
		new Demo04Queens().init(8);
	}

	int[] cols;
	int ways;

	void init(int n) {
		cols = new int[n];
		place(0);
		System.out.println(ways);
	}

	void place(int row) {
		if (row == cols.length) {
			ways++;
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
}
