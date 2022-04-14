package org.mindidea._01_creation._03_abstract_factory.product1;

import lombok.Data;

@Data
public abstract class AbstractCar {

	protected String engine;

	public abstract void run();
}
