package com.austin.HashTable;

/**
 * @ClassName: 快乐数
 * @author: zqz
 * @date: 2023/8/8 14:07
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 * <p>
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 * <p>
 * 示例：
 * <p>
 * 输入：19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class 快乐数 {

    public static boolean happyNum(int n) {
        Set<Integer> set = new HashSet<>();
        while (1 != n && !set.contains(n)) {
            //加入set去判定唯一
            set.add(n);
            //改变n的数值
            n = changeN(n);
        }
        return n == 1;
    }

    public static int changeN(Integer n) {
        int res = 0;
        while (n > 0) {
            int tmp = n % 10;
            res += tmp * tmp;
            n = n / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int d =19;
        boolean b = happyNum(19);
        System.out.println(b);
    }

}
