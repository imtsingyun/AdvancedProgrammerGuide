package org.mindidea.A09字符串.A01蛮力算法;

@SuppressWarnings("DuplicatedCode")
public class BruteForce {
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

		int pi = 0, ti = 0;
		while (pi < plen && ti < tlen) {
			if (textChars[ti] == patternChars[pi]) {
				ti++;
				pi++;
			} else {
				ti -= pi - 1;
				pi = 0;
			}
		}
		return (pi == plen) ? (ti - pi) : -1;
	}
}
