package org.mindidea._01_creation._03_abstract_factory.factory;

import org.mindidea._01_creation._03_abstract_factory.product1.AbstractCar;

public abstract class AbstractShipFactory extends AbstractFactory {
	@Override
	public AbstractCar newCar() {
		return null;
	}
}
