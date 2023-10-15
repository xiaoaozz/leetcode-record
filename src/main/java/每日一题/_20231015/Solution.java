package 每日一题._20231015;

/**
 * @Author zal
 * @Date 2023/10/15 15:33
 * @Description 137. 只出现一次的数字 II https://leetcode.cn/problems/single-number-ii
 * @Version 1.0
 * @Tag 位运算
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            // 计算第i位的bit位为1的个数
            for (int x : nums) {
                cnt += (x >> i & 1);
            }
            // 取模后还原该bit位
            res |= (cnt % 3 << i);
        }
        return res;
    }
}
