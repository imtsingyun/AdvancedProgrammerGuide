package org.mindidea.algo.sort.a02selection;

import org.mindidea.algo.sort.zcommon.Utils;

/**
 * 选择排序
 * 1. 选择数组中最大的元素和最后一个元素交换位置
 */
public class Demo01 {
	public static void main(String[] args) {
		Integer[] arr = Utils.generateArr(10, 20);
		Utils.printArr(arr);
		sort1(arr);
		Utils.printArr(arr);
	}

	@SuppressWarnings("DuplicatedCode")
	public static void sort2(Integer[] arr) {
		for (int end = arr.length - 1; end > 0; end--) {
			int maxValueIndex = 0;
			for (int begin = 1; begin <= end; begin++) {
				// >= 保证稳定性
				if (arr[begin] >= arr[maxValueIndex]) {
					maxValueIndex = begin;
				}
			}
			int tmp = arr[maxValueIndex];
			arr[maxValueIndex] = arr[end];
			arr[end] = tmp;
		}
	}

	@SuppressWarnings("DuplicatedCode")
	public static void sort1(Integer[] arr) {
		for (int end = arr.length - 1; end > 0; end--) {
			int maxValueIndex = 0;
			for (int begin = 1; begin <= end; begin++) {
				if (arr[begin] >= arr[maxValueIndex]) {
					maxValueIndex = begin;
				}
			}
			int tmp = arr[maxValueIndex];
			arr[maxValueIndex] = arr[end];
			arr[end] = tmp;
		}
	}
	
	public static void sort3(Integer[] nums) {
		for (int end = nums.length - 1; end > 0; end--) {
			int maxValueIndex = 0;
			for (int begin = 1; begin <= nums.length - 1; begin++) {
				if (nums[begin] >= nums[maxValueIndex]) {
					maxValueIndex = begin;
				}
			}
			int tmp = nums[maxValueIndex];
			nums[maxValueIndex] = nums[end];
			nums[end] = tmp;
		}
	}
}
