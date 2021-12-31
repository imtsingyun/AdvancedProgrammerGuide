package org.mindidea.algo.a01sort.a03heapsort;

import org.mindidea.algo.zcommon.Utils;

public class Demo08 {
	public static void main(String[] args) {
		Integer[] nums = Utils.generateArr(100, 10);
		sort(nums);
		Utils.printArr(nums);
		System.out.println(Utils.isPositiveOrder(nums));
	}

	private static void sort(Integer[] nums) {
		heapify(nums);
		int heapSize = nums.length;
		while (heapSize > 1) {
			--heapSize;
			Utils.swap(nums, 0, heapSize);
			shiftDown(nums, heapSize, 0);
		}
	}

	private static void heapify(Integer[] nums) {
		int lastIndex = nums.length - 1;
		int lastParentIndex = (lastIndex - 1) >> 1;
		for (int i = lastParentIndex; i >= 0; i--) {
			shiftDown(nums, nums.length, i);
		}
	}

	/**
	 * 下虑
	 *
	 * @param nums 数组
	 * @param n    元素个数
	 * @param i    从第 i 个元素进行下滤
	 */
	private static void shiftDown(Integer[] nums, int n, int i) {
		int root = nums[i];
		// (i << 1) + 1 是第 i 个元素的左子节点
		while ((i << 1) + 1 < n) {
			int childIndex = (i << 1) + 1;
			int rightIndex = childIndex + 1;
			if (rightIndex < n && nums[rightIndex] > nums[childIndex]) {
				childIndex = rightIndex;
			}

			if (root > nums[childIndex]) {
				break;
			}

			nums[i] = nums[childIndex];
			i = childIndex;
		}
		nums[i] = root;
	}
}
