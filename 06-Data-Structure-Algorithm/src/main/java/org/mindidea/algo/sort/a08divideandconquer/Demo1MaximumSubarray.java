package org.mindidea.algo.sort.a08divideandconquer;

/**
 * 最大连续子序列和
 *
 */
public class Demo1MaximumSubarray {
	public static void main(String[] args) {
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(new Demo1MaximumSubarray().solution1(nums));
	}

	private int solution1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		for (int begin = 0; begin < nums.length; begin++) {
			for (int end = begin; end < nums.length; end++) {
				int sum = 0;
				for (int i = begin; i <= end; i++) {
					sum += nums[i];
				}
				max = Math.max(max, sum);
			}
		}
		return max;
	}
}
