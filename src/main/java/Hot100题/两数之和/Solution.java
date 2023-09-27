package Hot100题.两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zal
 * @Date 2023/9/26 18:32
 * @Description 两数之和
 * @Version 1.0
 * @Tag 枚举、哈希表
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
public class Solution {

    /**
     * 暴力枚举
     * 时间复杂度O(n ^ 2)，空间复杂度O(1)，n是数组的长度
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumByEnum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 哈希表
     * 时间复杂度O(n)，空间复杂度O(n)，n是数组的长度
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumByMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}
