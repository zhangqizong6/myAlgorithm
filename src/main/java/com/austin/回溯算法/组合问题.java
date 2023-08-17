package com.austin.回溯算法;

/**
 * @ClassName: 回溯算法
 * @author: zqz
 * @date: 2023/8/17 09:38
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合问题
 * <p>
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例: 输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * <p>
 * #
 */
public class 组合问题 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, k, 1);
        return result;
    }

    public void backTracking(int n, int k, int startIndex) {

        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            //一直在这里递归下去 如果size == k的话就停止走下一步了
            backTracking(n, k, i + 1);
            //这里就会依次递归把链表里面的都删除了
            path.removeLast();
        }

    }


}
