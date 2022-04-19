package org.mindidea._02_structural._00_adapter.demo2;

import org.mindidea._02_structural._00_adapter.demo2.adp.VoltageAdapter;

public class Client {
	public static void main(String[] args) {
		System.out.println("类适配器模式：");
		Phone p = new Phone();
		p.charging(new VoltageAdapter());
	}
}
