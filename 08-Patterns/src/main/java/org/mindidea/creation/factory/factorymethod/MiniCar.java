package org.mindidea.creation.factory.factorymethod;

public class MiniCar extends AbstractCar {

	public MiniCar() {
		this.engine = "三缸发动机";
	}

	@Override
	void run() {
		System.out.println("the mini car is running with " + engine);
	}
}
