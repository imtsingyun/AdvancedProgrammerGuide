package org.mindidea.gbfbcxj1.chap08;

/**
 * 拒绝策略
 *
 * @author tsingyun
 * @version V1.0
 * @time 2021/12/6 22:23
 */
@FunctionalInterface
public interface DenyPolicy {

	void reject(Runnable runnable, ThreadPool threadPool);

	/**
	 * 直接丢弃任务
	 */
	class DiscardDenyPolicy implements DenyPolicy {
		@Override
		public void reject(Runnable runnable, ThreadPool threadPool) {
			// do nothing
		}
	}

	// 向任务提交者抛出异常
	class AbortDenyPolicy implements DenyPolicy {
		@Override
		public void reject(Runnable runnable, ThreadPool threadPool) {
			throw new RunnableDenyException("The runnable " + runnable + " will be abort.");
		}
	}

	// 使任务在提交者所在的线程中执行
	class RunnerDenyPolicy implements DenyPolicy {
		@Override
		public void reject(Runnable runnable, ThreadPool threadPool) {
			if (!threadPool.isShutdown()) {
				runnable.run();
			}
		}
	}
}
