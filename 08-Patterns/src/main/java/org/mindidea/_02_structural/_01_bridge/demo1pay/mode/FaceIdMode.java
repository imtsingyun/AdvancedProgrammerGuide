package org.mindidea._02_structural._01_bridge.demo1pay.mode;

public class FaceIdMode implements IPayMode {
	@Override
	public boolean security(String uId) {
		System.out.println("人脸支付，风控校验脸部识别");
		return true;
	}
}
