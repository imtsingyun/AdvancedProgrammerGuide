package org.mindidea._01_creation._02_factory_method.factory;

import org.mindidea._01_creation._02_factory_method.product.AbstractCar;
import org.mindidea._01_creation._02_factory_method.product.MiniCar;

/**
 * 小型车工厂
 */
public class MiniCarFactory extends AbstractCarFactory {
	@Override
	public AbstractCar newCar() {
		return new MiniCar("mini car 1.5T");
	}
}
