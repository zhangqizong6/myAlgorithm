package com.austin.LinkedList;

/**
 * @ClassName: 翻转链表
 * @author: zqz
 * @date: 2023/8/6 23:41
 */

import java.util.List;

/**
 * 题意：反转一个单链表。
 * <p>
 * 示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
 */
public class 翻转链表 {

    /**
     * 双指针
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * #
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {

            temp = cur.next; //下一个节点
            cur.next = pre;
            pre = cur;
            cur = temp;

        }
        return pre;

    }

    /**
     * 递归
     * 时间复杂度: O(n), 要递归处理链表的每个节点
     * 空间复杂度: O(n), 递归调用了 n 层栈空间
     */
    public ListNode reverseListByDG(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode pre, ListNode cur) {

        if (cur == null) {
            return pre;
        }

        ListNode temp = null;
        temp = cur.next;
        cur.next = pre;
        return reverse(cur, temp);

    }

}
