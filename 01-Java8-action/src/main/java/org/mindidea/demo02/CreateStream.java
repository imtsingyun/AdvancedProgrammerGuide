package org.mindidea.demo02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CreateStream {
	public static void main(String[] args) {

	}

	private static Stream<String> createStreamFromCollection() {
		List<String> list = Arrays.asList("a", "b", "c", "d");
		return list.stream();
	}

	private static Stream<String> createStreamFromValues() {
		return Stream.of("a", "b", "c", "d");
	}

	private static Stream<String> createStreamFromArrays() {
		String[] strings = {"a", "b", "c", "d"};
		return Arrays.stream(strings);
	}

	private static Stream<String> createStreamFromFile() {
		Path path = Paths.get("");
		try {
			Stream<String> lines = Files.lines(path);
			lines.forEach(System.out::println);
			return lines;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	private static Stream<Integer> createStreamIterate() {
		return Stream.iterate(0, n -> n + 2);
	}

	private static Stream<Double> createStreamFromGenerate() {
		return Stream.generate(Math::random).limit(20);
	}

	private static Stream<Obj> createObjStreamFromGenerate() {
		return Stream.generate(new ObjSupplier()).limit(30);
	}
	static class ObjSupplier implements Supplier<Obj> {
		private int index = 0;

		private Random random = new Random(System.currentTimeMillis());

		@Override
		public Obj get() {
			index = random.nextInt(100);
			return new Obj(index, "Name -> " + index);
		}
	}

	static class Obj {
		private int id;
		private String name;

		public Obj(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
