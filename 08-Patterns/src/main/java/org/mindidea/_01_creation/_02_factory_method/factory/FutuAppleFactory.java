package org.mindidea._01_creation._02_factory_method.factory;

import org.mindidea._01_creation._02_factory_method.phone.AbstractPhone;
import org.mindidea._01_creation._02_factory_method.phone.Apple;

/**
 * 富土康 生产苹果手机的工厂
 *
 * @author tsingyun
 * @version V1.0
 * 2022/4/16 23:42
 */
public class FutuAppleFactory extends FutuFactory {
	@Override
	public AbstractPhone newPhone() {
		return new Apple("iPhone", 4, 128, "iOS 15.4.1");
	}
}
