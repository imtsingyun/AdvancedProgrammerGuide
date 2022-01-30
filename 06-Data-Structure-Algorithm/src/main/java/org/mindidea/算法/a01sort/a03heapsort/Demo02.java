package org.mindidea.算法.a01sort.a03heapsort;

public class Demo02 {

	public static void main(String[] args) {
		int[] tree = new int[]{88, 44, 53, 41, 16, 6, 70, 18, 85, 98, 81, 23, 35, 43, 37};
		new Demo02().sort(tree);
		for (int j : tree) {
			System.out.println(j);
		}
	}

	public void sort(int[] nums) {
		int heapSize = nums.length;
		this.buildHeap(nums, heapSize);
		while (heapSize > 1) {
			swap(nums, 0, --heapSize);
			heapify(nums, heapSize, 0);
		}
	}

	public void buildHeap(int[] tree, int n) {
		// 从倒数第二行开始做 heapify
		// 即最后一个元素的父节点
		int lastNode = n - 1;
		int parent = (lastNode - 1) >> 1;
		for (int i = parent; i >= 0; i--) {
			heapify(tree, n, i);
		}
	}

	/**
	 * heapify 操作
	 *
	 * @param tree 使用数组表示堆
	 * @param n    节点数
	 * @param i    对第 i 个节点进行 heapify 操作
	 */
	public void heapify(int[] tree, int n, int i) {
		if (i >= n) {
			return;
		}
		int c1 = (i << 1) + 1;    // 左子节点
		int c2 = (i << 1) + 2;    // 右子节点

		// 从第 i、c1、c2 三个节点中找到最大值
		int max = i;
		if (c1 < n && tree[c1] > tree[max]) {
			max = c1;
		}
		if (c2 < n && tree[c2] > tree[max]) {
			max = c2;
		}
		if (max != i) {
			swap(tree, max, i);
			heapify(tree, n, max);
		}
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}