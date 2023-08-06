package com.austin.LinkedList;

/**
 * @ClassName: 移除链表元素
 * @author: zqz
 * @date: 2023/8/5 21:12
 */

import java.util.List;

/**
 * 题意：删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例 1： 输入：head = [1,2,6,3,4,5,6], val = 6 输出：[1,2,3,4,5]
 * <p>
 * 示例 2： 输入：head = [], val = 1 输出：[]
 * <p>
 * 示例 3： 输入：head = [7,7,7,7], val = 7 输出：[]
 */
public class 移除链表元素 {

    /**
     * 添加虚拟节点
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public ListNode removeListNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        //设置虚拟节点
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                //此处就是删除了当前的val
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * 不添加虚拟节点
     */
    public ListNode removeListNodeByNotCreate(ListNode head, int val) {
        while (head != null && head.val != val) {
            head = head.next;
        }

        //为空直接退出
        if (head == null) return head;

        // 已确定当前head.val != val
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }

        return head;

    }


}
