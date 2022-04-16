package org.mindidea._01_creation._02_factory_method.factory;

import org.mindidea._01_creation._02_factory_method.phone.AbstractPhone;

/**
 * 富土康总厂
 *
 * @author tsingyun
 * @version V1.0
 * 2022/4/16 17:19
 */
public abstract class FutuFactory {
	// 抽象方法，生产手机
	public abstract AbstractPhone newPhone();
}