package org.mindidea._01_creation._02_factory_method;

import org.mindidea._01_creation._02_factory_method.factory.AbstractCarFactory;
import org.mindidea._01_creation._02_factory_method.factory.BusFactory;
import org.mindidea._01_creation._02_factory_method.factory.MiniCarFactory;
import org.mindidea._01_creation._02_factory_method.factory.VanCarFactory;
import org.mindidea._01_creation._02_factory_method.product.AbstractCar;

public class Client {
	public static void main(String[] args) {
		AbstractCarFactory f1 = new MiniCarFactory();
		AbstractCar miniCar = f1.newCar();
		miniCar.run();

		AbstractCarFactory f2 = new VanCarFactory();
		AbstractCar vanCar = f2.newCar();
		vanCar.run();

		AbstractCarFactory f3 = new BusFactory();
		AbstractCar bus = f3.newCar();
		bus.run();
	}
}
