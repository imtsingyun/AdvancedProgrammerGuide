package org.mindidea.core99_jvm._00stack;

public class StackErrorTest {

	private static int count = 1;

	public static void main(String[] args) {
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			count++;
			main(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
