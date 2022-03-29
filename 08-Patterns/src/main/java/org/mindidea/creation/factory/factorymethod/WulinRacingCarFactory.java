package org.mindidea.creation.factory.factorymethod;

public class WulinRacingCarFactory extends AbstractCarFactory {
	@Override
	public AbstractCar newCar() {
		return new RacingCar();
	}
}
