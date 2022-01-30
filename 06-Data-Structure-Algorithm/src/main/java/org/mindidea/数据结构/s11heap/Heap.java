package org.mindidea.数据结构.s11heap;

public interface Heap<E> {

	/**
	 * @return 元素数量
	 */
	int size();

	/**
	 * @return 判断是否为空
	 */
	boolean isEmpty();

	/**
	 * 清空
	 */
	void clear();

	/**
	 * @param element 添加元素
	 */
	void add(E element);

	/**
	 * @return 堆顶元素
	 */
	E get();

	/**
	 * 删除堆顶元素
	 *
	 * @return 被删除的元素
	 */
	E remove();

	/**
	 * 删除堆顶元素的同时插入一个新元素
	 *
	 * @param element 新元素
	 * @return 被删除的元素
	 */
	E replace(E element);
}
