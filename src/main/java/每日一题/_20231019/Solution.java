package 每日一题._20231019;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zal
 * @Date 2023/10/19 10:23
 * @Description TODO 1726. 同积元组 https://leetcode.cn/problems/tuple-with-same-product
 * @Version 1.0
 * @Tag 哈希表
 */
public class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        int res = 0;
        // key是两个数的积，value是次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // 题目中有条件，数组中的元素各不相同
                int mul = nums[i] * nums[j];
                if (map.containsKey(mul)) {
                    // 因为每一对四元组会有8种结果
                    res += 8 * map.get(mul);
                }
                map.put(mul, map.getOrDefault(mul, 0) + 1);
            }
        }
        return res;
    }
}
