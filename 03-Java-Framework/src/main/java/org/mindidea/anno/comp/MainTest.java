package org.mindidea.anno.comp;

import org.mindidea.anno.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
		Person person = (Person) ctx.getBean("person");
		System.out.println(person);
	}
}
