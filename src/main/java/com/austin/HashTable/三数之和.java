package com.austin.HashTable;

/**
 * @ClassName: 三数之和
 * @author: zqz
 * @date: 2023/8/11 09:36
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意： 答案中不可以包含重复的三元组。
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 * <p>
 * #
 */
public class 三数之和 {
    /**
     * 这道题目的重点会是去重，这道题虽然说可以用哈希 但是用双指针会更好点
     *
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(1)
     * #
     */
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        //这里排序一下数组
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //排序过了的 如果第一个还是大于0那肯定有问题返回
            if (nums[i] > 0) {
                return result;
            }
            //去重a
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //去重逻辑应该是在找到一个三元数组后 对b和c去重
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    left++;
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }
}
