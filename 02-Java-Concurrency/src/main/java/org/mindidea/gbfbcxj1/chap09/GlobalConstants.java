package org.mindidea.gbfbcxj1.chap09;

import java.util.Random;

public class GlobalConstants {
	static {
		System.out.println("The GlobalConstants will be init");
	}
	// 在其他类中调用 MAX 不会导致 本类被加载，上面的静态代码不会输出
	public final static int MAX = 100;
	public final static int RANDOM = new Random().nextInt();
}
