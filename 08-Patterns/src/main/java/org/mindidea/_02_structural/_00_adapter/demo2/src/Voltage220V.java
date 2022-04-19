package org.mindidea._02_structural._00_adapter.demo2.src;

public class Voltage220V {
	// 插座，输出 220V 电压
	public int output220V() {
		int src = 220;
		System.out.println("电压=" + src + "V");
		return src;
	}
}
