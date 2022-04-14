package org.mindidea._01_creation._02_factory_method.factory;


import org.mindidea._01_creation._02_factory_method.product.AbstractCar;

/**
 * 抽象工厂
 */
public abstract class AbstractCarFactory {
	public abstract AbstractCar newCar();
}
