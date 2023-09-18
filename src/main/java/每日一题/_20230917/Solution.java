package 每日一题._20230917;

import java.util.Arrays;

/**
 * @Author zal
 * @Date 2023/9/18 12:37
 * @Description lc213. 打家劫舍 II https://leetcode.cn/problems/house-robber-ii
 * @Version 1.0
 * @Tag 记忆化搜索、动态规划
 * 思路：
 * 打家劫舍II思路和I一致，不过这里的数组是环形的，需要考虑第一家和最后一家也加入了偷与不偷的选择中，
 * 其实把I的代码拿过来，偷第一家与不偷第一家结果取最大值即可。
 */
public class Solution {
    public int rob(int[] nums) {
        return rob1(nums);
    }

    /**
     * 记忆化搜索
     *
     * @param nums
     * @return
     */
    private int[] nums;

    public int rob1(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        if (n < 2) return nums[0];
        int[] cache1 = new int[n];
        int[] cache2 = new int[n];
        Arrays.fill(cache1, -1);
        Arrays.fill(cache2, -1);
        return Math.max(dfs1(n - 1, cache1, true), dfs1(n - 2, cache2, false));
    }

    public int dfs1(int i, int[] cache, boolean f) {
        // f表示是否偷第一家
        if (f) {
            // 不偷，到第1家就结束
            if (i < 1) return 0;
        } else {
            // 偷，到第0家结束
            if (i < 0) return 0;
        }
        if (cache[i] != -1) return cache[i];
        cache[i] = Math.max(dfs1(i - 1, cache, f), dfs1(i - 2, cache, f) + nums[i]);
        return cache[i];
    }

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        return Math.max(
                dfs2(Arrays.copyOfRange(nums, 0, n - 1)),
                dfs2(Arrays.copyOfRange(nums, 1, n))
        );
    }


    public int dfs2(int[] nums) {
        int n = nums.length;
        if (n < 2) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }
}
