package org.mindidea.creation.factory.abstractfactory.factory;

import org.mindidea.creation.factory.abstractfactory.product1.AbstractCar;
import org.mindidea.creation.factory.abstractfactory.project2.AbstractMask;
import org.mindidea.creation.factory.abstractfactory.project2.CommonMask;

public class WulinHangzhouMaskFactory extends WulinMaskFactory {
	@Override
	public AbstractCar newCar() {
		return null;
	}

	@Override
	public AbstractMask newMask() {
		return new CommonMask();
	}
}
