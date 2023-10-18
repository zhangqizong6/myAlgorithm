package com.austin.training.day4;

/**
 * @ClassName: removeNthFromEnd
 * @author: zqz
 * @date: 2023/10/14 18:59
 */

/**
 * 删除链表的倒数第n个节点
 */
public class removeNthFromEnd {

    public ListNode remove(ListNode head, int n) {

        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        int length = getLength(head);
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }

        cur.next = cur.next.next;
        return dummy.next;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

}
