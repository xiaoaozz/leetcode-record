package 每日一题._20231024;

/**
 * @Author zal
 * @Date 2023/10/28 11:35
 * @Description TODO 1155. 掷骰子等于目标和的方法数 https://leetcode.cn/problems/number-of-dice-rolls-with-target-sum
 * @Version 1.0
 * @Tag 动态规划
 */
public class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        int mod = (int)1e9 + 7;
        dp[0][0] = 1;
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < target + 1; j++) {
                for(int x = 1; x <= k && x < j; x++) {
                    dp[i][j] += dp[i - 1][j - x] % mod;
                }
            }
        }
        return dp[n][target];
    }
}
