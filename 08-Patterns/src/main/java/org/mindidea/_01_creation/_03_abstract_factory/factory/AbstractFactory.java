package org.mindidea._01_creation._03_abstract_factory.factory;


import org.mindidea._01_creation._03_abstract_factory.product1.AbstractCar;
import org.mindidea._01_creation._03_abstract_factory.product2.AbstractShip;

public abstract class AbstractFactory {
	public abstract AbstractCar newCar();
	public abstract AbstractShip newShip();
}
