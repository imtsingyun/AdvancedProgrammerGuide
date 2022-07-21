package org.mindidea.算法.a03backtracking;

public class Demo05Queens {

	private int[] cols;
	private int ways;

	public static void main(String[] args) {
		new Demo05Queens().init(8);
	}

	void init(int n) {
		if (n < 1) {
			throw new IllegalArgumentException("The number of queens must be greater than zero.");
		}
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
			if (isValid(row, col)) {
				cols[row] = col;
				place(row + 1);
			}
		}
	}

	boolean isValid(int row, int col) {
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
