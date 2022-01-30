package org.mindidea.算法.a02recursion;

public class Demo06Hanoi {
	public static void main(String[] args) {
		hanoi(3, "A", "B", "C");
	}

	private static void hanoi(int n, String p1, String p2, String p3) {
		if (n == 1) {
			move(1, p1, p3);
			return;
		}
		hanoi(n - 1, p1, p3, p2);
		move(n, p1, p3);
		hanoi(n - 1, p2, p1, p3);
	}

	private static void move(int n, String from, String to) {
		System.out.println("NO:" + n + ", is moved from " + from + " to " + to);
	}
}
