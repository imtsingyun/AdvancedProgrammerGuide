package org.mindidea.creation.factory.abstractfactory.factory;

import org.mindidea.creation.factory.abstractfactory.product1.AbstractCar;
import org.mindidea.creation.factory.abstractfactory.product1.RacingCar;

public class WulinRacingCarFactory extends WulinCarFactory {
	@Override
	public AbstractCar newCar() {
		return new RacingCar();
	}
}
