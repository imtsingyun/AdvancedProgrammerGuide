package org.mindidea.algo.a01sort.a03heapsort;

public class Demo01 {

	private static int heapSize;
	public static void main(String[] args) {
		int[] nums = new int[]{83, 58, 54, 8, 64, 32, 89, 72};
		sort(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

	private static void sort(int[] nums) {
		heapSize = nums.length;
		heapify(nums);
		while (heapSize > 1) {
			int temp = nums[0];
			--heapSize;
			nums[0] = nums[heapSize];
			nums[heapSize] = temp;
			shiftDown(nums, heapSize, 0);
		}
	}

	/**
	 * 对第 i 个节点进行 heapify 操作
	 *
	 * @param tree 使用数据表示堆数据
	 */
	private static void heapify(int[] tree) {
		int lastIndex = (tree.length - 1 - 1) >> 1;
		for (int j = lastIndex; j >=0 ; j--) {
			shiftDown(tree, tree.length, j);
		}
	}

	/**
	 * 下滤
	 *
	 * @param tree 堆数据
	 * @param i    需要下滤的数据索引
	 */
	private static void shiftDown(int[] tree, int n, int i) {
		int target = tree[i];
		// i 的左子节点
		while ((i << 1) + 1 < n) {
			// 1 可能只有一个左节点
			// 2 可能只左右两个子节点
			int childIndex = (i << 1) + 1;
			int child = tree[childIndex];

			// 右子节点
			int rightIndex = childIndex + 1;
			if (rightIndex < n && tree[rightIndex] > child) {
				childIndex = rightIndex;
			}

			if (target > tree[childIndex]) {
				break;
			}
			tree[i] = tree[childIndex];
			i = childIndex;
		}
		tree[i] = target;
	}
}
