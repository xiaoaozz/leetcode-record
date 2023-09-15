package 每日一题._20230914;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zal
 * @Date 2023/9/15 12:26
 * @Description lc1222.可以攻击国王的皇后 https://leetcode.cn/problems/queens-that-can-attack-the-king
 * @Version 1.0
 * @Tag 模拟
 * 思路：
 * 题目要求，必须与国王在同一行、同一列、同一斜线的皇后才能攻击到国王，而且被挡住的皇后不能攻击国王
 * 所以，我们可以以国王为中心点，向周围八个方向进行模拟遍历，遇到符合条件的皇后，就将其坐标加入结果
 * 直到不满足边界条件为止。
 */
class Solution {
    /**
     * 下、右下、右、右上、上、左上、左、左下
     */
    public static final int[][] DIRECTIONS = {
            {1, 0}, {1, 1}, {0, 1}, {-1, 1},
            {-1, 0}, {-1, -1}, {0, -1}, {1, -1}
    };

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        // 模拟8*8的棋盘
        boolean[][] isQueue = new boolean[8][8];
        // 将皇后的位置全部置为true，后续遍历到直接将坐标加入到结果集中
        for (int[] q : queens) {
            isQueue[q[0]][q[1]] = true;
        }
        List<List<Integer>> res = new ArrayList<>();
        // 遍历不同方向的点
        for (int[] d : DIRECTIONS) {
            int x = king[0] + d[0];
            int y = king[1] + d[1];
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                // 如果符合条件，则加入结果集，并且结束当前方向的遍历
                if (isQueue[x][y]) {
                    res.add(Arrays.asList(x, y));
                    break;
                }
                // 更新中心点
                x += d[0];
                y += d[1];
            }
        }
        return res;
    }
}
