package 每日一题._20231014;

/**
 * @Author zal
 * @Date 2023/10/15 15:34
 * @Description 136. 只出现一次的数字 https://leetcode.cn/problems/single-number
 * @Version 1.0
 * @Tag 位运算
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            // 计算第i位的bit位
            for (int x : nums) {
                cnt += (x >> i & 1);
            }
            // 还原第i位¬
            res |= (cnt % 2 << i);
        }
        return res;
    }
}
