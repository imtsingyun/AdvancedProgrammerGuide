package org.mindidea.juc.demo01;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Demo01FutureTask {
	public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
		FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> {
			System.out.println(Thread.currentThread().getId() + "\t" + "--- come in");
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return 1024;
		});

		new Thread(futureTask, "t1").start();

		System.out.println("main is continue");
		// futureTask.get() 方法会阻塞当前线程
//		System.out.println(futureTask.get());
		// 添加超时时间
//		System.out.println(futureTask.get(2, TimeUnit.SECONDS));

		// 不要用阻塞，尽量使用轮询
		while (true) {
			if (futureTask.isDone()) {
				System.out.println("--- result is " + futureTask.get());
				break;
			} else {
				System.out.println("is running....");
			}
		}


	}
}
