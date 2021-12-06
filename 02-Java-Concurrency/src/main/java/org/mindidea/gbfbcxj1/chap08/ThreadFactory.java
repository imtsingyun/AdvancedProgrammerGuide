package org.mindidea.gbfbcxj1.chap08;

/**
 * 创建线程的工厂
 *
 * @author tsingyun
 * @version V1.0
 * @time 2021/12/6 22:01
 */
@FunctionalInterface
public interface ThreadFactory {
	Thread createThread(Runnable runnable);
}
