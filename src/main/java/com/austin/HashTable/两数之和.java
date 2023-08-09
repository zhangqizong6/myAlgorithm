package com.austin.HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: 两数之和
 * @author: zqz
 * @date: 2023/8/9 09:54
 */

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * <p>
 * 所以返回 [0, 1]
 * <p>
 * #
 */

public class 两数之和 {

    public static int[] sum(int[] nums, int target) {

        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                res[1] = i;
                res[0] = map.get(tmp);
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] sum = sum(nums, 9);
        System.out.println(Arrays.toString(sum));
    }

}
