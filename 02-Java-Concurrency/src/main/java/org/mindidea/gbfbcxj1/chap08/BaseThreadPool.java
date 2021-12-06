package org.mindidea.gbfbcxj1.chap08;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class BaseThreadPool extends Thread implements ThreadPool {

	private final int initSize;
	private final int maxSize;
	private final int coreSize;
	private int activeCount;
	private final ThreadFactory threadFactory;
	private final RunnableQueue runnableQueue;
	private volatile boolean isShutdown = false;
	private final Queue<ThreadTask> threadTaskQueue = new ArrayDeque<>();

	private final static DenyPolicy DEFAULT_DENY_POLICY = new DenyPolicy.DiscardDenyPolicy();
	private final static ThreadFactory DEFAULT_THREAD_FACTORY = new DefaultThreadFactory();

	private final long keepAliveTime;
	private final TimeUnit timeUnit;

	public BaseThreadPool(int initSize, int maxSize, int coreSize, int queueSize) {
		this(initSize, maxSize, coreSize, DEFAULT_THREAD_FACTORY, queueSize,
				DEFAULT_DENY_POLICY, 10, TimeUnit.SECONDS);
	}

	public BaseThreadPool(int initSize, int maxSize, int coreSize, ThreadFactory threadFactory, int queueSize,
						  DenyPolicy denyPolicy, long keepAliveTime, TimeUnit timeUnit) {
		this.initSize = initSize;
		this.maxSize = maxSize;
		this.coreSize = coreSize;
		this.threadFactory = threadFactory;
		this.runnableQueue = new LinkedRunnableQueue(queueSize, denyPolicy, this);
		this.keepAliveTime = keepAliveTime;
		this.timeUnit = timeUnit;
		this.init();
	}

	private void init() {
		start();
		for (int i = 0; i < initSize; i++) {
			newThread();
		}
	}

	private void newThread() {
		InternalTask internalTask = new InternalTask(runnableQueue);
		Thread thread = this.threadFactory.createThread(internalTask);
		ThreadTask threadTask = new ThreadTask(thread, internalTask);
		threadTaskQueue.offer(threadTask);
		this.activeCount++;
		thread.start();
	}

	private void removeThread() {
		ThreadTask task = threadTaskQueue.remove();
		task.internalTask.stop();
		this.activeCount--;
	}

	@Override
	public void execute(Runnable runnable) {
		if (this.isShutdown)
			throw new IllegalStateException("The thread pool is destoy");

		this.runnableQueue.offer(runnable);
	}

	@Override
	public void shutdown() {

	}

	@Override
	public int getInitSize() {
		return 0;
	}

	@Override
	public int getMaxSize() {
		return 0;
	}

	@Override
	public int getCoreSize() {
		return 0;
	}

	@Override
	public int getQueueSize() {
		return 0;
	}

	@Override
	public int getActiveCount() {
		return 0;
	}

	@Override
	public boolean isShutdown() {
		return false;
	}

	private static class ThreadTask {
		Thread thread;
		InternalTask internalTask;

		public ThreadTask(Thread thread, InternalTask internalTask) {
			this.thread = thread;
			this.internalTask = internalTask;
		}
	}

	private static class DefaultThreadFactory implements ThreadFactory {
		private static final AtomicInteger GROUP_COUNTER = new AtomicInteger(1);
		private static final ThreadGroup group = new ThreadGroup("MyTheadPool-" + GROUP_COUNTER.getAndDecrement());
		private static final AtomicInteger COUNTER = new AtomicInteger(0);

		@Override
		public Thread createThread(Runnable runnable) {
			return new Thread(group, runnable, "thread-pool-" + COUNTER.getAndDecrement());
		}
	}
}
