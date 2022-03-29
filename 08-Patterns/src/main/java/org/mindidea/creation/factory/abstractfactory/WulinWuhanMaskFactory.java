package org.mindidea.creation.factory.abstractfactory;

public class WulinWuhanMaskFactory extends WulinMaskFactory {
	@Override
	public AbstractMask newMask() {
		return new N95Mask();
	}
}
