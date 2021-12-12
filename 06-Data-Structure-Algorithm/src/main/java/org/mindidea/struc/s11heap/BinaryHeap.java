package org.mindidea.struc.s11heap;

import javax.sound.midi.InvalidMidiDataException;
import java.util.Comparator;

/**
 * 二叉堆
 *
 * @author tsingyun
 * @version V1.0
 * @time 2021/12/12 0:49
 */
public class BinaryHeap<E> implements Heap<E> {

	private E[] elements;
	private int size;
	private Comparator<E> comparator;
	private static final int DEFAULT_CAPACITY = 10;

	public BinaryHeap(Comparator<E> comparator) {
		this.comparator = comparator;
		//noinspection unchecked
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public BinaryHeap() {
		this(null);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	@Override
	public void add(E element) {
		checkNull(element);
		ensureCapacity(size + 1);
		// 在数组的最后插入元素
		elements[size++] = element;
		// 对最后一个元素进行上滤操作
		shiftUp(size - 1);
	}

	/**
	 * index 位置的元素上滤
	 *
	 * @param index 需要上滤的元素
	 */
	private void shiftUp(int index) {
		E e = elements[index];
		// index > 0 表示存在父节点，因为根节点的索引是 0
		while (index > 0) {
			// 找到父节点，进行比较
			int parentIndex = (index - 1) >> 1;
			E parent = elements[parentIndex];
			if (compare(e, parent) <= 0) {
				break;
			}
			// 将父节点的元素存入到 index 位置
			elements[index] = parent;
			// index 指向父节点的位置
			index = parentIndex;
		}
		elements[index] = e;
	}

	@Override
	public E get() {
		emptyCheck();
		return elements[0];
	}

	public E get(int i) {
		emptyCheck();
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
		return elements[i];
	}
	@Override
	public E remove() {
		emptyCheck();
		return null;
	}

	@Override
	public E replace(E element) {
		return null;
	}

	@SuppressWarnings("unchecked")
	private int compare(E e1, E e2) {
		return comparator != null ? comparator.compare(e1, e2) : ((Comparable<E>) e1).compareTo(e2);
	}

	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return;

		// 扩容 1.5 倍
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		@SuppressWarnings("unchecked")
		E[] newElements = (E[]) new Object[newCapacity];
		if (size >= 0) System.arraycopy(elements, 0, newElements, 0, size);
		elements = newElements;
	}

	private void emptyCheck() {
		if (size == 0) {
			throw new IndexOutOfBoundsException("BinaryHeap is empty");
		}
	}

	private void checkNull(E e) {
		if (e == null) {
			throw new IllegalArgumentException("element must not be null");
		}
	}
}
