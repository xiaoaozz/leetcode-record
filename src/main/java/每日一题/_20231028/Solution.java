package 每日一题._20231028;

/**
 * @Author zal
 * @Date 2023/10/28 10:47
 * @Description TODO 2558. 从数量最多的堆取走礼物 https://leetcode.cn/problems/take-gifts-from-the-richest-pile
 * @Version 1.0
 * @Tag 优先队列、模拟堆
 */
public class Solution {
    public long pickGifts(int[] gifts, int k) {
        // 原地堆化
        heapify(gifts);
        while(k-- > 0 && gifts[0] > 1) {
            gifts[0] = (int)Math.sqrt(gifts[0]); // 直接修改堆顶元素
            sink(gifts, 0); // 堆化
        }
        long res = 0;
        for(int g : gifts) {
            res += g;
        }
        return res;
    }

    // 原地堆化
    // 堆化可以保证h[0]是堆顶元素，且h[i] >= max(h[2*i+1], h[2*i]+2)
    private void heapify(int[] h) {
        // 倒着遍历，从而保证i的左右子树一定是堆，那么sink(h, i)就可以把左右子树合并成一个堆
        for(int i = h.length / 2 - 1; i >= 0; i--) {
            sink(h, i);
        }
    }

    private void sink(int[] h, int i) {
        int n = h.length;
        while(2 * i + 1 < n) {
            // i的左儿子
            int j = 2 * i + 1;
            if (j + 1 < n && h[j + 1] > h[j]) {
                // i的右儿子比i的左儿子大
                j++;
            }
            if (h[j] <= h[i]) {
                // 说明i的左右儿子都 <= h[i]，停止下沉
                break;
            }
            swap(h, i, j); // 下沉
            i = j;
        }
    }

    private void swap(int[] h, int i, int j) {
        int t = h[i];
        h[i] = h[j];
        h[j] = t;
    }
}