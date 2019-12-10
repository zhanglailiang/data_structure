package com.data.structure.study.link;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-12-08 17:35
 **/
public class FastSlow {


    /**
     * 解决循环依赖问题很好
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode t = head;
        ListNode slow = t;
        ListNode fast = t;
        for (; ;) {
            slow = slow.next;
            if (slow == null) {
                return false;
            }
            fast = fast.next;
            if (fast == null) {
                return false;
            }
            fast = fast.next;
            // 如果块指针没找到，则为null
            if (fast == null) {
                return false;
            }
            if (slow == fast) {
                return true;
            }
        }
    }


    /**
     * 移动窗口法
     * @param nums
     * @return
     */
    public int count(int[] nums) {
        if (nums == null && nums.length == 0) {
            return 0;
        }

        int length = nums.length;
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < length) {
            // 如果指针位数指向-0，则左右指针都向右移动
            if (nums[right] == 0) {
                right++;
                left = right;
            }

            // 如果右指针指向1，则右指针继续向右移动
            while ( right < length  && nums[right] == 1 ) {
                right++;
            }

            if (left <= right && max < (right - left)) {
                max = right - left;
                left = right;
            }
        }

        return max;
    }


    public static void main(String[] args) {
        FastSlow slow = new FastSlow ();
        int count = slow.count (new int[]{1});
        System.out.println (count);
    }


}
