package org.mindidea._01_creation._03_abstract_factory;

import org.mindidea._01_creation._03_abstract_factory.factory.AbstractCarFactory;
import org.mindidea._01_creation._03_abstract_factory.factory.MiniCarFactory;
import org.mindidea._01_creation._03_abstract_factory.factory.MiniShipFactory;
import org.mindidea._01_creation._03_abstract_factory.product1.AbstractCar;
import org.mindidea._01_creation._03_abstract_factory.product2.AbstractShip;

public class Client {
	public static void main(String[] args) {
		AbstractCarFactory miniCarFactory = new MiniCarFactory();
		AbstractCar miniCar = miniCarFactory.newCar();
		miniCar.run();

		MiniShipFactory miniShipFactory = new MiniShipFactory();
		AbstractShip miniShip = miniShipFactory.newShip();
		miniShip.drift();
	}
}
