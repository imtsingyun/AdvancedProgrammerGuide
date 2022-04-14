package org.mindidea.creation.factory.simplefactory;

public class WulinFactory {

	public AbstractCar newCar(String type) {
		if ("mini".equals(type)) {
			return new MiniCar();
		} else if ("van".equals(type)) {
			return new VanCar();
		}
		// 简单工厂模式，不适合生产过多的产品
		return null;
	}
}
