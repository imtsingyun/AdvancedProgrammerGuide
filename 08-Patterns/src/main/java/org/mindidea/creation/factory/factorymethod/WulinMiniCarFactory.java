package org.mindidea.creation.factory.factorymethod;

public class WulinMiniCarFactory extends AbstractCarFactory {
	@Override
	public AbstractCar newCar() {
		return new MiniCar();
	}
}
