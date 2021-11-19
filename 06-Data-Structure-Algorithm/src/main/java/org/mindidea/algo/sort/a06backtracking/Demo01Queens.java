package org.mindidea.algo.sort.a06backtracking;

public class Demo01Queens {
	public static void main(String[] args) {

	}

	int[] cols;
	void placeQueues(int n) {
		if (n < 1) return;
		cols = new int[n];
		place(n);
	}

	void place(int row) {
		for (int col = 0; col < cols.length; col++) {
			if (isValid(row, col)) {
				cols[row] = col;
				place(row + 1);
			}
		}

	}

	boolean isValid(int row, int col) {
		return false;
	}
}