package 力扣._0128;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author zal
 * @Date 2023/10/21 19:44
 * @Description TODO 128. 最长连续序列
 * @Version 1.0
 * @Tag 排序、哈希表
 */
public class Solution {

    /**
     * 哈希表
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int max = 0;
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int cur = i;
                int count = 1;
                // 枚举左端点
                while (set.contains(cur + 1)) {
                    cur += 1;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
