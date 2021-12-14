package org.mindidea.shizhan;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class IntLock implements Runnable {

	public ReentrantLock lock1 = new ReentrantLock();
	public ReentrantLock lock2 = new ReentrantLock();

	int lock;

	public IntLock(int lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		try {
			if (lock == 1) {
				lock1.lockInterruptibly();
				try {
					TimeUnit.SECONDS.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lock2.lockInterruptibly();
			} else {
				lock2.lockInterruptibly();
				try {
					TimeUnit.SECONDS.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lock1.lockInterruptibly();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (lock1.isHeldByCurrentThread()) {
				lock1.unlock();
			}
			if (lock2.isHeldByCurrentThread()) {
				lock2.unlock();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		IntLock intLock1 = new IntLock(1);
		IntLock intLock2 = new IntLock(2);
		Thread t1 = new Thread(intLock1);
		Thread t2 = new Thread(intLock2);

		t1.start();
		t2.start();

		TimeUnit.SECONDS.sleep(100);
	}
}
