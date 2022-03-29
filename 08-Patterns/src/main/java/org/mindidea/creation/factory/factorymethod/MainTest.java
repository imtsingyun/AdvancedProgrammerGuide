package org.mindidea.creation.factory.factorymethod;

public class MainTest {
	public static void main(String[] args) {
		WulinMiniCarFactory f1 = new WulinMiniCarFactory();
		f1.newCar().run();
		WulinVanCarFactory f2 = new WulinVanCarFactory();
		f2.newCar().run();
		WulinRacingCarFactory f3 = new WulinRacingCarFactory();
		f3.newCar().run();
	}
}
