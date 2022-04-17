package org.mindidea._01_creation._05_singleton;

/**
 * 单例模式1：饿汉模式，线程安全
 *
 * @author tsingyun
 * @version V1.0
 * 2022/3/29 20:34
 */
public class Singleton01 {

	private static final Singleton01 instance = new Singleton01();

	private Singleton01() {
		System.out.println("init instance");
	}

	public static Singleton01 getInstance() {
		return instance;
	}

	public static void main(String[] args) {
		Singleton01 instance = Singleton01.getInstance();
		System.out.println(instance);
	}

}
