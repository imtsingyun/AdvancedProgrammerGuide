package org.mindidea._01_creation._04_builder.demo1;

/**
 * 游戏本 builder
 */
public class GameBuilder implements Builder{

	private final Computer computer = new Computer();

	@Override
	public Computer buildComputer() {
		return computer;
	}

	@Override
	public void buildCpu() {
		this.computer.setCpu("Intel Core i12");
	}

	@Override
	public void buildRam() {
		this.computer.setRam("64GB");
	}

	@Override
	public void buildDisk() {
		this.computer.setDisk("固态硬盘2TB");
	}

	@Override
	public void buildGpu() {
		this.computer.setGpu("GTX-3080");
	}

	@Override
	public void buildMainBoard() {
		this.computer.setMainBoard("👽外星人");
	}
}
