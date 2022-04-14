package org.mindidea.creation.factory.abstractfactory.project2;

public class CommonMask extends AbstractMask {

	public CommonMask() {
		this.price = 1;
	}

	@Override
	public void protectedMe() {
		System.out.println("Common mask is protecting me, and price is " + price);
	}
}
