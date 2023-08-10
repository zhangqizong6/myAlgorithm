package com.austin.HashTable;

/**
 * @ClassName: 四数相加
 * @author: zqz
 * @date: 2023/8/10 14:50
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * <p>
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -2^28 到 2^28 - 1 之间，最终结果不会超过 2^31 - 1 。
 * <p>
 * 例如:
 * <p>
 * 输入:
 * <p>
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * 输出:
 * <p>
 * 2
 * <p>
 * 解释:
 * <p>
 * 两个元组如下:
 * <p>
 * (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * #
 */
public class 四数相加 {

    /**
     * 这里的思想主要是 分两部来算 每两个为0的时候就归为0
     *
     * @return
     */
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        //统计剩余的两个数
        for (int i : nums3) {
            for (int j : nums4) {
                res += map.getOrDefault(-i - j, 0);
            }
        }
        return res;
    }

    /**
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(n^2)，最坏情况下A和B的值各不相同，相加产生的数字个数为 n^2
     * @param args
     */

    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {-2, -1};
        int[] c = {-1, 2};
        int[] d = {0, 2};
        int i = fourSumCount(a, b, c, d);
        System.out.println(i);
    }
}
