package org.mindidea._01_creation._03_abstract_factory.product2;

public class MiniShip extends AbstractShip {

	public MiniShip(int length) {
		this.length = length;
	}

	@Override
	public void drift() {
		System.out.println(this.length + " meter mini ship is drifting.");
	}
}
