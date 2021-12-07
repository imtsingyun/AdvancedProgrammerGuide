package org.mindidea.gbfbcxj1.chap10;

public class BootStrapClassLoader {
	public static void main(String[] args) {
		System.out.println("Bootstrap:" + String.class.getClassLoader());
		System.out.println(System.getProperty("sum.boot.class.path"));
	}
}
