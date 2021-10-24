package org.mindidea.algo.sort.a03heapsort;

import org.mindidea.algo.sort.zcommon.Utils;

public class Demo01 {
    public static void main(String[] args) {
//        Integer[] nums = Utils.generateArr(100, 8);
        Integer[] nums = new Integer[]{83, 58, 54, 8, 64, 32, 89, 72};
        buildHeap(nums, nums.length);
        Utils.printArr(nums);
        sort(nums, nums.length);
        Utils.printArr(nums);
    }

    public static void buildHeap(Integer[] arr, int n) {
        // 最后一个节点的父节点就是最后一个非叶子节点
        int lastEle = arr.length - 1;
        int parent = (lastEle - 1) / 2;

        for (int i = parent; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    /**
     * heapify
     *
     * @param arr 操作的数组
     * @param n   堆中元素的个数
     * @param i   对第 i 个元素进行 heapify 操作
     */
    @SuppressWarnings("DuplicatedCode")
    public static void heapify(Integer[] arr, int n, int i) {
        if (i >= n) {
            return;
        }
        // 找出 i 节点以及其子节点中最大的节点
        // i 节点的 左子节浿点
        int c1 = 2 * i + 1;
        // i 节点的 右子节点
        int c2 = 2 * i + 2;
        int max = i;
        // 从 i、c1、c2 中找到最大的元素
        if (c1 < n && arr[c1] > arr[max]) {
            max = c1;
        }
        if (c2 < n && arr[c2] > arr[max]) {
            max = c2;
        }

        // 最大值不是父节点，则交换
        if (max != i) {
            Utils.swap(arr, max, i);
            // 交换完成后，继续交换
            heapify(arr, n, max);
        }
    }

    public static void sort(Integer[] arr, int n) {
        buildHeap(arr, n);
        for (int j = n - 1; j >= 0; j--) {
            Utils.swap(arr, j, 0);
            heapify(arr, j, 0);
        }
    }
}
