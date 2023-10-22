package 常用算法.图.并查集;

/**
 * @Author zal
 * @Date 2023/10/21 19:08
 * @Description TODO 并查集模版
 * @Version 1.0
 * 思路：
 * 并查集主要用于处理一些不交集的【合并】以及【查询】的问题，它支持两种操作：
 * 1. 查找find：确定某个元素处于哪个子集中
 * 2. 合并union：将两个子集合并成一个集合
 * 并查集的实现一般基于数组，每个元素指向的元素就是自己的父节点，初始时每个元素指向自己，这样就
 * 形成了一个以自己为根节点的树，树的高度就是元素的个数。
 * 并查集的查找操作就是沿着树不断向上找父节点，直到找到根节点为止，而合并操作就是将两个子集
 * 的根节点指向同一个父节点，这样两个子集就合成了一个集合。
 */
public class Main {

    /**
     * 存储每个元素的根节点
     */
    static int[] parent;

    /**
     * 联通分量的个数
     */
    static int count;

    /**
     * 元素所在联通分量的长度
     */
    static int[] len;

    /**
     * 初始化
     *
     * @param n 元素个数
     */
    public static void init(int n) {
        parent = new int[n];
        len = new int[n];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            len[i] = 1;
        }
    }

    /**
     * find 查找x所在集合的根元素
     *
     * @param x 查找的元素
     * @return 所在集合的根元素
     */
    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    /**
     * union 合并两个联通分量
     *
     * @param p p元素
     * @param q q元素
     */
    public static void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        parent[rootQ] = rootP;
        // 联通分量长度增加
        len[rootP] += len[rootQ];
        // 两个联通分量合并成一个联通分量
        count--;
    }


    /*  下面是一些其他的用法   */

    /**
     * 判断p和q是否连通
     *
     * @param p p元素
     * @param q q元素
     * @return 是否连通
     */
    public static boolean connnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 返回连通分量的个数
     *
     * @return 连通分量的个数
     */
    public static int count() {
        return count;
    }

    /**
     * 返回图中连通分量的最长长度
     *
     * @return 图中连通分量的最长长度
     */
    public static int maxConnectionSize() {
        int maxSize = 0;
        for (int i = 0; i < parent.length; i++) {
            if (i == parent[i]) {
                maxSize = Math.max(maxSize, len[i]);
            }
        }
        return maxSize;
    }
}
