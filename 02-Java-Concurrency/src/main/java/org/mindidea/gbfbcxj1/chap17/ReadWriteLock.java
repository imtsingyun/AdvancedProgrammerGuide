package org.mindidea.gbfbcxj1.chap17;

public interface ReadWriteLock {

	// 创建写锁
	Lock writeLock();

	// 创建读锁
	Lock readLock();

	// 获取当前有多少线程正在执行写操作
	int getWritingWriters();

	// 当前有多少线程正在等待获取读锁
	int getReadingReaders();

	static ReadWriteLock readWriteLock() {
		return new ReadWriteLockImpl();
	}

	static ReadWriteLock readWriteLock(Boolean preferWriter) {
		return new ReadWriteLockImpl(preferWriter);
	}
}
