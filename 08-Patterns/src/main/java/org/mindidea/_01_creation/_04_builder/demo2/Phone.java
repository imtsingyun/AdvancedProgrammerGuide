package org.mindidea._01_creation._04_builder.demo2;

public class Phone {

	protected String cpu;
	protected String mem;
	protected String disk;
	protected String cam;

	public String getCpu() {
		return cpu;
	}

	public String getMem() {
		return mem;
	}

	public String getDisk() {
		return disk;
	}

	public String getCam() {
		return cam;
	}

	@Override
	public String toString() {
		return "Phone{" +
				"cpu='" + cpu + '\'' +
				", mem='" + mem + '\'' +
				", disk='" + disk + '\'' +
				", cam='" + cam + '\'' +
				'}';
	}
}
