package org.mindidea.algo.a04greedy;

import java.util.Arrays;

public class Demo02CoinChanges {
	public static void main(String[] args) {
		// 硬币的面值
		int[] faces = {25, 10, 5, 1};
		// 从小到大排序
		Arrays.sort(faces);
		int money = 41;
		int coins = 0;

		for (int i = faces.length - 1; i >= 0; i--) {
			if (money < faces[i]) {
				continue;
			}

			System.out.println(faces[i]);
			money -= faces[i];
			coins++;
			i = faces.length;
		}
	}
}
