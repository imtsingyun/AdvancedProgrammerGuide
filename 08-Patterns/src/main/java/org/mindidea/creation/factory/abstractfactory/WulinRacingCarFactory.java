package org.mindidea.creation.factory.abstractfactory;

public class WulinRacingCarFactory extends WulinCarFactory {
	@Override
	public AbstractCar newCar() {
		return new RacingCar();
	}
}
