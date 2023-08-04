package com.austin.Arrays;

/**
 * @ClassName: 二分查找
 * @author: zqz
 * @date: 2023/8/4 12:01
 */

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 */
public class 二分查找 {

    /**
     * 左闭右闭区间
     */
    public static int search(int[] nums, int target) {

        if (target < nums[0] || target > nums[nums.length - 1]) return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int search = search(nums, 3);
        System.out.println(search);
    }

}
