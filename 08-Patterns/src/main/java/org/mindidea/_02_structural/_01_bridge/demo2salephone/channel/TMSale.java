package org.mindidea._02_structural._01_bridge.demo2salephone.channel;

public class TMSale extends AbstractSale {
	public TMSale(String type, Integer price) {
		super(type, price);
	}

	@Override
	public void getSaleInfo() {
		System.out.print("TM 平台开始销售手机：");
	}
}
