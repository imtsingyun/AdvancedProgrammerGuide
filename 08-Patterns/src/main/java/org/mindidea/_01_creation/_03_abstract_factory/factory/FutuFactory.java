package org.mindidea._01_creation._03_abstract_factory.factory;

import org.mindidea._01_creation._03_abstract_factory.notebook.AbstractNotebook;
import org.mindidea._01_creation._03_abstract_factory.phone.AbstractPhone;

/**
 * 富土康总厂
 *
 * @author tsingyun
 * @version V1.0
 * 2022/4/16 17:19
 */
public interface FutuFactory {
	// 生产手机
	AbstractPhone newPhone();
	// 生产笔记本
	AbstractNotebook newNotebook();
}