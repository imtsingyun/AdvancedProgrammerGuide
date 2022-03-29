package org.mindidea.creation.factory.abstractfactory;

public class N95Mask extends AbstractMask {

	public N95Mask() {
		this.price = 2;
	}
	@Override
	void protectedMe() {
		System.out.println("N95 mask is protecting me, and price is " + price);
	}
}
