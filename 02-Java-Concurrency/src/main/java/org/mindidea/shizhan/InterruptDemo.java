package org.mindidea.shizhan;

import java.util.concurrent.TimeUnit;

public class InterruptDemo {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			while (true) {
				Thread.yield();
				if (Thread.currentThread().isInterrupted()) {
					System.out.println("cur thread is interrupted");
					break;
				}
			}
		});
		t1.start();
		try {
		    TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		t1.interrupt();
	}
}
