package org.mindidea._01_creation._01_simple_factory.product;

import lombok.Data;

@Data
public class MiniCar extends AbstractCar {

	public MiniCar(String engine) {
		this.engine = engine;
	}

	@Override
	public void run() {
		System.out.println(this.getEngine() + " is running quietly");
	}
}
