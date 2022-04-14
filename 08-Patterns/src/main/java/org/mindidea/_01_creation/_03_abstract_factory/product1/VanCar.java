package org.mindidea._01_creation._03_abstract_factory.product1;

import lombok.Data;

@Data
public class VanCar extends AbstractCar {

	public VanCar(String engine) {
		this.engine = engine;
	}

	@Override
	public void run() {
		System.out.println(this.getEngine() + " is running, wuwu!");
	}
}
