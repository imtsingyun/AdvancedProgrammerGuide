package org.mindidea._01_creation._03_abstract_factory.notebook;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 三星笔记本
 *
 * @author tsingyun
 * @version V1.0
 * 2022/4/16 22:56
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class GalaxyBook extends AbstractNotebook {

	public GalaxyBook(String name, String cpu, String os, String graphics) {
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
