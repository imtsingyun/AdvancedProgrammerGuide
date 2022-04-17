package org.mindidea._01_creation._03_abstract_factory;

import org.mindidea._01_creation._03_abstract_factory.factory.AppleFactory;
import org.mindidea._01_creation._03_abstract_factory.factory.FutuFactory;
import org.mindidea._01_creation._03_abstract_factory.factory.SamsungFactory;
import org.mindidea._01_creation._03_abstract_factory.notebook.AbstractNotebook;
import org.mindidea._01_creation._03_abstract_factory.phone.AbstractPhone;

public class Client {
	public static void main(String[] args) {
		FutuFactory appleFactory = new AppleFactory();
		AbstractNotebook macbook = appleFactory.newNotebook();
		AbstractPhone iphone = appleFactory.newPhone();
		macbook.coding();
		iphone.call();

		FutuFactory samsungFactory = new SamsungFactory();
		AbstractPhone android = samsungFactory.newPhone();
		AbstractNotebook galaxy = samsungFactory.newNotebook();
		android.call();
		galaxy.coding();
	}
}
