package 每日一题._20231018;

import java.util.PriorityQueue;

/**
 * @Author zal
 * @Date 2023/10/18 09:54
 * @Description TODO 2530. 执行 K 次操作后的最大分数 https://leetcode.cn/problems/maximal-score-after-applying-k-operations
 * @Version 1.0
 * @Tag 堆、优先队列
 */
public class Solution {
    /**
     * 堆、优先队列
     *
     * @param nums
     * @param k
     * @return
     */
    public long maxKelements(int[] nums, int k) {
        long res = 0L;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i : nums) {
            pq.add(i);
        }
        while (!pq.isEmpty() && k > 0) {
            int t = pq.poll();
            k--;
            res += t;
            pq.add((int) Math.ceil(t / 3.0));
        }
        return res;
    }

    /**
     * 原地堆化
     *
     * @param nums
     * @param k
     * @return
     */
    public long maxKelementsByArray(int[] nums, int k) {

        heapify(nums); // 原地堆化（最大堆）
        long ans = 0;
        while (k-- > 0) {
            ans += nums[0]; // 堆顶
            nums[0] = (nums[0] + 2) / 3;
            sink(nums, 0); // 堆化（只需要把 nums[0] 下沉）
        }
        return ans;
    }

    // 原地堆化（最大堆）
    // 堆化可以保证 h[0] 是堆顶元素，且 h[i] >= max(h[2*i+1], h[2*i+2])
    private void heapify(int[] h) {
        // 下标 >= h.length / 2 的元素是二叉树的叶子，无需下沉
        // 倒着遍历，从而保证 i 的左右子树一定是堆，那么 sink(h, i) 就可以把左右子树合并成一个堆
        for (int i = h.length / 2 - 1; i >= 0; i--) {
            sink(h, i);
        }
    }

    // 把 h[i] 不断下沉，直到 i 的左右儿子都 <= h[i]
    private void sink(int[] h, int i) {
        int n = h.length;
        while (2 * i + 1 < n) {
            int j = 2 * i + 1; // i 的左儿子
            if (j + 1 < n && h[j + 1] > h[j]) { // i 的右儿子比 i 的左儿子大
                j++;
            }
            if (h[j] <= h[i]) { // 说明 i 的左右儿子都 <= h[i]，停止下沉
                break;
            }
            swap(h, i, j); // 下沉
            i = j;
        }
    }

    // 交换 h[i] 和 h[j]
    private void swap(int[] h, int i, int j) {
        int tmp = h[i];
        h[i] = h[j];
        h[j] = tmp;
    }
}
