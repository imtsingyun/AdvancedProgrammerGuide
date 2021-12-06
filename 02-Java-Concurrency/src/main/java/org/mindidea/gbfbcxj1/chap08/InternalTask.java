package org.mindidea.gbfbcxj1.chap08;

public class InternalTask implements Runnable {

	private final RunnableQueue runnableQueue;
	private volatile boolean running = true;

	public InternalTask(RunnableQueue runnableQueue) {
		this.runnableQueue = runnableQueue;
	}

	@Override
	public void run() {
		// 如果当前线程为 running 并且没有被中断，则将不断地从队列中获取 runnable 任务，然后执行 run 方法
		while (running && !Thread.currentThread().isInterrupted()) {
			try {
				Runnable task = runnableQueue.take();
				task.run();
			} catch (Exception e) {
				running = false;
				break;
			}
		}
	}

	public void stop() {
		this.running = false;
	}
}
