package 每日一题._20231021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zal
 * @Date 2023/10/21 15:37
 * @Description TODO 2316. 统计无向图中无法互相到达点对数 https://leetcode.cn/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph
 * @Version 1.0
 * @Tag DFS、并查集
 */
public class Solution {
    private List<Integer>[] g;
    private boolean[] vis;

    public long countPairs(int n, int[][] edges) {
        g = new List[n];
        vis = new boolean[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        long ans = 0, s = 0;
        for (int i = 0; i < n; i++) {
            int t = dfs(i);
            ans += s * t;
            s += t;
            System.out.println(s);
        }
        return ans;
    }

    /**
     * 获取联通分块内元素的个数
     *
     * @param i
     * @return
     */
    public int dfs(int i) {
        if (vis[i]) {
            return 0;
        }
        vis[i] = true;
        int cnt = 1;
        for (int j : g[i]) {
            cnt += dfs(j);
        }
        return cnt;
    }
}
