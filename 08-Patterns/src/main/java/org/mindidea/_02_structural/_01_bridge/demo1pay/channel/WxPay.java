package org.mindidea._02_structural._01_bridge.demo1pay.channel;

import org.mindidea._02_structural._01_bridge.demo1pay.mode.IPayMode;

import java.math.BigDecimal;

public class WxPay extends Pay {

	public WxPay(IPayMode mode) {
		super(mode);
	}

	@Override
	public String transfer(String uId, String tradeId, BigDecimal amount) {
		System.out.println("模拟微信支付开始：" + uId + ", " + tradeId + ", " + amount);
		boolean security = payMode.security(uId);
		System.out.println("模拟微信支付风险校验：" + uId + ", " + tradeId + ", " + amount);
		if (!security) {
			System.out.println("模拟微信支付拦截：" + uId + ", " + tradeId + ", " + amount);
			return "0001";
		}
		System.out.println("模拟微信支付成功：：" + uId + ", " + tradeId + ", " + amount);
		return "0000";
	}
}
