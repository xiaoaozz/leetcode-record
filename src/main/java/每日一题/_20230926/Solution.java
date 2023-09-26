package 每日一题._20230926;

/**
 * @Author zal
 * @Date 2023/9/26 09:52
 * @Description lc2582.递枕头 https://leetcode.cn/problems/pass-the-pillow
 * @Version 1.0
 * @Tag 模拟、数学
 */
class Solution {

    /**
     * 本人思路
     *
     * @param n
     * @param time
     * @return
     */
    public int passThePillow(int n, int time) {
        if (n - 1 == time) {
            // 刚好传递到队尾
            return n;
        } else if (n - 1 < time) {
            // 会出现反向的情况
            // n个人需要传递n-1次
            // 偶数次说明正向，奇数次说明反向
            int count = time % (n - 1);
            return (time / (n - 1)) % 2 == 0 ? count + 1 : n - count;
        } else {
            // 传递不到队尾，直接返回对应序号即可
            return time + 1;
        }
    }

    public int passThePillow1(int n, int time) {
        // 传递的次数，相对于整个队伍来说
        int cnt = time / (n - 1);
        // 多出的传递的次数，相对于个人来说
        int add = time % (n - 1);
        // 如果队伍传递次数为偶数，则说明此时是正向传递
        if ((cnt & 1) == 0) {
            return add + 1;
        }
        // 否则是反向传递
        return n - add;
    }
}