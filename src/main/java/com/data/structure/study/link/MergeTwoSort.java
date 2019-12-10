package com.data.structure.study.link;

/**
 * @program: spring_boot_study
 * @description: 合并两个有序链表
 * @author: zhanglailiang
 * @create: 2019-12-06 10:42
 **/
public class MergeTwoSort {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode pIter1 = l1, pIter2 = l2;
        ListNode head = new ListNode(-1);
        ListNode pIter = head;
        while (pIter1 != null && pIter2 != null) {
            if (pIter1.val < pIter2.val) {
                pIter.val = pIter1.val;
                pIter1 = pIter1.next;
            } else {
                pIter.val = pIter2.val;
                pIter2 = pIter2.next;
            }
            ListNode pNew = new ListNode(-1);
            pIter.next = pNew;
            pIter = pIter.next;
        }

        while (pIter1 != null) {
            pIter.val = pIter1.val;
            pIter1 = pIter1.next;
            if (pIter1 != null) {
                ListNode pNew = new ListNode(-1);
                pIter.next = pNew;
                pIter = pIter.next;
            }
        }

        while (pIter2 != null) {
            pIter.val = pIter2.val;
            pIter2 = pIter2.next;
            if (pIter2 != null) {
                ListNode pNew = new ListNode(-1);
                pIter.next = pNew;
                pIter = pIter.next;
            }
        }
        return head;
    }

}


