package org.mindidea.leetcode._01_88_MergeSortedArray;

/**
 * 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * time: 2021-11-03 第44周 00:00:33
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(nums1);
    }

    /**
     * nums1 和 nums2 中的数字都是有序的（从大到小），所以倒着比较，
     * 将两个数组中较大的元素放到最后
     *
     * @param nums1 数组 1
     * @param m     数组 1 中元素的个数
     * @param nums2 数组 2
     * @param n     数组 2 中元素的个数
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 指向 nums1 数组的最后一个元素
        int p0 = nums1.length - 1;
        // 指向 nums1 数组的最后一个非零元素
		int p1 = m - 1;
        // 指向 nums2 数组的最后一个元素
        int p2 = nums2.length - 1;

        while (p2 >= 0) {
            if (p1 >=0 && nums1[p1] > nums2[p2]) {
                nums1[p0--] = nums1[p1--];
            } else {
                nums1[p0--] = nums2[p2--];
            }
        }
    }
}
