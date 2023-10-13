package com.austin.training.day3;

/**
 * @ClassName: removeElements
 * @author: zqz
 * @date: 2023/10/13 22:50
 */

public class removeElements {


    public ListNode removeE(ListNode head, int val) {

        while (head != null && head.val != val) {
            head = head.next;
        }

        //为空直接退出
        if (head == null) return head;

        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null) {

            if (cur.val == pre.val){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

}
