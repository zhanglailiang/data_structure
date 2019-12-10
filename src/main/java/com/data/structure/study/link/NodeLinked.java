package com.data.structure.study.link;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-12-03 18:05
 **/
public class NodeLinked {

    /**
     * 合并排序
     *
     * 快慢指针模式
     * 二分模式
     *
     * @param args
     */
    public static void main(String[] args) {

         Solution solution = new Solution ();
         ListNode node = new ListNode (3);
         ListNode node1 = new ListNode (4);
         ListNode node2 = new ListNode (1);
         ListNode node3 = new ListNode (2);
         ListNode node4 = new ListNode (5);
         node.setNext (node1);
         node1.setNext (node2);
         node2.setNext (node3);
         node3.setNext (node4);

        ListNode listNode = solution.sortList (node);
        System.out.println (listNode);
    }
}

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }

}


