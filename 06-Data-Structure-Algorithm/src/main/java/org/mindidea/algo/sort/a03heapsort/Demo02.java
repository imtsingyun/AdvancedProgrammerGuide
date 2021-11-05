package org.mindidea.algo.sort.a03heapsort;

import org.mindidea.algo.sort.zcommon.Utils;

public class Demo02 {

	public static void main(String[] args) {
		Integer[] nums = Utils.generateArr(100, 12);
	}

	public static void buildHeap(Integer[] nums, int n) {
		// 获取最后一个有子元素的节点，即最后一个节点的父节点
		int lastNode = nums.length - 1;
		int lastNodeParent = (lastNode - 1) / 2;

		for (int i = lastNodeParent; i >= 0; i--) {
			heapify(nums, n, i);
		}
	}

	/**
	 * heapify 操作，比较第 i 个元素和它的两个子元素，找到最大的并和根元素交换
	 *
	 * @param nums 数组
	 * @param n    堆中第 n 个元素
	 * @param i    对第 i 个元素进行 heapify
	 */
	@SuppressWarnings("DuplicatedCode")
	public static void heapify(Integer[] nums, int n, int i) {
		// i 节点的左右两个子节点
		int c1 = i * 2 + 1;
		int c2 = i * 2 + 2;
		// 记录最大节点，默认是 i 节点
		int max = i;

		// c1、c2 如果大于 n，则表示 i 节点没有子节点
		if (c1 < n && nums[c1] > nums[max]) {
			max = c1;
		}
		if (c2 < n && nums[c2] > nums[max]) {
			max = c2;
		}

		// 如果最大值不是 父节点，则交换位置
		if (max != i) {
			Utils.swap(nums, i, max);
			// max 是被换下来的元素，需要继续 heapify
			heapify(nums, n, max);
		}
	}
}
