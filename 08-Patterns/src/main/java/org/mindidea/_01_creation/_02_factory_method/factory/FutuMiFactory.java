package org.mindidea._01_creation._02_factory_method.factory;

import org.mindidea._01_creation._02_factory_method.phone.AbstractPhone;
import org.mindidea._01_creation._02_factory_method.phone.Xiaomi;

/**
 * 富土康 生产小米手机的工厂
 *
 * @author tsingyun
 * @version V1.0
 * 2022/4/16 23:42
 */
public class FutuMiFactory extends FutuFactory {
	@Override
	public AbstractPhone newPhone() {
		return new Xiaomi("Xiaomi12", 8, 256, "Android 11.0.1");
	}
}
