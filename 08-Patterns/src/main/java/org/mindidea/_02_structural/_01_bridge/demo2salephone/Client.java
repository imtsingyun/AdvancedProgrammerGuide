package org.mindidea._02_structural._01_bridge.demo2salephone;

import org.mindidea._02_structural._01_bridge.demo2salephone.channel.JDSale;
import org.mindidea._02_structural._01_bridge.demo2salephone.phone.IPhone;

public class Client {
	public static void main(String[] args) {
		IPhone iPhone = new IPhone(new JDSale("", 9000));
		iPhone.getPhone();
	}
}
