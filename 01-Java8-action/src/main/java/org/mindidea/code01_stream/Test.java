package org.mindidea.code01_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		List<Author> authors = getAuthors();
		authors.stream().distinct()
				.filter(author -> author.getAge() < 18)
				.map(Author::getName)
				.forEach(System.out::println);

		authors.stream()
				.flatMap((Function<Author, Stream<?>>) author -> author.getBooks().stream())
				.forEach(System.out::println);
		System.out.println("=====================================================");
		// map 和 flatMap 对比
		List<String> list = Arrays.asList("aaa", "bbb", "ccc");
		/// 1. map
		Stream<char[]> stream = list.stream().map(String::toCharArray);
		stream.forEach((s) -> {
			for (char c : s) {
				System.out.println(c);
			}
		});
		System.out.println("=====================================================");
		String[] words = {"Hello", "world"};
		Stream<String[]> stream1 = Arrays.stream(words).map(w -> w.split(""));
		Stream<String> stringStream = stream1.flatMap(Arrays::stream);
		stringStream.forEach(System.out::println);
	}

	private static List<Author> getAuthors() {
		Author author1 = new Author(1L, "MD1", 33, "AB1C", null);
		Author author2 = new Author(2L, "MD2", 15, "AB2C", null);
		Author author3 = new Author(3L, "MD3", 14, "AB3C", null);
		Author author4 = new Author(4L, "MD4", 14, "AB4C", null);

		List<Book> books1 = new ArrayList<>();
		List<Book> books2 = new ArrayList<>();
		List<Book> books3 = new ArrayList<>();

		books1.add(new Book(1L, "EFG1", "T1", 88, "INTRO1"));
		books1.add(new Book(2L, "EFG2", "T2", 99, "INTRO2"));

		books2.add(new Book(3L, "EFG2", "T3", 89, "INTRO3"));
		books2.add(new Book(3L, "EFG2", "T3", 89, "INTRO3"));
		books2.add(new Book(4L, "EFG3", "T4", 39, "INTRO4"));

		books3.add(new Book(5L, "EFG4", "T5", 22, "INTRO5"));
		books3.add(new Book(6L, "EFG5", "T6", 19, "INTRO6"));
		books3.add(new Book(7L, "EFG6", "T7", 79, "INTRO7"));

		author1.setBooks(books1);
		author2.setBooks(books2);
		author3.setBooks(books3);
		author4.setBooks(books3);

		return new ArrayList<>(Arrays.asList(author1, author2, author3, author4));
	}
}
