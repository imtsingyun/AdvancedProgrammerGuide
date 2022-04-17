package org.mindidea._01_creation._04_builder.demo1;

import lombok.Data;

/**
 * 组装电脑
 *
 * @author tsingyun
 * @version V1.0
 * 2022/4/17 23:51
 */
@Data
public class Computer {

	/**
	 * CPU
	 */
	private String cpu;

	/**
	 * 内存
	 */
	private String ram;

	/**
	 * 硬盘
	 */
	private String disk;

	/**
	 * 显卡
	 */
	private String gpu;

	/**
	 * 主板
	 */
	private String mainBoard;

	@Override
	public String toString() {
		return "Computer{" +
				"cpu='" + cpu + '\'' +
				", ram='" + ram + '\'' +
				", disk='" + disk + '\'' +
				", gpu='" + gpu + '\'' +
				", mainBoard='" + mainBoard + '\'' +
				'}';
	}
}
