package org.mindidea.gbfbcxj1.chap08;

/**
 * 任务队列，主要用于缓存提交到线程池中的任务
 *
 * @author tsingyun
 * @version V1.0
 * @time 2021/12/6 21:59
 */
public interface RunnableQueue {

	// 当有新的任务进来时首先会 offer 到队列中
	void offer(Runnable runnable);

	// 工作线程通过 take 方法获取 Runnable
	Runnable take() throws InterruptedException;

	// 获取任务队列中任务的数量
	int size();
}
