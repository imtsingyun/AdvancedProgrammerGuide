package org.mindidea._02_structural._01_bridge.demo1pay.mode;

public class FingerPrintMode implements IPayMode {
	@Override
	public boolean security(String uId) {
		System.out.println("指纹支付，风控校指纹识别");
		return true;
	}
}
