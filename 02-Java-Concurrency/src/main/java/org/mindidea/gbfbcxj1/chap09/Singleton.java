package org.mindidea.gbfbcxj1.chap09;

import java.security.Signature;

public class Singleton {

	private static int x = 0;

	private static int y;

	private static Singleton instance = new Singleton();

	private Singleton() {
		x++;
		y++;
	}

	public static Singleton getInstance() {
		return instance;
	}

	public static void main(String[] args) {
		Singleton instance = Singleton.getInstance();
		System.out.println(instance.x);
		System.out.println(instance.y);
	}
}
