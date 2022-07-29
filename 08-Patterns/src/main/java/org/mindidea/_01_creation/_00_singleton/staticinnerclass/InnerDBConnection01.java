package org.mindidea._01_creation._00_singleton.staticinnerclass;

import lombok.Data;

@Data
public class InnerDBConnection01 {

	private InnerDBConnection01() {
		System.out.println("init....................................");
	}

	public static InnerDBConnection01 getInstance() {
		return InstanceHolder.instance;
	}

	private static class InstanceHolder {
		final static InnerDBConnection01 instance = new InnerDBConnection01();
	}

	@Override
	public String toString() {
		return "InnerDBConnection01{}" + hashCode();
	}
}
