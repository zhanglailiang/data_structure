package com.data.structure.study.link;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-12-05 20:00
 **/
public class QuickSort {


    /**
     * 快速排序 取第一个为基准标数，大于标数的放左边，小于标数的放右边
     *    详细，基准标数和数组右指针指向值对比 ，如果小于右指针指向，则右指针向左移，
     *    如果大于右指针指向值，则将右指针数据替换为左指针指向数据，左指针向右移动
     *
     *    基准标数和数组左指针指向值对比，如果大于左指针指向值，则左指针右移
     *    如果小于左指针指向值，则将右指针数据替换为左指针数据,右指针左移
     *
     *    如果左指针不小于右指针，则终止循环
     *
     *    基准标数赋值给左指针指向位
     *
     *    返回左指针 位
     *
     *
     *    <strong>算法模式 二分法和双指针法</strong>
     * @param arrs
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] arrs, int left, int right) {
        int tmp = arrs[left];
        while (left < right ) {

            while (tmp <= arrs[right] && right > left) {
                right--;
            }

            if (right > left) {
                arrs[left] = arrs[right];
                left++;
            }

            while (tmp > arrs[left] && right > left) {
                left++;
            }

            if (right > left) {
                arrs[right] = arrs[left];
                right--;
            }
        }

        arrs[left] = tmp;
        return left;
    }


    private int[] sort(int[] arrs, int left, int right) {
        if (arrs  == null || arrs.length <= 1 || left >= right)  {
            return arrs;
        }

        int mid = partition (arrs, left, right);
        sort (arrs, left, mid);
        sort (arrs, mid + 1, right);
        return arrs;
    }

    public static void main(String[] args) {
        int[] arrs = {3, 4, 1, 5, 1, 5, 2,19, 11, 45, 14, 67,12,11,111,11};
        QuickSort sort = new QuickSort ();
        int[] sort1 = sort.sort (arrs, 0, (arrs.length - 1));


        for (int i = 0; i < sort1.length ; i++) {
            System.out.print (arrs[i]);
            System.out.print (" ");
        }
        System.out.println ();
    }
}
