package org.mindidea.creation.singleton;

/**
 * 单例模式：懒汉加载，加锁，线程安全，性能差
 *
 * @author tsingyun
 * @version V1.0
 * 2022/3/29 20:41
 */
public class Singleton04 {

	private static volatile Singleton04 instance;

	private Singleton04() {
		System.out.println("init instance");
	}

	public static Singleton04 getInstance() {
		if (instance == null) {
			synchronized (Singleton04.class) {
				if (instance == null) {
					instance = new Singleton04();
				}
			}
		}
		return instance;
	}

	public static void main(String[] args) {
		Singleton04 instance = Singleton04.getInstance();
		System.out.println(instance);
	}
}
