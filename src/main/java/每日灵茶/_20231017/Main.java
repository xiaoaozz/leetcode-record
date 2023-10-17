package 每日灵茶._20231017;

import java.util.Scanner;

/**
 * @Author zal
 * @Date 2023/10/17 10:47
 * @Description https://codeforces.com/problemset/problem/1765/N  --- 未提交验证
 * @Version 1.0
 * @Tag 栈
 * <p>
 * 输入 T(≤1e5) 表示 T 组数据。所有字符串长度之和 ≤5e5。
 * 每组数据输入一个长度 ≤5e5 的数字字符串 s，和 k(1≤k<len(s))。
 * 你需要删除 s 中的恰好 k 个字符，使得剩余字符的字典序最小，是没有前导零的正数。
 * <p>
 * 输入
 * 5
 * 10000
 * 4
 * 1337
 * 0
 * 987654321
 * 6
 * 66837494128
 * 5
 * 7808652
 * 3
 * 输出
 * 1
 * 1337
 * 321
 * 344128
 * 7052
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            sc.nextLine();
            int k = sc.nextInt();
            String res = removeKdigits(s, k);
            System.out.println(res);
        }
    }

    public static String removeKdigits(String num, int k) {
        int j = 0;
        for (int i = 0; i < k + 1; i++) {
            // 找到k+1中的最小的非0字符
            if (num.charAt(i) > '0' && num.charAt(i) < num.charAt(j)) {
                j = i;
            }
        }
        // 删除j左边的所有字符
        k -= j;
        StringBuilder sb = new StringBuilder(num.charAt(j));
        for (int i = j + 1; i < num.length(); i++) {
            while (sb.length() > 1 && k > 0 && num.charAt(i) < sb.charAt(sb.length() - 1)) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(num.charAt(i));
        }
        sb.delete(sb.length() - k, sb.length());
        return sb.toString();
    }
}
