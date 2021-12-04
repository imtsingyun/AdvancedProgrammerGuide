package org.mindidea.demo02;

import java.util.Arrays;
import java.util.List;

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

	}
}
