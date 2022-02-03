package org.mindidea.A09字符串.A02KMP算法;

@SuppressWarnings("DuplicatedCode")
public class KmpSolution {

	public static void main(String[] args) {
		String text = "hello world";
		String pattern = "or";
		int res = indexOf(text, pattern);
		System.out.println(res);
	}

	private static int indexOf(String text, String pattern) {
		if (text == null || pattern == null) return -1;

		char[] textChars = text.toCharArray();
		int tlen = textChars.length;
		if (tlen == 0) return -1;

		char[] patternChars = pattern.toCharArray();
		int plen = patternChars.length;
		if (plen == 0) return -1;
		if (tlen < plen) return -1;

		// next 表
		int[] next = next(pattern);
		int pi = 0, ti = 0, lenDalta = tlen - plen;

		while (pi < plen && ti - pi <= lenDalta) {
			if (pi < 0 || textChars[ti] == patternChars[pi]) {
				pi++;
				ti++;
			} else {
				pi = next[pi];
			}
		}
		return (pi == plen) ? (ti - pi) : -1;
	}

	private static int[] next(String pattern) {
		char[] patternChars = pattern.toCharArray();
		int[] next = new int[patternChars.length];

		int i = 0;
		int n = next[0] = -1;
		int imax = patternChars.length - 1;
		while (i < imax) {
			if (n < 0 || pattern.charAt(i) == pattern.charAt(n)) {
				next[++i] = ++n;
			} else {
				n = next[n];
			}
		}
		return next;
	}
}