package org.mindidea._02_structural._01_bridge.demo1pay.mode;

public class CypherMode implements IPayMode {
	@Override
	public boolean security(String uId) {
		System.out.println("密码支付，风控校验密码识别");
		return true;
	}
}
