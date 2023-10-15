package 周赛._367场周赛;

/**
 * @Author zal
 * @Date 2023/10/15 14:44
 * @Description 100084. 最短且字典序最小的美丽子字符串 https://leetcode.cn/problems/shortest-and-lexicographically-smallest-beautiful-string/
 * @Version 1.0
 * @Tag 暴力、滑动窗口
 * 思路：
 * 这道题是一道普通的字符串题，题意为找出字符串中1的个数为k，并且len最短且字典序最小的子串。
 * 第一思路是滑动窗口，但还有人直接暴力做，看数据范围吧
 */
public class Solution_02 {

    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int left = 0;
        int countOnes = 0;
        int minLen = n;
        String result = "";
        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                countOnes++;
            }
            while (countOnes > k) {
                if (s.charAt(left) == '1') {
                    countOnes--;
                }
                left++;
            }
            if (countOnes == k) {
                // 如果第一个字符不是0，则去除掉，保证第一个字符是从1开始，这样len会最小
                while (s.charAt(left) == '0' && left < right) {
                    left++;
                }
                if (right - left + 1 <= minLen) {
                    minLen = right - left + 1;
                    String substring = s.substring(left, right + 1);
                    // 这里会有坑，字典序小的len不一定最小，因为这里wa了一次
                    if ("".equals(result) || substring.length() < result.length()) {
                        result = substring;
                    } else {
                        result = substring.compareTo(result) <= 0 ? substring : result;
                    }
                }
            }
        }
        return result;
    }
}
