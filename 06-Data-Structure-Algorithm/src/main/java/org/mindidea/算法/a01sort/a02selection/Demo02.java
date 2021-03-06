package org.mindidea.算法.a01sort.a02selection;

import org.mindidea.算法.zcommon.Utils;

public class Demo02 {
    public static void main(String[] args) {
        Integer[] integers = Utils.generateArr(20, 35);
        Utils.printArr(integers);
        sort(integers);
        Utils.printArr(integers);
    }

    @SuppressWarnings("DuplicatedCode")
	public static void sort(Integer[] arr) {
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
}
