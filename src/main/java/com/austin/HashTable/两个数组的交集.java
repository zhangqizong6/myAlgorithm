package com.austin.HashTable;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @ClassName: 两个数组的交集
 * @author: zqz
 * @date: 2023/8/8 11:49
 *
 * 题意：给定两个数组，编写一个函数来计算它们的交集。
 *
 * 时间复杂度: O(m + n)
 * 空间复杂度: O(n)
 * #
 */

public class 两个数组的交集 {

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> reset = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums1[i])) {
                reset.add(nums2[i]);
            }
        }
        return reset.stream().mapToInt(x -> x).toArray();
    }

    public static void main(String[] args) {
        int[] a = {1,2,2,1};
        int[] b = {2,2};
        int[] intersection = intersection(a, b);

        System.out.println(Arrays.toString(Arrays.stream(intersection).toArray()));
    }
}

