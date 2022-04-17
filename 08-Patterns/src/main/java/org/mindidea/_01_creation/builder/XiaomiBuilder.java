package org.mindidea._01_creation.builder;

public class XiaomiBuilder extends AbstractBuilder {
	public XiaomiBuilder() {
		phone = new Phone();
	}
	@Override
	AbstractBuilder consumeCpu(String cpu) {
		phone.cpu = cpu;
		return this;
	}

	@Override
	AbstractBuilder consumeMem(String mem) {
		phone.mem = "32G";
		return this;
	}

	@Override
	AbstractBuilder consumeDisk(String disk) {
		phone.disk = "512G";
		return this;
	}

	@Override
	AbstractBuilder consumeCam(String cam) {
		phone.cam = "5000,000";
		return this;
	}
}
