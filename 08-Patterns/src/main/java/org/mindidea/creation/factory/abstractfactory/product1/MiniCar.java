package org.mindidea.creation.factory.abstractfactory.product1;

public class MiniCar extends AbstractCar {

	public MiniCar() {
		this.engine = "三缸发动机";
	}

	@Override
	public void run() {
		System.out.println("the mini car is running with " + engine);
	}
}
