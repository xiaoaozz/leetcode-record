package 每日灵茶._20231009;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author zal
 * @Date 2023/10/9 21:02
 * @Description https://atcoder.jp/contests/abc321/tasks/abc321_d
 * @Version 1.0
 * <p>
 * 输入 n m(1≤n,m≤2e5) p(1≤p≤2e8)，和长度分别为 n 和 m 的数组 a 和 b，元素范围 [1,1e8]。
 * 输出如下程序打印的值：
 * sum = 0
 * for x in a:
 *  for y in b:
 *      sum += min(x + y, p)
 * print(sum)
 * @Tag 排序 + 指针
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        long sum = 0L, sumB = 0L;
        int j = 0;
        for (int i = n - 1; i >= 0; i--) {
            // 维护一个指针j，a[i] + b[j] >= p，此时i为[0, n - 1]
            while (j < m && a[i] + b[j] < p) {
                sumB += b[j];
                j++;
            }
            // 对于b[0]到b[j-1]，此时a[i] + b[x] < p，所以sum += a[i] * j + b[0] + ... + b[j - 1]
            // 对于b[j]到b[m-1]，此时a[i] + b[x] >= p，所以sum += p * (m - j)
            sum += (long) a[i] * j + sumB + (long) p * (m - j);
        }
        System.out.println(sum);
    }
}
