package com.data.structure.study.link;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: spring_boot_study
 * @description:滑动窗口
 * @author: zhanglailiang
 * @create: 2019-12-08 14:20
 **/
public class SlideWindows {

    public static void main(String[] args) {
        SlideWindows slideWindows = new SlideWindows () ;
//        System.out.println (slideWindows.minWindow ("a", "a"));
        System.out.println (slideWindows.minSubArrayLen (4, new int[]{1, 4, 4}));
//        System.out.println (slideWindows.lengthOfLongestSubstring2 ("abceabcbbabcabcbbddd"));
    }

    //滑动窗口算法
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<Character> ();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {//窗口的左边是i，右边是j，下列算法将窗口的左右移动，截取出其中一段
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){//如果set中不存在该字母，就将j+1，相当于窗口右边向右移动一格，左边不动
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);//记录目前存在过的最大的子字符长度
            }
            else {//如果set中存在该字母，则将窗口左边向右移动一格，右边不动，直到该窗口中不存在重复的字符
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        //使用hashmap记录遍历过的字符的索引，当发现重复的字符时，可以将窗口的左边直接跳到该重复字符的索引处
        Map<Character, Integer> map = new HashMap<Character, Integer> (); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {//j负责向右边遍历，i根据重复字符的情况进行调整
            if (map.containsKey(s.charAt(j))) {//当发现重复的字符时,将字符的索引与窗口的左边进行对比，将窗口的左边直接跳到该重复字符的索引处
                i = Math.max(map.get(s.charAt(j)), i);
            }
            //记录子字符串的最大的长度
            ans = Math.max(ans, j - i + 1);
            //map记录第一次遍历到key时的索引位置，j+1,保证i跳到不包含重复字母的位置
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }


    /**
     * 算法解析 使用滑动窗口
     * 设置需要的字符个数为一个hash 值 每个需要检索的字符串设置为负的预留位，表示需要填充这些位数
     * 窗口右指针向右移动，没遇到一个字符串则再hash中新增一个，如果hash值小于等于- 说明命中了一个字符数，则count--
     * 检查left指针指向的数是否大于0 如果大于0则说明需要的位数多了，则想有移动，hash值减1
     *
     * 如果count==0 则取最小的数字长度
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        char[] ss = s.toCharArray ();
        char[] tt = t.toCharArray ();

        //  预留位置
        int[]  hash = new  int[256];
        for (char ttt: tt) {
            hash[ttt -'0'] --;
        }

        int left = 0;
        int right = 0;

        int length = ss.length;
        int min = length;
        int count = t.length ();

        String minTarget  = "";
        for (; right < length; right++) {

            // 每次新增一个字符串就新增一个
            hash[ss[right] - '0'] ++;

            // 说明命中一个 都命中的话 则count为0 第一个保证第一个不多于只有一个就ok
            if (hash[ss[right] - '0'] <=0 ) {
                count--;
            }

            // 检查左指针是否多余的 如果多余的就去掉
            while (left < right &&  hash[ss[left] - '0'] > 0) {
                hash[ss[left] - '0']--;
                left++;
            }

            // 都命中过，切左指针至少保留一个，是完整的
            if (count == 0 && min >= (right - left  + 1)) {
                min = right - left + 1;
                minTarget = s.substring (left, right + 1);
            }
        }

        return  minTarget;
    }

    /**
     * 算法解析  滑动窗口+双指针  向右滑动,
     */
    private int res = Integer.MAX_VALUE;
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null)
            return 0;
        int left = 0;
        int right = 0;
        int sum = 0;

        while (right < nums.length) {
            sum += nums[right];
            while (left <= right && sum >= s) {
                res = Math.min (res, right - left +1);
                sum -= nums[left];
                left++;
            }
            right ++;
        }
        if(res == Integer.MAX_VALUE)
            return 0;
        return res;
    }



}
