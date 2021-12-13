package org.mindidea.gbfbcxj1.chap17;

public class ReadWriteLockImpl implements ReadWriteLock {

	private boolean preferWriter;

	public ReadWriteLockImpl() {
		this(true);
	}

	public ReadWriteLockImpl(boolean preferWriter) {
		this.preferWriter = preferWriter;
	}
	@Override
	public Lock writeLock() {
		return null;
	}

	@Override
	public Lock readLock() {
		return null;
	}

	@Override
	public int getWritingWriters() {
		return 0;
	}

	@Override
	public int getReadingReaders() {
		return 0;
	}
}
