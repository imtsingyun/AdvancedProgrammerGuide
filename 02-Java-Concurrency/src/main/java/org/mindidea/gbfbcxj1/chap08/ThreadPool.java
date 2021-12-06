package org.mindidea.gbfbcxj1.chap08;

/**
 * 自定义线程池
 *
 * @author tsingyun
 * @version V1.0
 * @time 2021/12/6 21:56
 */
public interface ThreadPool {

	// 提交任务到线程池
	void execute(Runnable runnable);

	// 关闭线程池
	void shutdown();

	// 获取线程池的初始化大小
	int getInitSize();

	int getMaxSize();

	int getCoreSize();

	int getQueueSize();

	int getActiveCount();

	boolean isShutdown();
}
