package org.mindidea.creation.factory.abstractfactory.product1;


public class RacingCar extends AbstractCar {

	public RacingCar() {
		this.engine = "V8 发动机";
	}

	@Override
	public void run() {
		System.out.println("the racing car is running with " + engine);
	}
}
