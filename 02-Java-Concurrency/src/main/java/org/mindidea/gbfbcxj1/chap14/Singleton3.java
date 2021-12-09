package org.mindidea.gbfbcxj1.chap14;

public class Singleton3 {

	private Singleton3() {
		System.out.println("111111");
	}

	private static class Holder {
		private static Singleton3 instance = new Singleton3();
	}

	public static Singleton3 getInstance() {
		return Holder.instance;
	}

	public static void main(String[] args) {
		System.out.println("1");
		Singleton3 instance = getInstance();
	}
}
