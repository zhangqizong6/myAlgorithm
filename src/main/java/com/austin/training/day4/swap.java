package com.austin.training.day4;

import com.austin.training.day4.ListNode;

/**
 * @ClassName: swap
 * @author: zqz
 * @date: 2023/10/14 18:17
 */

/**
 * 两两交换链表节点
 */
public class swap {

    public ListNode swapPairs(ListNode head){

        if (head == null || head.next == null) return head;

        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

}
