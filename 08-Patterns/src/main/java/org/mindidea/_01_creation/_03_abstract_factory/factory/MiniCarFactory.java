package org.mindidea._01_creation._03_abstract_factory.factory;

import org.mindidea._01_creation._03_abstract_factory.product1.AbstractCar;
import org.mindidea._01_creation._03_abstract_factory.product1.MiniCar;

public class MiniCarFactory extends AbstractCarFactory {
	@Override
	public AbstractCar newCar() {
		return new MiniCar("MiniCar, 1.5T");
	}
}
