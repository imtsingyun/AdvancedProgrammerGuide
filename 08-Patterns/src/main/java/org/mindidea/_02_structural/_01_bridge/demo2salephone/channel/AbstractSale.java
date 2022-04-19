package org.mindidea._02_structural._01_bridge.demo2salephone.channel;

public abstract class AbstractSale {

	private String type;
	private Integer price;

	public AbstractSale(String type, Integer price) {
		this.type = type;
		this.price = price;
	}

	public abstract void getSaleInfo();

	public String getType() {
		return type;
	}

	public Integer getPrice() {
		return price;
	}
}
