package 每日一题._20230915;

/**
 * @Author zal
 * @Date 2023/9/15 12:26
 * @Description LCP 50. 宝石补给 https://leetcode.cn/problems/WHnhjV/
 * @Version 1.0
 * @Tag 模拟
 */
class Solution {
    public int giveGem(int[] gem, int[][] operations) {
        for (int[] op : operations) {
            // 模拟赠予过程
            int a = op[0], b = op[1], give = gem[a] / 2;
            gem[a] -= give;
            gem[b] += give;
        }
        // 1、使用快排
        // quickSort(gem, 0, gem.length - 1);
        // return gem[gen.length - 1] - gem[0];

        // 2、使用遍历
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : gem) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        return max - min;
    }

    /**
     * 快速排序模版
     *
     * @param nums 排序的数组
     * @param l    左边界
     * @param r    右边界
     */
    public void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int i = l - 1, j = r + 1, x = nums[l + (r - l) / 2];
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        quickSort(nums, l, j);
        quickSort(nums, j + 1, r);
    }
}
