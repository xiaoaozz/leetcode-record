package 每日灵茶._20230927;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @Author zal
 * @Date 2023/9/27 09:44
 * @Description https://atcoder.jp/contests/abc098/tasks/arc098_b
 * @Version 1.0
 * @Tag 位运算、枚举、滑动窗口
 * <p>
 * 输入 n(1≤n≤2e5) 和长为 n 的数组 a(0≤a[i]<2^20)。
 * a 有多少个非空连续子数组，满足元素和等于元素异或和？
 * <p>
 * 输入
 * 4
 * 2 5 4 6
 * 输出 5
 * <p>
 * 输入
 * 9
 * 0 0 0 0 0 0 0 0 0
 * 输出 45
 * <p>
 * 输入
 * 19
 * 885 8 1 128 83 32 256 206 639 16 4 128 689 32 8 64 885 969 1
 * 输出 37
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // 注意，题目范围是 a[i]<=2^20，但是计算过程中会爆int
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[] a = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }
        long res = 0, or = 0;
        for (int l = 0, r = 0; r < n; r++) {
            while ((or & a[r]) > 0) {
                // 如果&大于0，说明不符合，移除，窗口右移
                or ^= a[l];
                l++;
            }
            // 将当前元素加入子数组
            or |= a[r];
            // 更新子数组个数
            res += r - l + 1;
        }
        out.write(res + "");
        out.flush();
    }

    /**
     * lc2401.优雅子数组的个数，暴力枚举，本题数据范围超时
     *
     * @param nums
     * @return
     */
    public static int niceSubarrayNumberByEnum(int[] nums) {
        // ^ 相同为0，不同为1
        // 子数组的任意一位二进制数位上不能都是1 => 任意两个数的按位与为0
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int or = 0, j = i;
            while (j >= 0 && (nums[j] & or) == 0) {
                or |= nums[j--];
                res++;
            }
        }
        return res;
    }
}
