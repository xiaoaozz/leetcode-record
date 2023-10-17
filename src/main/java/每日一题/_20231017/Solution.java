package 每日一题._20231017;

/**
 * @Author zal
 * @Date 2023/10/17 10:00
 * @Description 2652. 倍数求和 https://leetcode.cn/problems/sum-multiples
 * @Version 1.0
 * @Tag 枚举、数学
 */
public class Solution {

    private int n;

    public int sumOfMultiples(int n) {
        // 对于1-n的数里面，能被x整数的数有 n / x 个
        // 即 x, 2x, 3x, 4x ... mx，等差数列，求和得
        // f(x) = (x + mx) * m / 2;
        this.n = n;
        // 容斥原理
        return f(3) + f(5) + f(7) - f(3 * 5) - f(3 * 7) - f(5 * 7) + f(3 * 5 * 7);
    }

    /**
     * f(x) = (x + mx) * m / 2;
     *
     * @param x 求和的数
     * @return 1-n中x的倍数和
     */
    public int f(int x) {
        int m = n / x;
        return (x + m * x) * m / 2;
    }
}
