package org.mindidea.juc.demo01;

import java.util.concurrent.*;

public class Demo02CompletableFuture {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		m2();
		System.out.println("main thread is over...");

		// 主线程不要马上结束，否则 CompletableFuture 默认使用的线程池会立刻关闭
//		try {
//			TimeUnit.SECONDS.sleep(5);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	private static void m2() throws ExecutionException, InterruptedException {
		ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 20, 1L,
				TimeUnit.SECONDS,
				new LinkedBlockingDeque<>(50),
				Executors.defaultThreadFactory(),
				new ThreadPoolExecutor.AbortPolicy());

		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return 1;
		}, pool).thenApply(f -> f + 2).thenApply(f -> {
			return f + 3;
		}).whenComplete((v, e) -> {
			if (e == null) {
				System.out.println("--- result is " + v);
			}
		}).exceptionally(e -> {
			e.printStackTrace();
			return null;
		});
	}

	private static void m1() throws ExecutionException, InterruptedException {
		CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
			System.out.println(Thread.currentThread().getName() + "\t" + "--- come in");
		});
		System.out.println(future1.get());
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////

		ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 20, 1L,
				TimeUnit.SECONDS,
				new LinkedBlockingDeque<>(50),
				Executors.defaultThreadFactory(),
				new ThreadPoolExecutor.AbortPolicy());

		CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
			System.out.println(Thread.currentThread().getName() + "\t" + "--- come in");
		}, pool);
		System.out.println(future2.get());
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
			System.out.println(Thread.currentThread().getName() + "\t" + "--- come in");
			return 11;
		});
		System.out.println(future3.get());

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		CompletableFuture<Integer> future4 = CompletableFuture.supplyAsync(() -> {
			System.out.println(Thread.currentThread().getName() + "\t" + "--- come in");
			return 22;
		}, pool);
		System.out.println(future4.get());

		pool.shutdown();
	}
}
