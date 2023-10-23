package 每日一题._20231023;

/**
 * @Author zal
 * @Date 2023/10/23 09:56
 * @Description TODO 2678. 老人的数目 https://leetcode.cn/problems/number-of-senior-citizens
 * @Version 1.0
 * @Tag 字符串
 */
public class Solution {
    public int countSeniors(String[] details) {
        int res = 0;
        for (String s : details) {
            if (Integer.parseInt(s.substring(11, 13)) > 60) {
                res++;
            }
        }
        return res;
    }
}
