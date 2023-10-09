package 每日一题._20231009;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author zal
 * @Date 2023/10/9 20:47
 * @Description lc2578. 最小和分割 https://leetcode.cn/problems/split-with-minimum-sum/
 * @Version 1.0
 * @Tag 排序+贪心
 */
public class Solution {

    /**
     * 拆位 + 排序
     *
     * @param num
     * @return
     */
    public int splitNum1(int num) {
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            // 把每一位提出来，不是偶数就会自动补0
            list.add(num % 10);
            num /= 10;
        }
        // 排序
        Collections.sort(list);
        int a = 0, b = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                a *= 10;
                a += list.get(i);
            } else {
                b *= 10;
                b += list.get(i);
            }
        }
        return a + b;
    }


    /**
     * 拆位 + 排序
     *
     * @param num
     * @return
     */
    public int splitNum2(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        Arrays.sort(chars);
        int[] a = new int[2];
        for (int i = 0; i < chars.length; i++) {
            a[i & 1] = a[i & 1] * 10 + (chars[i] - '0');
        }
        return a[0] + a[1];
    }
}
