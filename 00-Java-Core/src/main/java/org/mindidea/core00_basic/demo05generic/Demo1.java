package org.mindidea.core00_basic.demo05generic;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		System.out.println(list1.getClass().getName());
		System.out.println(list2.getClass().getName());

		List list = new ArrayList();
		list = list1;
		list1.add("1");
		list.add(123);
		System.out.println(list);
	}
}