package 每日一题._20230916;

import java.util.Arrays;

/**
 * @Author zal
 * @Date 2023/9/16 15:13
 * @Description lc198. 打家劫舍 https://leetcode.cn/problems/house-robber/
 * @Version 1.0
 * @Tag 记忆化搜索、动态规划
 * 思路：
 * 本题是动态规划的基本题型，思路比较简单，对于当前房屋i，只有偷与不偷两种情况，
 * 递推公式显而易见
 */
public class Solution {

    public int rob(int[] nums) {
        return rob3(nums);
    }

    /**
     * 记忆化搜索
     *
     * @param nums
     * @return
     */
    private int[] nums, cache;
    private int res;

    private int rob3(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        // 记忆化数组
        this.cache = new int[n];
        // 初始化默认值为-1
        Arrays.fill(cache, -1);
        // 从最后一间屋子往前偷（本题是可以从后面开始考虑的）
        return dfs(n - 1);
    }

    private int dfs(int i) {
        if (i < 0) {
            // 如果超过边界，则返回0
            return 0;
        }
        if (cache[i] != -1) {
            // 如果当前位置已经被偷过，直接返回结果即可，减少重复计算
            return cache[i];
        }
        // dfs(i - 1) 偷上一间，当前就不能再偷了，所以 dfs(i) = dfs(i - 1)
        // dfs(i - 2) 偷上上一间，当前可以继续偷，所以 dfs(i) = dfs(i - 2) + nums[i]
        // 取最大值，就是当前偷的最优解
        cache[i] = Math.max(dfs(i - 1), dfs(i - 2) + nums[i]);
        return cache[i];
    }

    /**
     * 基本动态规划
     *
     * @param nums
     * @return
     */
    private int rob2(int[] nums) {
        // 特殊值判断
        int n = nums.length;
        if (n < 2) {
            return nums[0];
        }
        // 初始化dp数组
        int[] dp = new int[n];
        // 只有一间，偷是最优解
        dp[0] = nums[0];
        // 有两间，偷最大的是最优解
        dp[1] = Math.max(nums[0], nums[1]);
        // 从前往后遍历，递推最优解
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

    /**
     * 动态规划优化
     * 通过上面的动态规划可以得知，得到当前i的值，只需要用到i-1和i-2的值，
     * 所以可以使用两个变量来保存前面的两个值即可。
     *
     * @param nums
     * @return
     */
    private int rob1(int[] nums) {
        int n = nums.length;
        // 特殊值判断
        if (n < 2) {
            return nums[0];
        }
        // 所以我们使用a来记录第一次偷的值，b来记录第二次偷的值
        // 然后通过循环的方式来更新两个变量的值
        int a = 0, b = 0, f = 0;
        for (int i : nums) {
            f = Math.max(b, a + i);
            a = b;
            b = f;
        }
        return f;
    }
}
