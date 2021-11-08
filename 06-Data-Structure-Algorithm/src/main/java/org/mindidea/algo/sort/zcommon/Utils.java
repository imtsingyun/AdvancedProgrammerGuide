package org.mindidea.algo.sort.zcommon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {

    public static void printArr(Integer[] arr) {
        for (int j : arr) {
            System.out.print(j + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printArr(generateArr(10, 20));
    }

    public static Integer[] generateArr(int maxValue, int size) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            Random random = new Random();
            int v = random.nextInt(maxValue);
            arr[i] = v;
        }
        System.out.println("================开始生成数组================");
        printArr(arr);
        System.out.println("================生成数组结束================");
        return arr;
    }

    private static List<Integer> randomList(List<Integer> sourceList) {
        if (sourceList == null || sourceList.size() == 0) {
            return sourceList;
        }
        ArrayList<Integer> randomList = new ArrayList<>(sourceList.size());
        do {
            int randomIndex = Math.abs(new Random().nextInt(sourceList.size()));
            randomList.add(sourceList.remove(randomIndex));
        } while (sourceList.size() > 0);
        return randomList;
    }

    public static void swap(Integer[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}

