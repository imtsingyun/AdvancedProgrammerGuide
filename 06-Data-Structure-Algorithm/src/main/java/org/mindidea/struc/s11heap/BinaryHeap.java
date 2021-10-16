package org.mindidea.struc.s11heap;

import java.util.Comparator;

public class BinaryHeap<E> extends AbstractHeap<E> implements Heap<E> {

    private E[] elements;

    private static final int DEFAULT_CAPACITY = 16;

    public BinaryHeap(Comparator<E> comparator) {
        super(comparator);
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
        elementNotNullCheck(element);
        ensureCapacity(size + 1);
        elements[size++] = element;
        siftUp(size - 1);
    }

    @Override
    public E get() {
        emptyCheck();
        return elements[0];
    }

    /**
     * 删除顶部元素
     *
     * @return 被删除的元素
     */
    @Override
    public E remove() {
        emptyCheck();

        E root = elements[0];
        elements[0] = elements[size - 1];
        elements[size - 1] = null;
        size--;

        return root;
    }

    @Override
    public E replace(E element) {
        emptyCheck();
        return null;
    }

    public void printE() {
        for (E e : elements) {
            if (e != null) {
                System.out.print(e + ", ");
            }
        }
        System.out.println();
    }

    private void siftDown(int index) {

    }
    /**
     * 让 index 位置的元素上滤
     *
     * @param index 需要上滤的元素下标
     */
    private void siftUp(int index) {
        E e = elements[index];
        while (index > 0) {
            // 父节点的索引
            int pIndex = (index - 1) >> 1;
            E p = elements[pIndex];
            // 大于父节点的值
            if (compare(e, p) < 0) {
                break;
            }
            elements[index] = p;
            index = pIndex;
        }
        elements[index] = e;
    }


    private void emptyCheck() {
        if (size == 0) {
            throw new IllegalArgumentException("the heap is empty");
        }
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    /**
     * 扩容
     *
     * @param capacity 扩大的容量
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        // 扩容 1.5 倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        if (size >= 0) System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }
}
