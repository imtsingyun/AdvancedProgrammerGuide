package org.mindidea._01_creation._02_factory_method.product;

import lombok.Data;

@Data
public class Bus extends AbstractCar {

	public Bus(String engine) {
		this.engine = engine;
	}

	@Override
	public void run() {
		System.out.println(this.getEngine() + " is running, dudu");
	}
}
