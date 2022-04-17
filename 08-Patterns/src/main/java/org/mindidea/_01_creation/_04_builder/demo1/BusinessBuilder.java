package org.mindidea._01_creation._04_builder.demo1;

/**
 * 商务本 Builder
 */
public class BusinessBuilder implements Builder {

	private final Computer computer = new Computer();

	@Override
	public Computer buildComputer() {
		return computer;
	}

	@Override
	public void buildCpu() {
		this.computer.setCpu("Intel Core i10");
	}

	@Override
	public void buildRam() {
		this.computer.setRam("16GB");
	}

	@Override
	public void buildDisk() {
		this.computer.setDisk("固态硬盘512GB");
	}

	@Override
	public void buildGpu() {
		this.computer.setGpu("GTX-1080");
	}

	@Override
	public void buildMainBoard() {
		this.computer.setMainBoard("华硕主板");
	}
}
