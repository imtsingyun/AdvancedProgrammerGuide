package org.mindidea._01_creation._01_simple_factory.factory;

import org.mindidea._01_creation._01_simple_factory.phone.AbstractPhone;
import org.mindidea._01_creation._01_simple_factory.phone.Apple;
import org.mindidea._01_creation._01_simple_factory.phone.Samsung;

/**
 * 富土康总厂
 *
 * @author tsingyun
 * @version V1.0
 * 2022/4/16 17:19
 */
public class FutuFactory {

	public AbstractPhone newPhone(String type) {
		if ("apple".equals(type)) {
			return new Apple("iPhone", 4, 128, "iOS 15.4.1");
		} else if ("samsung".equals(type)) {
			return new Samsung("Galaxy", 8, 256, "Android 12.0.1");
		}
		return null;
	}

}
