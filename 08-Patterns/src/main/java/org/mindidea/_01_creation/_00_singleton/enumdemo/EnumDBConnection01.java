package org.mindidea._01_creation._00_singleton.enumdemo;

public class EnumDBConnection01 {

	private String host;
	private Integer port;

	private EnumDBConnection01() {
	}

	public static EnumDBConnection01 getInstance() {
		return InstanceEnum.INSTANCE.instance;
	}

	private enum InstanceEnum {
		INSTANCE;
		private EnumDBConnection01 instance;

		InstanceEnum() {
			instance = new EnumDBConnection01();
		}
	}

	@Override
	public String toString() {
		return "EnumDBConnection01{" +
				"host='" + host + '\'' +
				", port=" + port +
				'}' + hashCode();
	}
}
