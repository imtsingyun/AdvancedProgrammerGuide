package org.mindidea.creation.factory.factorymethod;

public class VanCar extends AbstractCar {

	public VanCar() {
		this.engine = "单缸柴油机";
	}

	@Override
	void run() {
		System.out.println("the van car is running with " + engine);
	}
}
