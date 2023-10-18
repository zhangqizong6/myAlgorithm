package com.austin.training.day4;

/**
 * @ClassName: hxii
 * @author: zqz
 * @date: 2023/10/14 19:13
 */

import java.util.HashSet;

/**
 * 环形链表2 leetcode 142题
 */
public class detectCycleii {

    //    public ListNode detectCycle(ListNode head) {
//        if (head == null || head.next == null) return head;
//
//        ListNode pre = head;
//        ListNode cur = head.next;
//        while (cur.next != null) {
//            pre = cur;
//            cur = cur.next;
//        }
//
//        return pre;
//    }

    /**
     * set存储遍历过的数值
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pos = head;
        HashSet<ListNode> visited = new HashSet<>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }

    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {

        if (head == null) return null;

        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
