package com.austin.LinkedList;

/**
 * @ClassName: ListNode
 * @author: zqz
 * @date: 2023/8/5 20:00
 */

public class ListNode {
    //节点值
    int val;

    //下一个节点
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
