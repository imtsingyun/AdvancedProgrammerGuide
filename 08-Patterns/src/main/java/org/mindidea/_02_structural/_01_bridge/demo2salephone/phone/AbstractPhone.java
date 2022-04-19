package org.mindidea._02_structural._01_bridge.demo2salephone.phone;

import org.mindidea._02_structural._01_bridge.demo2salephone.channel.AbstractSale;

public abstract class AbstractPhone {

	private AbstractSale sale;

	public AbstractPhone(AbstractSale sale) {
		this.sale = sale;
	}

	public abstract String getPhone();
}
