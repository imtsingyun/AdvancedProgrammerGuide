package org.mindidea._02_structural._00_adapter.demo3;

import org.mindidea._02_structural._00_adapter.demo3.adp.VoltageAdapter;
import org.mindidea._02_structural._00_adapter.demo3.src.Voltage220V;

public class Client {
	public static void main(String[] args) {
		System.out.println("对象适配器模式：");
		Phone p = new Phone();
		p.charging(new VoltageAdapter(new Voltage220V()));
	}
}
