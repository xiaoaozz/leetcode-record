package 每日一题._20231022;

import java.util.Arrays;

/**
 * @Author: zal
 * @Date: 2023-10-22
 * @Description: TODO 1402. 做菜顺序 https://leetcode.cn/problems/reducing-dishes
 * @Version: 1.0
 * @Tag 贪心、枚举
 */
public class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        // 先对数组进行排序
        Arrays.sort(satisfaction);
        int cur = 0, res = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            // 值越大的菜贡献越大
            cur += satisfaction[i];
            // 如果贡献总和小于0，则可以直接结束循环
            if (cur <= 0) {
                break;
            }
            // 加上之前每一次的贡献值
            res += cur;
        }
        return res;
    }
}
