package org.mindidea.算法.a01sort.a01bubble;

import org.mindidea.算法.zcommon.Utils;

@SuppressWarnings("DuplicatedCode")
public class Demo06 {
    public static void main(String[] args) {
        Integer[] nums = Utils.generateArr(100, 20);
        rubbleSort(nums);
        Utils.printArr(nums);
    }
    public static void rubbleSort(Integer[] nums) {
        for(int end = nums.length - 1; end > 0; end--) {
            int lastChangeIndex = 0;
            for(int begin = 1; begin <= end; begin++) {
                if (nums[begin] < nums[begin - 1]) {
                    // 交换元素
                    Utils.swap(nums, begin, begin-1);
                    lastChangeIndex = begin;
                }
            }
            end = lastChangeIndex;
        }
    }
    public static void sort(Integer[] nums) {
        for (int end = nums.length - 1; end > 0; end--) {
            int lastChangeIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (nums[begin] < nums[begin - 1]) {
                    Utils.swap(nums, begin, begin - 1);
                    lastChangeIndex = begin;
                }
            }
            end = lastChangeIndex;
        }
    }
}