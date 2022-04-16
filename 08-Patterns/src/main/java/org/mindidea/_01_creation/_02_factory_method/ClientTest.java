package org.mindidea._01_creation._02_factory_method;

import org.mindidea._01_creation._02_factory_method.factory.FutuAppleFactory;
import org.mindidea._01_creation._02_factory_method.factory.FutuFactory;
import org.mindidea._01_creation._02_factory_method.factory.FutuMiFactory;
import org.mindidea._01_creation._02_factory_method.factory.FutuSamsungFactory;
import org.mindidea._01_creation._02_factory_method.phone.AbstractPhone;

public class ClientTest {
	public static void main(String[] args) {
		// 只在苹果工厂生产苹果手机
		FutuFactory futuAppleFactory = new FutuAppleFactory();
		AbstractPhone iphone = futuAppleFactory.newPhone();
		iphone.call();

		// 只在三星工厂生产三星手机
		FutuFactory futuSamsungFactory = new FutuSamsungFactory();
		AbstractPhone samsung = futuSamsungFactory.newPhone();
		samsung.call();

		// 只在小米工厂生产小米手机
		FutuFactory futuMiFactory = new FutuMiFactory();
		AbstractPhone xiaomi = futuMiFactory.newPhone();
		xiaomi.call();
	}
}
