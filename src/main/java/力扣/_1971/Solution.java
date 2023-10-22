package 力扣._1971;

/**
 * @Author zal
 * @Date 2023/10/21 19:31
 * @Description TODO 1971. 寻找图中是否存在路径 https://leetcode.cn/problems/find-if-path-exists-in-graph/
 * @Version 1.0
 * @Tag 并查集
 */
public class Solution {
    private int[] parent;

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootQ] = rootP;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] e : edges) {
            union(e[0], e[1]);
        }
        return find(source) == find(destination);
    }

}
