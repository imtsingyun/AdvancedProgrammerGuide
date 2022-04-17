package org.mindidea._01_creation._03_abstract_factory.phone;

/**
 * 手机抽象类
 *
 * @author tsingyun
 * @version V1.0
 * 2022/4/16 17:21
 */
public abstract class AbstractPhone {
	// 手机品牌名称
	public String name;
	// 运行内存大小
	public Integer ram;
	// 存储内存大小
	public Integer rom;
	// 操作系统
	public String os;

	// 手机有打电话功能
	public abstract void call();
}
