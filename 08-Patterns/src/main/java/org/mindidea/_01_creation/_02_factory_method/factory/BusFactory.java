package org.mindidea._01_creation._02_factory_method.factory;


import org.mindidea._01_creation._02_factory_method.product.AbstractCar;
import org.mindidea._01_creation._02_factory_method.product.Bus;

public class BusFactory extends AbstractCarFactory {
	@Override
	public AbstractCar newCar() {
		return new Bus("Bus, 2.5L");
	}
}
