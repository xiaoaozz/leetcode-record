package 每日一题._20231026;

/**
 * @Author zal
 * @Date 2023/10/28 10:50
 * @Description TODO 2520. 统计能整除数字的位数 https://leetcode.cn/problems/count-the-digits-that-divide-a-number
 * @Version 1.0
 * @Tag 模拟
 */
public class Solution {
    public int countDigits(int num) {
        int x = num, res = 0;
        while(x > 0) {
            int t = x % 10;
            if (num % t == 0) {
                res++;
            }
            x /= 10;
        }
        return res;
    }
}