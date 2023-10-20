package 每日一题._20231020;

/**
 * @Author zal
 * @Date 2023/10/20 10:08
 * @Description TODO 2525. 根据规则将箱子分类 https://leetcode.cn/problems/categorize-box-according-to-criteria/
 * @Version 1.0
 * @Tag 模拟
 */
public class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean bulky = false, heavy = false;
        int stand = 10000, max = (int) 1e9;
        long volume = (long) length * width * height;
        if (length >= 10000 || width >= stand || height >= stand || volume >= max) {
            bulky = true;
        }
        if (mass >= 100) heavy = true;
        if (bulky && heavy) return "Both";
        if (bulky) return "Bulky";
        if (heavy) return "Heavy";
        return "Neither";
    }
}
