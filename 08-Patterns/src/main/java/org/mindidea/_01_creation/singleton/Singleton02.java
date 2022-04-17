package org.mindidea._01_creation.singleton;

/**
 * 单例模式：懒汉加载，线程不安全
 *
 * @author tsingyun
 * @version V1.0
 * 2022/3/29 20:41
 */
public class Singleton02 {

	private static Singleton02 instance;

	private Singleton02() {
		System.out.println("init instance");
	}

	public static Singleton02 getInstance() {
		if (instance == null) {
			instance = new Singleton02();
		}
		return instance;
	}

	public static void main(String[] args) {
		Singleton02 instance = Singleton02.getInstance();
		System.out.println(instance);
	}
}
