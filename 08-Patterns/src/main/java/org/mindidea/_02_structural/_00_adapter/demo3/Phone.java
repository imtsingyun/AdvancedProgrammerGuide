package org.mindidea._02_structural._00_adapter.demo3;

import org.mindidea._02_structural._00_adapter.demo3.dst.IVoltage5V;

public class Phone {

	public void charging(IVoltage5V iVoltage5V) {
		if (iVoltage5V.output5V() == 5) {
			System.out.println("电压为5V，可以充电🔋");
		}
	}
}
