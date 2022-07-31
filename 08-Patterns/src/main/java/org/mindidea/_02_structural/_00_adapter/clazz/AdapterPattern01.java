package org.mindidea._02_structural._00_adapter.clazz;

public class  AdapterPattern01 {
	public static void main(String[] args) {
		Phone phone = new Phone();
		phone.changing(new VoltageAdapter());
	}
}

// src: 被适配的类
class Voltage220V {
	// 输出 220V 电压
	public int output220V() {
		int src = 220;
		System.out.println("原电压：" + src + "V");
		return src;
	}
}

// 适配接口
interface IVoltage5V {
	int output5V();
}

// 类适配器需要用到继承
// 适配器类
class VoltageAdapter extends Voltage220V implements IVoltage5V {
	@Override
	public int output5V() {
		// 原始电压
		int src = output220V();
		// 目标电压: 将 220V 转换成 5V
		int dst = src / 44;
		System.out.println("将220V电压转换成5V");
		return dst;
	}
}

class Phone {
	public void changing(IVoltage5V voltage5V) {
		if (voltage5V.output5V() == 5) {
			System.out.println("电压为 5V，可以充电");
		} else {
			System.out.println("电压不是 5V，无法充电");
		}
	}
}