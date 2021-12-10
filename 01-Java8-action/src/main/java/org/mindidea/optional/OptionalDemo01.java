package org.mindidea.optional;

import java.util.Optional;

public class OptionalDemo01 {
	public static void main(String[] args) {
		Person p = new Person();
	}
}

class Person {
	private Optional<Car> car;

	public Optional<Car> getCar() {
		return car;
	}
}

class Insurance {
	private String name;

	public String getName() {
		return name;
	}
}

class Car {
	private Optional<Insurance> insurance;

	public Optional<Insurance> getInsurance() {
		return insurance;
	}
}