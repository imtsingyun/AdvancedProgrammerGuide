package org.mindidea.algo.a01sort.a04insertionsort;

import org.mindidea.algo.zcommon.Utils;

public class Demo09BinarySearch {
	public static void main(String[] args) {
		Integer[] nums = Utils.generateArr(100, 10);
		sort(nums);
		Utils.printArr(nums);
		System.out.println(Utils.isPositiveOrder(nums));
	}

	private static void sort(Integer[] nums) {
		// 将数组看成有序部分和无序部分，一开始有序部分就是第一个元素，剩下的则为无序部分
		// 插入排序：默认将第一个元素看成有序的，所以从第二个开始排
		for (int begin = 1; begin < nums.length; begin++) {
			// 从无序部分的第一个元素开始排序
			int curVal = nums[begin];
			// 使用二分查找法，查询可以插入的位置
			int left = 0;
			int right = begin;
			while (left < right) {
				int mid = ((right - left) >> 1) + left;
				if (nums[begin] >= nums[mid]) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			for (int i = begin; i > left ; i--) {
				nums[i] = nums[i - 1];
			}
			nums[left] = curVal;
		}
	}
}