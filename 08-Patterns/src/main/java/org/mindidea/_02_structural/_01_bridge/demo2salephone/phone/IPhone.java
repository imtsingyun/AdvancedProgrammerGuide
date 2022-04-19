package org.mindidea._02_structural._01_bridge.demo2salephone.phone;

import org.mindidea._02_structural._01_bridge.demo2salephone.channel.AbstractSale;

public class IPhone extends AbstractPhone {

	private AbstractSale sale;

	public IPhone(AbstractSale sale) {
		super(sale);
		this.sale = sale;
	}

	@Override
	public String getPhone() {
		sale.getSaleInfo();
		System.out.println("卖 iPhone" + ", " + sale.getPrice());
		return null;
	}
}
