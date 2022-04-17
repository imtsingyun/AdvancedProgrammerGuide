package org.mindidea._01_creation._03_abstract_factory.notebook;

/**
 * 笔记本抽象类
 *
 * @author tsingyun
 * @version V1.0
 * 2022/4/16 22:43
 */
public abstract class AbstractNotebook {
	// 笔记本品牌名称
	public String name;
	// CPU 配置
	public String cpu;
	// 显卡配置
	public String graphics;

	public String os;

	// 笔记本可以玩游戏
	public abstract void coding();
}
