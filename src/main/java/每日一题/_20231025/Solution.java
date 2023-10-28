package 每日一题._20231025;

/**
 * @Author zal
 * @Date 2023/10/28 10:53
 * @Description TODO 2698. 求一个整数的惩罚数 https://leetcode.cn/problems/find-the-punishment-number-of-an-integer
 * @Version 1.0
 * @Tag 递归、DFS
 */
public class Solution {
    public int punishmentNumber(int n) {
        int res = 0;
        for(int i = 1; i <= n; i++) {
            int x = i * i;
            if(judge(String.valueOf(x), 0, i)) {
                res += x;
            }
        }
        return res;
    }
    public boolean judge(String s, int i, int x) {
        int m = s.length();
        // 如果枚举到最后一位，判断x == 0
        if(i >= m) return x == 0;
        int y = 0;
        for(int j = i; j < m; j++) {
            // 加上当前位的值
            y = y * 10 + (s.charAt(j) - '0');
            // 如果超过了剩余的数，则直接返回
            if(y > x) break;
            // 递归判断后续的是否符合
            if(judge(s, j + 1, x - y)) {
                return true;
            }
        }
        return false;
    }
}