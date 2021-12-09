package org.mindidea.gbfbcxj1.chap14;

/**
 * 单例模式
 * 饿汉式
 * @author tsingyun
 * @version V1.0
 * @time 2021-12-9 11:09
 */
public final class Singleton1 {

	private byte[] date = new byte[1024];
	private static Singleton1 instance = new Singleton1();

	private Singleton1() {}

	public static Singleton1 getInstance() {
		return instance;
	}
}
