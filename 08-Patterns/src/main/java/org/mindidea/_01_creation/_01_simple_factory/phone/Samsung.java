package org.mindidea._01_creation._01_simple_factory.phone;

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
public class Samsung extends AbstractPhone {

	public Samsung(String name, int ram, int rom, String os) {
		this.name = name;
		this.ram = ram;
		this.rom = rom;
		this.os = os;
	}

	@Override
	public void call() {
		System.out.println(this.name + ", " + this.os + ", " + this.ram + ", " + this.rom);
	}
}
