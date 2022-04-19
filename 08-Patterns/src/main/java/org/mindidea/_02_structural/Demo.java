package org.mindidea._02_structural;

import org.mindidea._02_structural._01_bridge.demo1pay.channel.AlPay;
import org.mindidea._02_structural._01_bridge.demo1pay.channel.Pay;
import org.mindidea._02_structural._01_bridge.demo1pay.channel.WxPay;
import org.mindidea._02_structural._01_bridge.demo1pay.mode.CypherMode;
import org.mindidea._02_structural._01_bridge.demo1pay.mode.FaceIdMode;
import org.mindidea._02_structural._01_bridge.demo1pay.mode.FingerPrintMode;

import java.math.BigDecimal;

public class Demo {
	public static void main(String[] args) {
		Pay wxPay = new WxPay(new FaceIdMode());
		wxPay.transfer("wx0001", "0001", new BigDecimal(100));
		System.out.println("==============================================");
		Pay wxPay1 = new WxPay(new CypherMode());
		wxPay1.transfer("wx0002", "0002", new BigDecimal(300));
		System.out.println("==============================================");
		Pay alpay = new AlPay(new FingerPrintMode());
		alpay.transfer("al0001", "0001", new BigDecimal(1009));
		System.out.println("==============================================");
	}
}
