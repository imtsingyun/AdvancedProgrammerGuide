package org.mindidea.creation.factory.abstractfactory;

public class MainTest {
	public static void main(String[] args) {
		WulinFactory f1 = new WulinWuhanMaskFactory();
		f1.newMask().protectedMe();
	}
}
