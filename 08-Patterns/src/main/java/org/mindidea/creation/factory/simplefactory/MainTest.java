package org.mindidea.creation.factory.simplefactory;

public class MainTest {
	public static void main(String[] args) {
		WulinFactory factory = new WulinFactory();

		AbstractCar van = factory.newCar("van");
		AbstractCar mini = factory.newCar("mini");
		van.run();
		mini.run();
	}
}
