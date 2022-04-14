package org.mindidea.creation.factory.abstractfactory.product1;

public class VanCar extends AbstractCar {

	public VanCar() {
		this.engine = "单缸柴油机";
	}

	@Override
	public void run() {
		System.out.println("the van car is running with " + engine);
	}
}
