package org.mindidea.gbfbcxj1.chap14;

public final class Singleton2 {

	private byte[] data = new byte[1024];

	// volatile 保证可见性、有序性
	// 此处保证其他线程在用 instance 时 instance 内部的所有初始化已经完成
	private static volatile Singleton2 instance = null;

	private Singleton2() {}

	// double-check
	public static Singleton2 getInstance() {
		if (null == instance) {
			synchronized (Singleton2.class) {
				if (null == instance) {
					instance = new Singleton2();
				}
			}
		}
		return instance;
	}

	public static void main(String[] args) {
	}
}
