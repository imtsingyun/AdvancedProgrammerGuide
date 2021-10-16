package org.mindidea.struc.s11heap;

public interface Heap<E> {
	// 获取大小
	int size();
	// 判断是否为空
	boolean isEmpty();
	// 清空堆
	void clear();
	// 添加元素
	void add(E element);
	// 获取顶部元素
	E get();
	// 删除堆顶元素
	E remove();
	// 删除堆顶元素后插入新元素
	E replace(E element);
}