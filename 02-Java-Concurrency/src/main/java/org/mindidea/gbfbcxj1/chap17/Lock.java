package org.mindidea.gbfbcxj1.chap17;

public interface Lock {

	/**
	 * 获取显示锁，没有获取到锁的线程会被阻塞
	 *
	 * @throws InterruptedException 中断
	 */
	void lock() throws InterruptedException;

	void unlock();
}
