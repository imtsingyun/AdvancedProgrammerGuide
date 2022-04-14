package org.mindidea._01_creation._01_simple_factory.product;

import lombok.Data;

@Data
public abstract class AbstractCar {

	String engine;

	public abstract void run();
}
