package 每日一题._20231016;

/**
 * @Author zal
 * @Date 2023/10/16 10:09
 * @Description 260. 只出现一次的数字 III https://leetcode.cn/problems/single-number-iii
 * @Version 1.0
 * @Tag 位运算
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        // 先求出所有的异或和
        for (int x : nums) {
            xor ^= x;
        }
        // 此时只有两个出现一次的数字的异或和
        // 将所有数按照当前bit位分组
        // lowbit是最后一个bit位，两个数的bit位一个为0，一个为1
        int lowbit = xor & -xor;
        int[] ans = new int[2];
        // 再次遍历数组，分组后分别异或，可以分开两个元素
        // 这里还有一种优化思路，因为res是两个数的异或结果，异或结果是可逆的，所以我们只需要求出一个数，然后另一个数异或即可。
        for (int x : nums) {
            ans[(x & lowbit) == 0 ? 0 : 1] ^= x;
        }
        return ans;
    }
}
