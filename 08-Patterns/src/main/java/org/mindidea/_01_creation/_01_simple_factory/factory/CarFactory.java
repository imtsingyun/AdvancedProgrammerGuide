package org.mindidea._01_creation._01_simple_factory.factory;

import org.mindidea._01_creation._01_simple_factory.product.MiniCar;
import org.mindidea._01_creation._01_simple_factory.product.VanCar;
import org.mindidea._01_creation._01_simple_factory.product.AbstractCar;

public class CarFactory {

	public AbstractCar newCar(String carType) {
		if ("mini".equals(carType)) {
			return new MiniCar("1.5T");
		} else if ("van".equals(carType)) {
			return new VanCar("2.0T");
		}

		return null;
	}
}
