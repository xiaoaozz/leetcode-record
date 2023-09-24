package 每日一题._20230924;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zal
 * @Date 2023/9/24 22:27
 * @Description 146. LRU 缓存 https://leetcode.cn/problems/lru-cache/
 * @Version 1.0
 * @Tag 数据结构、双向链表、哈希表
 */
public class LRUCache {

    /**
     * 描述功能的节点
     */
    static class ListNode {
        // key和value分别表示节点的键值
        int key, value;
        // pre和next分别表示前继节点和后续节点
        ListNode pre, next;

        public ListNode() {
        }

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 最大容量
     */
    int capacity;
    /**
     * 描述关系的map集合
     */
    Map<Integer, ListNode> map;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        // 初始化
        this.capacity = capacity;
        map = new HashMap<>();
        // 虚拟头节点
        head = new ListNode(-1, -1);
        // 虚拟尾节点
        tail = new ListNode(-1, -1);
        // 首尾相连
        head.next = tail;
        tail.pre = head;
    }

    /**
     * 获取节点的方法
     *
     * @param key 想要获取的节点的key
     * @return value 对应节点的值
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            // 如果map中存在该key对应的节点，则获取节点后将该节点移动到最后，表示最新使用的
            ListNode node = map.get(key);
            moveToTail(node);
            return node.value;
        }
        // 否则返回-1
        return -1;
    }

    /**
     * 添加节点
     *
     * @param key   添加节点的key
     * @param value 添加节点的value
     */
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // 如果map中有该值，则更新节点的值，并将该节点移到最后
            ListNode node = map.get(key);
            node.value = value;
            moveToTail(node);
            return;
        }
        if (map.size() == capacity) {
            // 如果超出容量，则移除最后一个节点
            map.remove(head.next.key);
            removeListNode(head.next);
        }
        // 将新的节点加入到链表的最后，表示最新使用
        ListNode node = new ListNode(key, value);
        addToTail(node);
        map.put(key, node);
    }

    /**
     * 移除节点
     *
     * @param node 要移除的节点
     */
    public void removeListNode(ListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    /**
     * 将节点添加到尾部
     *
     * @param node 需要移动的节点
     */
    public void addToTail(ListNode node) {
        // node的前一个节点指向tail的前一个节点
        node.pre = tail.pre;
        // node的前一个节点的后一个节点指向node
        node.pre.next = node;
        // node的后一个节点指向tail
        node.next = tail;
        // tail的前一个节点指向node
        tail.pre = node;
    }

    /**
     * 移除节点并且添加到尾部
     *
     * @param node 需要移动的节点
     */
    public void moveToTail(ListNode node) {
        removeListNode(node);
        addToTail(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
