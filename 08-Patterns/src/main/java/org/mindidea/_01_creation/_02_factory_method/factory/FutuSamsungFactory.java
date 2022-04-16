package org.mindidea._01_creation._02_factory_method.factory;

import org.mindidea._01_creation._02_factory_method.phone.AbstractPhone;
import org.mindidea._01_creation._02_factory_method.phone.Samsung;

/**
 * 富土康 生产三星手机的工厂
 *
 * @author tsingyun
 * @version V1.0
 * 2022/4/16 23:42
 */
public class FutuSamsungFactory extends FutuFactory {
	@Override
	public AbstractPhone newPhone() {
		return new Samsung("Galaxy", 8, 256, "Android 12.0.1");
	}
}
