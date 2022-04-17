package org.mindidea._01_creation._03_abstract_factory.notebook;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MacBook extends AbstractNotebook {

	public MacBook(String name, String cpu, String os, String graphics) {
		this.name = name;
		this.cpu = cpu;
		this.os = os;
		this.graphics = graphics;
	}

	@Override
	public void coding() {
		System.out.println(this.name + ", " + this.cpu + ", " + this.graphics);
	}
}
