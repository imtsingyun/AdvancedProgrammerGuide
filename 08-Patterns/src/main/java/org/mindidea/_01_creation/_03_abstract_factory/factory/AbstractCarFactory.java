package org.mindidea._01_creation._03_abstract_factory.factory;


import org.mindidea._01_creation._03_abstract_factory.product2.AbstractShip;

public abstract class AbstractCarFactory extends AbstractFactory {
	@Override
	public AbstractShip newShip() {
		return null;
	}
}
