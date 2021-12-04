package org.mindidea.demo01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterApple {

	@FunctionalInterface
	public interface AppleFilter {
		boolean filter(Apple apple);
	}

	public static List<Apple> findApples(List<Apple> apples, AppleFilter appleFilter) {
		List<Apple> list = new ArrayList<>();

		for (Apple apple : apples) {
			if (appleFilter.filter(apple)) {
				list.add(apple);
			}
		}
		return list;
	}

	public static class GreenAnd150WeightFilter implements AppleFilter {
		@Override
		public boolean filter(Apple apple) {
			return ("green".equals(apple.getColor()) && apple.getWeight() >= 140);
		}
	}

	public static void main(String[] args) {
		List<Apple> list = Arrays.asList(
				new Apple("green", 103d),
				new Apple("red", 110d),
				new Apple("yellow", 135d),
				new Apple("red", 152d),
				new Apple("green", 118d),
				new Apple("red", 128d)
		);
		List<Apple> apples = findApples(list, new GreenAnd150WeightFilter());
		System.out.println(apples);

		List<Apple> redApples = findApples(list, apple -> "red".equals(apple.getColor()));
		System.out.println(redApples);
	}
}
