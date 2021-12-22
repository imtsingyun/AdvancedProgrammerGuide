package org.mindidea.algo.a01sort.a03heapsort;

public class Demo03 {

	public static void main(String[] args) {
//		int[] nums = new int[]{83, 58, 54, 8, 64, 32, 89, 72};
		int[] nums = new int[]{88, 44, 53, 41, 16, 6, 70, 18, 85, 98, 81, 23, 35, 43, 37};
		new Demo03().sort(nums);
		for (int j : nums) {
			System.out.println(j);
		}
	}

	private void sort(int[] nums) {
		int heapSize = nums.length;
		heapify(nums);
		while (heapSize > 1) {
			int max = nums[0];
			--heapSize;
			nums[0] = nums[heapSize];
			nums[heapSize] = max;
			shiftDown(nums, heapSize, 0);
		}
	}

	private void heapify(int[] nums) {
		int lastParentIndex = (nums.length - 1 - 1) >> 1;
		for (int i = lastParentIndex; i >= 0; i--) {
			shiftDown(nums, nums.length, i);
		}
	}

	private void shiftDown(int[] nums, int n, int i) {
		// 对第 i 个节点下滤
		int rootNode = nums[i];
		// 如果第 i 个元素没有左子节点（i * 2 + 1），则遍历结束
		while ((i << 1) + 1 < n) {
			// 默认先取左子节点（因为有子节点）
			int childIndex = (i << 1) + 1;
			int childNode = nums[childIndex];

			int rightIndex = childIndex + 1;
			// rightNode < n 表明存在右节点，rightNode > childNode 表明右节点大于左节点
			if (rightIndex < n && nums[rightIndex] > childNode) {
				childIndex = rightIndex;
			}
			// 根节点最大，不需操作
			if (rootNode > nums[childIndex]) {
				break;
			}
			nums[i] = nums[childIndex];
			i = childIndex;
		}
		nums[i] = rootNode;
	}
}
