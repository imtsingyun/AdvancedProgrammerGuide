package org.mindidea.algo.sort.a09dynamicprogramming;

/**
 * 最长公共子串（连续）
 * ABCFEA, ACFEBE 公共子串是 CFE
 * <p>
 * 假设 dp(i,j) 是以 str1[i-1]、str2[j-1] 结尾的最长公共子串长度
 * dp(i, 0) 和 dp(0, j) 初始值均为 0
 * 如果 str1[i - 1] = str2[j - 1] 那么 牵（i, j) = dp(i - 1, j - 1) + 1
 * 如果
 */
public class Demo06LongestCommSubString {

	public static void main(String[] args) {
		System.out.println(lcs("ABCD", "BABC"));
	}

	private static int lcs(String str1, String str2) {
		if (str1 == null || str2 == null) {
			return 0;
		}
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		if (chars1.length == 0 || chars2.length == 0) {
			return 0;
		}

		int max = 0;
		int[][] dp = new int[chars1.length + 1][chars2.length + 1];
		for (int i = 1; i <= chars1.length; i++) {
			for (int j = 1; j <= chars2.length; j++) {
				if (chars1[i - 1] != chars2[j - 1]) {
					continue;
				}
				dp[i][j] = dp[i - 1][j - 1] + 1;
				max = Math.max(dp[i][j], max);
			}
		}
		return max;
	}
}
