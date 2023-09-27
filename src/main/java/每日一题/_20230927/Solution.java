package 每日一题._20230927;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author zal
 * @Date 2023/9/27 14:33
 * @Description lc1333.餐厅过滤器 https://leetcode.cn/problems/filter-restaurants-by-vegan-friendly-price-and-distance
 * @Version 1.0
 * @Tag 排序、模拟
 * 思路：Java的面向对象思想，以及自定义排序，过滤可以使用Stream流
 */
public class Solution {

    /**
     * 极致Stream流
     *
     * @param restaurants
     * @param veganFriendly
     * @param maxPrice
     * @param maxDistance
     * @return
     */
    public List<Integer> filterRestaurantsByStream(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Arrays.stream(restaurants)
                .filter(restaurant -> restaurant[3] <= maxPrice && restaurant[4] <= maxDistance)
                .filter(restaurant -> veganFriendly == 0 || restaurant[2] == 1)
                .sorted((a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1])
                .map(restaurant -> restaurant[0])
                .collect(Collectors.toList());
    }


    /**
     * Java面向对象思想+自定义排序
     *
     * @param restaurants
     * @param veganFriendly
     * @param maxPrice
     * @param maxDistance
     * @return
     */
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<R> list = new ArrayList<>();
        for (int[] r : restaurants) {
            R re = new R(r[0], r[1], r[2], r[3], r[4]);
            list.add(re);
        }
        list.sort((a, b) -> {
            if (a.rating == b.rating) {
                return b.id - a.id;
            } else {
                return b.rating - a.rating;
            }
        });
        return veganFriendly == 0 ?
                list.stream()
                        .filter(r -> r.price <= maxPrice)
                        .filter(r -> r.dis <= maxDistance)
                        .map(r -> r.id)
                        .collect(Collectors.toList()) :
                list.stream()
                        .filter(r -> r.price <= maxPrice)
                        .filter(r -> r.dis <= maxDistance)
                        .filter(r -> r.v == veganFriendly)
                        .map(r -> r.id)
                        .collect(Collectors.toList());
    }

    class R {
        int id;
        int rating;
        int v;
        int price;
        int dis;

        public R(int id, int rating, int v, int price, int dis) {
            this.id = id;
            this.rating = rating;
            this.v = v;
            this.price = price;
            this.dis = dis;
        }
    }
}
