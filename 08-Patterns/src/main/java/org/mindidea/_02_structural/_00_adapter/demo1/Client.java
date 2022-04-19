package org.mindidea._02_structural._00_adapter.demo1;

import org.mindidea._02_structural._00_adapter.demo1.adp.Adapter;

public class Client {
	public static void main(String[] args) {
		System.out.println("类适配器模式：");
		StockAnalysis stockAnalysis = new StockAnalysis();
		stockAnalysis.analysis(new Adapter());
	}
}
