package org.mindidea.gbfbcxj1.chap08;

import java.util.LinkedList;

public class LinkedRunnableQueue implements RunnableQueue {
	// 任务队列的最大容量
	private final int limit;

	// 拒绝策略
	private final DenyPolicy denyPolicy;

	// 任务队列
	private final LinkedList<Runnable> runnableLinkedList = new LinkedList<>();

	private final ThreadPool threadPool;

	public LinkedRunnableQueue(int limit, DenyPolicy denyPolicy, ThreadPool threadPool) {
		this.limit = limit;
		this.denyPolicy = denyPolicy;
		this.threadPool = threadPool;
	}

	// 向线程池中提交任务
	@Override
	public void offer(Runnable runnable) {
		synchronized (runnableLinkedList) {
			// 无法容纳新的任务时执行拒绝策略
			if (runnableLinkedList.size() >= limit) {
				denyPolicy.reject(runnable, threadPool);
			} else {
				// 将任务加入队列尾部，并且唤醒阻塞中的线程
				runnableLinkedList.addLast(runnable);
				runnableLinkedList.notifyAll();
			}
		}
	}

	// 线程从任务队列中获取可执行的任务
	@Override
	public Runnable take() throws InterruptedException {
		synchronized (runnableLinkedList) {
			while (runnableLinkedList.isEmpty()) {
				try {
					// 任务队列为空，则将当前线程挂起，进入 waitset 中等待唤醒（新的线程加入）
					runnableLinkedList.wait();
				} catch (InterruptedException e) {
					throw e;
				}
			}
		}
		return runnableLinkedList.removeFirst();
	}

	@Override
	public int size() {
		synchronized (runnableLinkedList) {
			return runnableLinkedList.size();
		}
	}
}
