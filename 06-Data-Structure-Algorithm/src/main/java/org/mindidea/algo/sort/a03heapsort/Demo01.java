package org.mindidea.algo.sort.a03heapsort;

import org.mindidea.algo.sort.zcommon.Utils;

public class Demo01 {
	public static void main(String[] args) {
		Utils.generateArr(10, 50);

	}

	public static void buildHeap(Integer[] arr) {
		// 最后一个节点的父节点就是最后一个非叶子节点
		int lastEle = arr.length - 1;
		int index = (lastEle - 1) / 2;

		while (index != 0) {

		}
	}

	// 将 index 位置的元素
	public static void heapify(Integer[] arr, int n, int index) {
		if (index >= n) {
			return;
		}测试
		// 找出 index 节点以及其子节点中最大的节点
		// index 节点的 左子节浿点
		int c1 = 2*index + 1;
		// index 节点的 右子节点
		int c2 = 2*index + 2;
		int max = index;

		if (c1 < n && arr[c1] > arr[max]) {
			max = c1;
		}
		if (c2 < n && arr[c2] > arr[max]) {
			max = c2;
		}

		// 最大值不是父节点，则交换
		if (max != index) {
			swap(arr, max, index);
			heapify(arr, n, max);
		}
	}

	public static void swap(Integer[] arr, int n, int index) {

	}

	public static void sort(Integer[] arr) {

	}
}
