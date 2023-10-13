package com.austin.training.day3;

/**
 * @ClassName: reverseList
 * @author: zqz
 * @date: 2023/10/13 23:24
 */

public class reverseListSolution {

    public ListNode reverserList(ListNode head) {

        if (head == null) return head;

        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;

        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

}
