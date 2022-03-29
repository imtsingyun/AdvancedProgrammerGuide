package org.mindidea.creation.builder;

public class MainTest {
	public static void main(String[] args) {
		AbstractBuilder builder = new XiaomiBuilder();
		Phone phone = builder.consumeCam("5000,000")
				.consumeCpu("骁龙830")
				.consumeDisk("512G")
				.consumeMem("16G")
				.getProduct();

		System.out.println(phone);
	}
}
