package org.mindidea._01_creation._01_simple_factory;

import org.mindidea._01_creation._01_simple_factory.factory.FutuFactory;
import org.mindidea._01_creation._01_simple_factory.phone.AbstractPhone;

public class ClientTest {
	public static void main(String[] args) {
		// 创建工厂
		FutuFactory futu = new FutuFactory();

		// 生产手机
		AbstractPhone iPhone = futu.newPhone("apple");
		AbstractPhone android = futu.newPhone("samsung");

		// 测试手机功能
		iPhone.call();
		android.call();
	}
}
