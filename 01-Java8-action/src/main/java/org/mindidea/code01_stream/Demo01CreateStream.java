package org.mindidea.code01_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo01CreateStream {
	public static void main(String[] args) {
		m3();
	}

	/**
	 * 1. 使用 Stream.of 方法创建 stream
	 */
	private static void m1() {
		List<String> list = Arrays.asList("a", "b", "c", "d", "E");
		Stream<List<String>> strStream = Stream.of(list);
		strStream.forEach(System.out::print);
		//=================================================
		Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 6);
		stream1 = stream1.map(i->{
			System.out.print(i + " multiply by 2 ");
			return i*2;
		});
		stream1.forEach(System.out::println);
		System.out.println("====================");
	}

	/**
	 * 使用 Stream builder 创建 stream
	 */
	private static void m2() {
		Stream<Object> stream1 = Stream.builder().add(2).add(3).add(5).add(8).build();
		Stream<String> stream2 = Stream.<String>builder().add("a").add("b").add("c").build();
	}

	private static void m3() {
		Stream<Object> empty = Stream.empty();
		System.out.println(empty);
	}
}
