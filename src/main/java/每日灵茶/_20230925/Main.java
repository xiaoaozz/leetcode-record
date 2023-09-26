package 每日灵茶._20230925;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author zal
 * @Date 2023/9/26 10:01
 * @Description https://atcoder.jp/contests/abc138/tasks/abc138_d (补题)
 * @Version 1.0
 * 输入 n(2≤n≤2e5) q(1≤q≤2e5) 表示一个 n 个点的树（节点编号从 1 开始，根节点为 1）。
 * 然后输入 n-1 条边（每行两个数）。
 * 然后输入 q 个操作，每个操作输入 p(1≤p≤n) x(1≤x≤1e4)，表示把子树 p 内的所有节点值都加 x。（一开始所有节点值均为 0）
 * 输出最终每个节点的节点值。（按节点编号从小到大输出）
 * <p>
 * 输入
 * 4 3
 * 1 2
 * 2 3
 * 2 4
 * 2 10
 * 1 100
 * 3 1
 * 输出 100 110 111 110
 * <p>
 * 输入
 * 6 2
 * 1 2
 * 1 3
 * 2 4
 * 3 6
 * 2 5
 * 1 10
 * 1 10
 * 输出 20 20 20 20 20 20
 * <p>
 * 思路：
 * 先使用一个List<TreeNode>来存储所有的子树，然后使用a数组来存储每个编号的子树要增加的值
 * 使用一次dfs从根节点开始，对每个节点所在的子树进行对应值的增加
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        run(in, out);

        out.flush();
    }

    static class TreeNode {
        // 值，初始的时候可以当成编号
        int val;
        List<TreeNode> children;

        TreeNode(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    public static void run(BufferedReader in, BufferedWriter out) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int q = Integer.parseInt(tokenizer.nextToken());

        List<TreeNode> nodes = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            nodes.add(new TreeNode(i));
        }

        for (int i = 1; i < n; i++) {
            tokenizer = new StringTokenizer(in.readLine());
            int v = Integer.parseInt(tokenizer.nextToken());
            int w = Integer.parseInt(tokenizer.nextToken());
            // 将树节点之间连接
            nodes.get(v).children.add(nodes.get(w));
            nodes.get(w).children.add(nodes.get(v));
        }

        int[] a = new int[n + 1];
        for (int i = 0; i < q; i++) {
            tokenizer = new StringTokenizer(in.readLine());
            int p = Integer.parseInt(tokenizer.nextToken());
            int x = Integer.parseInt(tokenizer.nextToken());
            // 保存每个根节点的子树要增加的值
            a[p] += x;
        }

        dfs(nodes.get(1), null, a);

        for (int i = 1; i <= n; i++) {
            out.write(a[i] + " ");
        }
    }

    /**
     * dfs，对于每个给定节点为根节点的子树，遍历，增加对应的根节点的值
     *
     * @param node   根节点
     * @param parent 父节点
     * @param a      增加值的数组
     */
    public static void dfs(TreeNode node, TreeNode parent, int[] a) {
        for (TreeNode child : node.children) {
            if (child != parent) {
                a[child.val] += a[node.val];
                dfs(child, node, a);
            }
        }
    }
}

