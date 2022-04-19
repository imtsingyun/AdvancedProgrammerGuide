package org.mindidea._02_structural._00_adapter.demo3.adp;

import org.mindidea._02_structural._00_adapter.demo3.dst.IVoltage5V;
import org.mindidea._02_structural._00_adapter.demo3.src.Voltage220V;

public class VoltageAdapter implements IVoltage5V {
	private Voltage220V voltage220V;
	public VoltageAdapter(Voltage220V voltage220V) {
		this.voltage220V = voltage220V;
	}
	@Override
	public int output5V() {
		int src = voltage220V.output220V();
		System.out.println("将220V电压转成5V");
		int dst = src / 44;
		return dst;
	}
}
