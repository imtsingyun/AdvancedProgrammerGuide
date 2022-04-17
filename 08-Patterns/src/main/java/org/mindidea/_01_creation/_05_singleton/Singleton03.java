package org.mindidea._01_creation._05_singleton;

/**
 * 单例模式：懒汉加载，加锁，线程安全，性能差
 *
 * @author tsingyun
 * @version V1.0
 * 2022/3/29 20:41
 */
public class Singleton03 {

	private static Singleton03 instance;

	private Singleton03() {
		System.out.println("init instance");
	}

	public static synchronized Singleton03 getInstance() {
		if (instance == null) {
			instance = new Singleton03();
		}
		return instance;
	}

	public static void main(String[] args) {
		Singleton03 instance = Singleton03.getInstance();
		System.out.println(instance);
	}
}
