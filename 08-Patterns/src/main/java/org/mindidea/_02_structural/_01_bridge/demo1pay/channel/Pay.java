package org.mindidea._02_structural._01_bridge.demo1pay.channel;

import org.mindidea._02_structural._01_bridge.demo1pay.mode.IPayMode;

import java.math.BigDecimal;

public abstract class Pay {
	protected IPayMode payMode;

	public Pay(IPayMode mode) {
		this.payMode = mode;
	}

	public abstract String transfer(String uId, String tradeId, BigDecimal amount);
}
