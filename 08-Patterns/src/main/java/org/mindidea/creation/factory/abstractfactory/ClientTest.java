package org.mindidea.creation.factory.abstractfactory;

import org.mindidea.creation.factory.abstractfactory.factory.WulinHangzhouMaskFactory;
import org.mindidea.creation.factory.abstractfactory.factory.WulinRacingCarFactory;
import org.mindidea.creation.factory.abstractfactory.factory.WulinWuhanMaskFactory;
import org.mindidea.creation.factory.abstractfactory.product1.AbstractCar;
import org.mindidea.creation.factory.abstractfactory.project2.AbstractMask;

public class ClientTest {
	public static void main(String[] args) {
		WulinWuhanMaskFactory maskFactory1 = new WulinWuhanMaskFactory();
		AbstractMask abstractMask = maskFactory1.newMask();
		abstractMask.protectedMe();

		WulinHangzhouMaskFactory maskFactory2 = new WulinHangzhouMaskFactory();
		AbstractMask abstractMask1 = maskFactory2.newMask();
		abstractMask1.protectedMe();

		WulinRacingCarFactory carFactory = new WulinRacingCarFactory();
		AbstractCar abstractCar = carFactory.newCar();
		abstractCar.run();
	}
}
