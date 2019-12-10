package com.data.structure.study.link;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-12-06 10:43
 **/
public class ListNode {


    int val;
    ListNode next;
    ListNode(int x) { val = x; }


    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
