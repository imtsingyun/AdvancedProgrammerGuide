package org.mindidea.creation.factory.abstractfactory.factory;

import org.mindidea.creation.factory.abstractfactory.product1.AbstractCar;
import org.mindidea.creation.factory.abstractfactory.project2.AbstractMask;

public abstract class WulinFactory {
	public abstract AbstractCar newCar();
	public abstract AbstractMask newMask();
}
