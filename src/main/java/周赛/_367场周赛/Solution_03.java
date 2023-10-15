package 周赛._367场周赛;

import java.util.TreeMap;

/**
 * @Author zal
 * @Date 2023/10/15 14:50
 * @Description 100101. 找出满足差值条件的下标 II https://leetcode.cn/problems/find-indices-with-index-and-value-difference-ii/
 * @Version 1.0
 * @Tag 双指针、TreeMap
 * 思路：
 * t1数据范围加强版，这题不能再使用暴力了，比赛时也是没想出来，但是赛后看题解觉得很简单很好理解
 * 暴力其实就是两层for循环，这里实质上其实也是双指针，所以我们可以使用双指针
 * 这里还有一个技巧，就是维护最大最小值，因为题目说只要有符合的就可以返回，所以我们只需要保证最大值和最小值有一个符合即可。
 * 枚举j的同时维护i的最大最小值。
 * Java中可以使用TreeMap，思路同理。
 */
public class Solution_03 {

    public int[] findIndices(int[] nums, int index, int value) {
        // 双指针 + 维护最小最大值
        int maxIndex = 0, minIndex = 0;
        for (int j = index; j < nums.length; j++) {
            int i = j - index;
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            } else if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
            if (nums[maxIndex] - nums[j] >= value) {
                return new int[]{maxIndex, j};
            }
            if (nums[j] - nums[minIndex] >= value) {
                return new int[]{j, minIndex};
            }
        }
        return new int[]{-1, -1};
    }

    public int[] findIndicesByTreeMap(int[] nums, int index, int value) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = nums.length;
        for (int i = index; i < n; i++) {
            map.put(nums[i - index], i - index);
            if (Math.abs(map.firstKey() - nums[i]) >= value) {
                return new int[]{map.get(map.firstKey()), i};
            }
            if (Math.abs(map.lastKey() - nums[i]) >= value) {
                return new int[]{map.get(map.lastKey()), i};
            }
        }
        return new int[]{-1, -1};
    }
}
