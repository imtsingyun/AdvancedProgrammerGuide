package org.mindidea.anno.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope
@Component
public class Person {
	private String name;
	private Integer age;

	public Person() {
	}

	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
