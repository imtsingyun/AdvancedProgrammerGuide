package org.mindidea._01_creation._05_singleton;

/**
 * 单例模式：懒汉加载，加锁，线程安全，性能差
 *
 * @author tsingyun
 * @version V1.0
 * 2022/3/29 20:41
 */
public class Singleton05 {

	private Singleton05() {
		System.out.println("init instance");
	}

	private static final class InstanceHolder {
		static final Singleton05 instance = new Singleton05();
	}

	public static Singleton05 getInstance() {
		return InstanceHolder.instance;
	}

	public static void main(String[] args) {
		Singleton05 instance = Singleton05.getInstance();
		System.out.println(instance);
	}
}
