package 每日一题._20231012;

/**
 * @Author zal
 * @Date 2023/10/12 10:50
 * @Description lc 2562. 找出数组的串联值 https://leetcode.cn/problems/find-the-array-concatenation-value
 * @Version 1.0
 * @Tag 双指针、模拟
 */
public class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long res = 0;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            // 使用Math.log10(n) + 1求n的位数
            res += (long) nums[l] * Math.pow(10, (int) Math.log10(nums[r]) + 1) + nums[r];
            l++;
            r--;
        }
        return l == r ? res += nums[l] : res;
    }
}
