package org.mindidea.anno.comp;

import org.mindidea.anno.bean.Person;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;


// 配置类等同于 配置文件
@Configuration
// 扫描指定包下的 组件, excludeFilters 排除相关组件
@ComponentScan(value = "org.mindidea", excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
}, includeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Component.class}),
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = Person.class)
})
public class MainConfig {

	// 在容器中注册一个 Bean
	// 类型为返回值类型，id 默认为方法名
	//@Bean("person")
	public Person person() {
		return new Person("Tom", 12);
	}
}
