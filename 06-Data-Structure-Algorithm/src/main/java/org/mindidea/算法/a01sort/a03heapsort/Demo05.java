package org.mindidea.算法.a01sort.a03heapsort;

import org.mindidea.算法.zcommon.Utils;

public class Demo05 {
	public static void main(String[] args) {
		Integer[] nums = Utils.generateArr(100, 10);
		sort(nums);
		Utils.printArr(nums);
	}

	private static void sort(Integer[] nums) {
		// 1. 批量建堆
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

	private static void shiftDown(Integer[] nums, int n, int i) {
		Integer rootNum = nums[i];
		while ((i << 1) + 1 < n) {
			int childIndex = (i << 1) + 1;
			int rightIndex = childIndex + 1;
			if (rightIndex < n && nums[rightIndex] > nums[childIndex]) {
				childIndex = rightIndex;
			}
			if (rootNum > nums[childIndex]) {
				break;
			}
			nums[i] = nums[childIndex];
			i = childIndex;
		}
		nums[i] = rootNum;
	}
}
