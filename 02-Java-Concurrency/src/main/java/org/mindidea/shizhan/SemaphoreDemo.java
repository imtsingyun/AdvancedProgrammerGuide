package org.mindidea.shizhan;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo implements Runnable {
	final Semaphore semaphore = new Semaphore(5);


	@Override
	public void run() {
		try {
			semaphore.acquire();
			TimeUnit.SECONDS.sleep(2);
			System.out.println(Thread.currentThread().getName() + ": done.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(20);
		SemaphoreDemo demo = new SemaphoreDemo();
		for (int i = 0; i < 20; i++) {
			executorService.submit(demo);
		}
	}
}
