package org.mindidea.core99_jvm._00stack;

public class Test {
	public static void main(String[] args) {
		byte[] placeholder = new byte[64 * 1024 * 1024];
		System.gc();
	}
}
