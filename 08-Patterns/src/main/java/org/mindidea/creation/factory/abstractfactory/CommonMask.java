package org.mindidea.creation.factory.abstractfactory;

public class CommonMask extends AbstractMask {

	public CommonMask() {
		this.price = 1;
	}
	@Override
	void protectedMe() {
		System.out.println("Common mask is protecting me, and price is " + price);
	}
}
