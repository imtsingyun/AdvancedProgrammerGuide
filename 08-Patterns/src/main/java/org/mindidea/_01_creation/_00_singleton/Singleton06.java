package org.mindidea._01_creation._00_singleton;

/**
 * 枚举实现单例
 *
 * @author Wang
 * @version V1.0
 * Created on 2022-7-28 11:22
 */
public class Singleton06 {

	private Singleton06() {

	}

	private enum Singleton {
		INSTANCE;

		private Singleton06 instance;

		Singleton() {
			instance = new Singleton06();
		}

		public Singleton06 getInstance() {
			return instance;
		}
	}

	public static Singleton06 getInstance() {
		return Singleton.INSTANCE.getInstance();
	}


	public static void main(String[] args) {
		System.out.println(Singleton06.getInstance());
		System.out.println(Singleton06.getInstance());
	}
}
