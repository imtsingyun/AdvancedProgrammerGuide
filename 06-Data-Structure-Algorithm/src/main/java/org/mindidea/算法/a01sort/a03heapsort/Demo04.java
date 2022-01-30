package org.mindidea.算法.a01sort.a03heapsort;

import org.mindidea.算法.zcommon.Utils;

public class Demo04 {
	public static void main(String[] args) {
		Integer[] nums = Utils.generateArr(100, 15);
		sort(nums);
		Utils.printArr(nums);
	}

	private static void sort(Integer[] nums) {
		// 1. 先进行批量建堆
		heapify(nums);
		// 2. 取出堆中的最大元素（即第一个元素）和最后一个元素交换
		// 3. 然后再对前面的元素进行建堆操作（每次将堆的大小减1，保留后面元素的顺序）
		int heapSize = nums.length;    // 堆的初始大小
		while (heapSize > 1) {
			--heapSize;
			// 第一个元素和第 heapSize 个元素交换
			Utils.swap(nums, 0, heapSize);
			shiftDown(nums, heapSize, 0);
		}
	}

	// 从最后一个有子节点的元素（即最后一个节点的父节点）开始倒序遍历
	// 对每个元素进行 shiftDown 操作
	private static void heapify(Integer[] nums) {
		int lastIndex = nums.length - 1;            // 最后一个元素索引
		int lastParentIndex = (lastIndex - 1) >> 1;    // 最后一个元素的父节点索引
		for (int i = lastParentIndex; i >= 0; i--) {
			shiftDown(nums, nums.length, i);
		}
	}

	/**
	 * 下滤操作
	 *
	 * @param nums 操作的数据
	 * @param n    数组的长度
	 * @param i    对哪个元素进行下滤
	 */
	private static void shiftDown(Integer[] nums, int n, int i) {
		int num = nums[i];
		// 第 i 个元素有左子节点
		while ((i << 1) + 1 < n) {
			// 左子节点
			int childIndex = (i << 1) + 1;
			// 右子节点（不一定有）
			int rightIndex = childIndex + 1;
			// 如果有右子节点，且右大于左子节点
			if (rightIndex < n && nums[rightIndex] > nums[childIndex]) {
				childIndex = rightIndex;
			}
			// 父节点最大
			if (num > nums[childIndex]) {
				break;
			}
			nums[i] = nums[childIndex];
			i = childIndex;
		}
		nums[i] = num;
	}
}
