package org.mindidea._02_structural._00_adapter.demo2.adp;

import org.mindidea._02_structural._00_adapter.demo2.dst.IVoltage5V;
import org.mindidea._02_structural._00_adapter.demo2.src.Voltage220V;

public class VoltageAdapter extends Voltage220V implements IVoltage5V {
	@Override
	public int output5V() {
		int src = output220V();
		System.out.println("将220V电压转成5V");
		int dst = src / 44;
		return dst;
	}
}
