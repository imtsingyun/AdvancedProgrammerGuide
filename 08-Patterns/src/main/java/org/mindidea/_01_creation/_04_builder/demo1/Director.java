package org.mindidea._01_creation._04_builder.demo1;

public class Director {

	private Builder builder;

	public Director(Builder builder) {
		this.builder = builder;
	}

	public void send() {
		builder.buildGpu();
		builder.buildCpu();
		builder.buildDisk();
		builder.buildRam();
		builder.buildMainBoard();
	}
}
