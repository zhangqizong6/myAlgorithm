package com.austin.Arrays;

/**
 * @ClassName: 移除元素
 * @author: zqz
 * @date: 2023/8/5 19:21
 */

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 1: 给定 nums = [3,2,2,3], val = 3, 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2: 给定 nums = [0,1,2,2,3,0,4,2], val = 2, 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 */
public class 移除元素 {

    /**
     * 要知道数组的元素在内存地址中是连续的，不能单独删除数组中的某个元素，只能覆盖。
     */
    public static int removeElement(int[] nums, int val) {
        //快慢指针
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[slowIndex] != nums[fastIndex]){
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }
    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static void main(String[] args) {

    }


}
