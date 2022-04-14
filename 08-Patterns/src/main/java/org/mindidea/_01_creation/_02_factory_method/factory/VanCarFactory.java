package org.mindidea._01_creation._02_factory_method.factory;

import org.mindidea._01_creation._02_factory_method.product.AbstractCar;
import org.mindidea._01_creation._02_factory_method.product.VanCar;

public class VanCarFactory extends AbstractCarFactory {
	@Override
	public AbstractCar newCar() {
		return new VanCar("van car 2.0T");
	}
}
