package org.mindidea.algo.a01sort.a03heapsort;

import org.mindidea.algo.zcommon.Utils;

public class Demo09 {
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

	private static void shiftDown(Integer[] nums, int n, int i) {
		int root = nums[i];
		while ((i << 1) + 1 < n) {
			int childIdx = (i << 1) + 1;
			int rightIdx = childIdx + 1;
			if (rightIdx < n && nums[rightIdx] > nums[childIdx]) {
				childIdx = rightIdx;
			}
			if (root > nums[childIdx]) {
				break;
			}
			nums[i] = nums[childIdx];
			i = childIdx;
		}
		nums[i] = root;
	}
}
