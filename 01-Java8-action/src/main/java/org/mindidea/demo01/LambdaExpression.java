package org.mindidea.demo01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class LambdaExpression {

	private static int count = 0;

	public static void main(String[] args) throws InterruptedException {
		/*
		 * lambda 简单用法
		 */
		System.out.println("1. lambda 简单用法");
		m1();
		/*
		 * Predicate 用法
		 */
		System.out.println("2. Predicate 用法");
		List<Apple> appleList = Arrays.asList(
				new Apple("red", 120d),
				new Apple("green", 135d),
				new Apple("red", 128d)
		);
		List<Apple> redApples = filter0(appleList, apple -> "red".equals(apple.getColor()) && apple.getWeight() > 120d);
		System.out.println(redApples);
		/*
		 * DoublePredicate 用法
		 */
		System.out.println("3. DoublePredicate 用法");
		List<Apple> apples = filter1(appleList, w -> w > 120);
		System.out.println(apples);
		/*
		 * BiPredicate 用法
		 */
		System.out.println("4. BiPredicate 用法");
		List<Apple> apples2 = filter2(appleList, (c, w) -> "red".equals(c) && w > 120);
		System.out.println(apples2);
		/*
		 * Consumer 用法
		 */
		System.out.println("==============================");
		consumerTest1(appleList, apple -> System.out.println(apple.getColor() + "_" + apple.getWeight()));
		/*
		 * BiConsumer 用法
		 */
		System.out.println("==============================");
		consumerTest2(appleList, (c, w) -> System.out.println(c + "=" + w));

		/*
		 * Function 用法
		 */
		System.out.println("==============================");
		String s = functionTest1(appleList.get(0), Apple::toString);
		System.out.println(s);
	}

	private static String functionTest1(Apple apple, Function<Apple, String> function) {
		return function.apply(apple);
	}

	private static void consumerTest2(List<Apple> source, BiConsumer<String, Double> consumer) {
		for (Apple a : source) {
			consumer.accept(a.getColor(), a.getWeight());
		}
	}

	private static void consumerTest1(List<Apple> source, Consumer<Apple> consumer) {
		for (Apple a : source) {
			consumer.accept(a);
		}
	}

	private static List<Apple> filter2(List<Apple> source, BiPredicate<String, Double> predicate) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : source) {
			if (!predicate.test(apple.getColor(), apple.getWeight())) {
				continue;
			}
			result.add(apple);
		}
		return result;
	}

	private static List<Apple> filter1(List<Apple> source, DoublePredicate predicate) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : source) {
			if (!predicate.test(apple.getWeight())) {
				continue;
			}
			result.add(apple);
		}
		return result;
	}

	private static List<Apple> filter0(List<Apple> source, Predicate<Apple> predicate) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : source) {
			if (!predicate.test(apple)) {
				continue;
			}
			result.add(apple);
		}
		return result;
	}

	private static void m1() throws InterruptedException {
		// 使用 lambda 表达式实现 Runnable 接口
		Runnable r1 = () -> System.out.println("hello");
		new Thread(r1).start();
		// 语句
		r1 = () -> {
			while (count < 100) {
				count++;
			}
		};
		Thread t1 = new Thread(r1);
		t1.start();
		t1.join();
		System.out.println(count);
	}
}
