package 周赛._367场周赛;

/**
 * @Author zal
 * @Date 2023/10/15 15:26
 * @Description 8026. 构造乘积矩阵 https://leetcode.cn/problems/construct-product-matrix/
 * @Version 1.0
 * @Tag 前缀和、后缀和
 * 思路：
 * 这道题其实就是lc238. 除自身以外数组的乘积 https://leetcode.cn/problems/product-of-array-except-self/
 * 的二维题目，主要就是求当前下标i，j的前缀乘积和后缀乘积，然后处理返回即可。
 */
public class Solution_04 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        // 后缀乘积
        int suf = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = suf;
            suf *= nums[i];
        }
        // 前缀乘积
        int pre = 1;
        for (int i = 0; i < n; i++) {
            res[i] = pre * res[i];
            pre *= nums[i];
        }
        return res;
    }
}
