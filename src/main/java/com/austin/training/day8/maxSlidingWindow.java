package com.austin.training.day8;

/**
 * @ClassName: maxSlidingWindow
 * @author: zqz
 * @date: 2023/10/23 23:25
 */

import java.util.Arrays;

/**
 * 滑动窗口最大值
 * 239滑动窗口最大值
 */
public class maxSlidingWindow {

    /**
     * 暴力解法
     * @param nums
     * @param k
     * @return
     */
    public static int[] slidingWindow(int[] nums, int k) {

        int length = 0;
        for (int i = 0, j = k - 1; j <= nums.length - 1; i++, j++) {
            length++;
        }
        int[] ints = new int[length];
        int index = 0;
        for (int i = 0, j = k - 1; j <= nums.length - 1; i++, j++) {
            int tmp = nums[i];
            for (int l = i; l <= j; l++) {
                if (nums[l] >= tmp) {
                    tmp = nums[l];
                }
            }
            ints[index] = tmp;
            index++;
        }
        return ints;
    }

    public static int[] slidingWindowByQue(int[] nums, int k) {

        return null;
    }
    public static void main(String[] args) {
        int[] ints = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints1 = slidingWindow(ints, 3);
        System.out.println(Arrays.toString(ints1));

    }

}
