package org.mindidea._01_creation._02_factory_method.phone;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 苹果手机
 *
 * @author tsingyun
 * @version V1.0
 * 2022/4/16 22:48
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Apple extends AbstractPhone {

	public Apple(String name, int ram, int rom, String os) {
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
