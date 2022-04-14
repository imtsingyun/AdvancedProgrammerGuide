package org.mindidea.creation.factory.abstractfactory.project2;

public class N95Mask extends AbstractMask {

	public N95Mask() {
		this.price = 2;
	}

	@Override
	public void protectedMe() {
		System.out.println("N95 mask is protecting me, and price is " + price);
	}
}
