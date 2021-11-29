package org.mindidea.algo.a07greedy;

import java.util.Arrays;

public class Demo03CoinChanges {
	public static void main(String[] args) {
		// 硬币的面值
		Integer[] faces = {25, 10, 5, 1};
		// 25, 10, 5, 1
		Arrays.sort(faces, (Integer f1, Integer f2) -> (f2 - f1));
		int money = 90, coins = 0, i = 0;

		while (i < faces.length) {
			if (money < faces[i]) {
				i++;
				continue;
			}

			System.out.println(faces[i]);
			money -= faces[i];
			coins++;
		}
		System.out.println("------------");
		System.out.println(coins);
	}
}
