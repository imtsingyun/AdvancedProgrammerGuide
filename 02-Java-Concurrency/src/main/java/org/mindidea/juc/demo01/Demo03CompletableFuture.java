package org.mindidea.juc.demo01;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Demo03CompletableFuture {
	public static void main(String[] args) throws InterruptedException {
		test1();
	}

	private static void test1() throws InterruptedException {
		IntStream.range(0, 10).boxed().forEach(i -> CompletableFuture.supplyAsync(Demo03CompletableFuture::get)
				.thenAccept(Demo03CompletableFuture::display)
				.whenComplete((v, t) -> System.out.println(i + " is done")));

		Thread.currentThread().join();
	}

	private static void display(int data) {
		int value = ThreadLocalRandom.current().nextInt(20);
		try {
			System.out.println(Thread.currentThread().getName() + " display will be sleep " + value);
			TimeUnit.SECONDS.sleep(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " display execute done " + data);
	}

	private static int get() {
		int value = ThreadLocalRandom.current().nextInt(20);
		try {
			System.out.println(Thread.currentThread().getName() + " get will be sleep " + value);
			TimeUnit.SECONDS.sleep(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " get execute done " + value);
		return value;
	}
}
