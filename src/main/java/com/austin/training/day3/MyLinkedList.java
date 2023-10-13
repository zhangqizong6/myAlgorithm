package com.austin.training.day3;

import java.util.List;

/**
 * @ClassName: designListNode
 * @author: zqz
 * @date: 2023/10/13 23:02
 */

public class MyLinkedList {

    int size;
    ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;

        ListNode cur = head;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;
        index = Math.max(0, index);
        size++;
        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pre.next;
        pre.next = toAdd;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void deleteAtIndex(int index){
        if (index < 0 || index >= size) return;

        size--;

        ListNode pre = head;
        for (int i = 0; i < size; i++) {
               pre =  pre.next;
        }
        pre.next = pre.next.next;

    }

}
