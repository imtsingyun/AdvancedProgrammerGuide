package org.mindidea.demo02;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Stream 入门 1
 *
 * @author tsingyun
 * @version V1.0
 * @time 2021/12/5 0:01
 */
public class SimpleStream {

	public static void main(String[] args) {
		List<Dish> menu = Arrays.asList(
				new Dish("Pork", false, 800, Dish.Type.MEAT),
				new Dish("Beef", false, 700, Dish.Type.MEAT),
				new Dish("Chicken", false, 400, Dish.Type.MEAT),
				new Dish("French fries", true, 530, Dish.Type.OTHER),
				new Dish("Rice", true, 350, Dish.Type.OTHER),
				new Dish("Reason Fruit", true, 120, Dish.Type.OTHER),
				new Dish("Pizza", true, 550, Dish.Type.OTHER),
				new Dish("Prawns", false, 300, Dish.Type.FISH),
				new Dish("Salmon", false, 450, Dish.Type.FISH)
		);
		System.out.println(getDishNamesByCollections(menu));
		System.out.println(getDishNamesByStream(menu));
	}

	private static List<String> getDishNamesByStream(List<Dish> menu) {
		return menu.stream().filter(d -> d.getCalories() < 400)
				.sorted(Comparator.comparing(Dish::getCalories))
				.map(Dish::getName).collect(Collectors.toList());
	}

	private static List<String> getDishNamesByCollections(List<Dish> menu) {
		List<Dish> lowCalories = new ArrayList<>();

		// filter and get calories less 400
		for (Dish d : menu) {
			if (d.getCalories() < 400) {
				lowCalories.add(d);
			}
		}

		// sort
		lowCalories.sort(Comparator.comparingInt(Dish::getCalories));
		List<String> dishNameList = new ArrayList<>();
		for (Dish d: lowCalories) {
			dishNameList.add(d.getName());
		}
		return dishNameList;
	}
}
