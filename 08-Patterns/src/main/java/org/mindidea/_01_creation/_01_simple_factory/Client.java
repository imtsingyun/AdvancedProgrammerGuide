package org.mindidea._01_creation._01_simple_factory;

import org.mindidea._01_creation._01_simple_factory.factory.CarFactory;
import org.mindidea._01_creation._01_simple_factory.product.AbstractCar;

public class Client {
	public static void main(String[] args) {
		CarFactory factory = new CarFactory();
		AbstractCar mini = factory.newCar("mini");
		mini.run();
		AbstractCar van = factory.newCar("van");
		van.run();
	}
}
