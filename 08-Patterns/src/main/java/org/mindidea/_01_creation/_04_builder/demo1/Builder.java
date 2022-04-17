package org.mindidea._01_creation._04_builder.demo1;

/**
 * 建造者
 */
public interface Builder {

	Computer buildComputer();

	void buildCpu();

	void buildRam();

	void buildDisk();

	void buildGpu();

	void buildMainBoard();
}
