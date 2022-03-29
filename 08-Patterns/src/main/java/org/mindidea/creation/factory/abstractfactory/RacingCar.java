package org.mindidea.creation.factory.abstractfactory;


public class RacingCar extends AbstractCar {

	public RacingCar() {
		this.engine = "V8 发动机";
	}

	@Override
	void run() {
		System.out.println("the racing car is running with " + engine);
	}
}
