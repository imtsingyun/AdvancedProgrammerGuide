package org.mindidea.creation.factory.factorymethod;

public class MainTest {
	public static void main(String[] args) {
		AbstractCarFactory f1 = new WulinMiniCarFactory();
		f1.newCar().run();
		AbstractCarFactory f2 = new WulinVanCarFactory();
		f2.newCar().run();
		AbstractCarFactory f3 = new WulinRacingCarFactory();
		f3.newCar().run();
	}
}
