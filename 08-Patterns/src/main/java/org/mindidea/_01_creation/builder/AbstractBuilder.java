package org.mindidea._01_creation.builder;

public abstract class AbstractBuilder {
	Phone phone;
	abstract AbstractBuilder consumeCpu(String cpu);
	abstract AbstractBuilder consumeMem(String mem);
	abstract AbstractBuilder consumeDisk(String disk);
	abstract AbstractBuilder consumeCam(String cam);

	Phone getProduct() {
		return phone;
	}
}
