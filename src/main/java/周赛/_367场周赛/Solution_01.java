package 周赛._367场周赛;

/**
 * @Author zal
 * @Date 2023/10/15 14:40
 * @Description 100096. 找出满足差值条件的下标 I  https://leetcode.cn/problems/find-indices-with-index-and-value-difference-i/
 * @Version 1.0
 * @Tag 枚举、双指针、维护最小最大值
 * 思路：
 * 这道题作为第一题是道简单题，所以我们可以直接暴力来做，直接枚举i，j寻找合适的下标即可。
 */
public class Solution_01 {

    public int[] findIndices(int[] nums, int index, int value) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + index; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) >= value) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
