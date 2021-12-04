package org.mindidea.demo01;

import java.util.function.Consumer;

/**
 * 方法推导
 *
 * @author tsingyun
 * @version V1.0
 * @time 2021/12/4 22:51
 */
public class MethodReference {
	public static void main(String[] args) {
		// 1.
		Consumer<String> consumer = (s -> System.out.println(s));
		userConsumer(consumer, "Hello0");
		// 2.
		userConsumer(s -> System.out.println(s), "hello1");
		// 使用函数推导
		userConsumer(System.out::println, "hello tsingyun");
	}

	private static <T> void userConsumer(Consumer<T> consumer, T t) {
		consumer.accept(t);
	}
}
