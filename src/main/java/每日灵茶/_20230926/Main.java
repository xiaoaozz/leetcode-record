package 每日灵茶._20230926;


/**
 * @Author zal
 * @Date 2023/9/26 14:23
 * @Description https://atcoder.jp/contests/abc202/tasks/abc202_d
 * @Version 1.0
 * <p>
 * 输入 A B(1≤A,B≤30) K。
 * 在所有由恰好 A 个 'a' 和恰好 B 个 'b' 组成的字符串中，输出字典序第 K 小的字符串。
 * 例如 K=1 表示字典序最小的字符串。
 * K 的范围保证有解。
 * <p>
 * 输入 2 2 4
 * 输出 baab
 * <p>
 * 输入 30 30 118264581564861424
 * 输出 bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbaaaaaaaaaaaaaaaaaaaaaa
 * <p>
 * 思路：推测第一位是a还是b，
 * 如果是a，k会小于C(n, a-1)，
 * 如果是b，k会大于C(n, b)
 * <p>
 * <p>
 * 递推计算组合数 C[i][j] = C[i-1][j-1] + C[i-1][j]
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        long k = sc.nextLong();
        // 知识点：递推求组合数
        int max = a + b + 1;
        long[][] C = new long[max][max];
        for (int i = 0; i < max; i++) {
            C[i][0] = 1L;
            C[i][i] = 1L;
            for (int j = 1; j < i; j++) {
                C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }
        char[] res = new char[a + b];
        Arrays.fill(res, 'a');
        for (int i = 0; i < res.length; i++) {
            if (k > C[a + b - 1][b]) {
                // 判断第一位是否是b，如果是，则减去k
                k -= C[a + b - 1][b];
                res[i] = 'b';
                b--;
            } else {
                // 否则就是a
                a--;
            }
        }
        System.out.println(new String(res));
    }
}
