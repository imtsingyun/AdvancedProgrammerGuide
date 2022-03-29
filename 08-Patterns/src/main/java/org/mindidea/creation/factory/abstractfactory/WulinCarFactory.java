package org.mindidea.creation.factory.abstractfactory;

public abstract class WulinCarFactory extends WulinFactory {
	abstract AbstractCar newCar();

	@Override
	AbstractMask newMask() {
		return null;
	}
}
