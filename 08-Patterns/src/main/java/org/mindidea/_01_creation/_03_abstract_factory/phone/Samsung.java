package org.mindidea._01_creation._03_abstract_factory.phone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 三星手机
 *
 * @author tsingyun
 * @version V1.0
 * 2022/4/16 22:48
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class Samsung extends AbstractPhone {

	public Samsung(String name, String os, int ram, int rom) {
		this.name = name;
		this.os = os;
		this.ram = ram;
		this.rom = rom;
	}

	@Override
	public void call() {
		System.out.println(this.name + ", " + this.os + ", " + this.ram + ", " + this.rom);
	}
}
