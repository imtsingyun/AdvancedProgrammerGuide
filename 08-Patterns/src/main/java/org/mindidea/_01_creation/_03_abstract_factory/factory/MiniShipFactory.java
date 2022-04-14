package org.mindidea._01_creation._03_abstract_factory.factory;

import org.mindidea._01_creation._03_abstract_factory.product2.AbstractShip;
import org.mindidea._01_creation._03_abstract_factory.product2.MiniShip;

public class MiniShipFactory extends AbstractShipFactory {
	@Override
	public AbstractShip newShip() {
		return new MiniShip(10);
	}
}
