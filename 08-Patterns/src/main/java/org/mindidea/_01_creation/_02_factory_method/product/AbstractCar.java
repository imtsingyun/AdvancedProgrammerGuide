package org.mindidea._01_creation._02_factory_method.product;

import lombok.Data;

@Data
public abstract class AbstractCar {

	protected String engine;

	public abstract void run();
}
