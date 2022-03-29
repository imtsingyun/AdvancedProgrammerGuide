package org.mindidea.creation.factory.abstractfactory;

public class WulinHangzhouMaskFactory extends WulinMaskFactory {
	@Override
	AbstractMask newMask() {
		return new CommonMask();
	}
}
