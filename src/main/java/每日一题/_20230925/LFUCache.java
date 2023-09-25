package 每日一题._20230925;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zal
 * @Date 2023/9/25 21:07
 * @Description lc460.LFU缓存 https://leetcode.cn/problems/lfu-cache
 * @Version 1.0
 * @Tag 数据结构、双向链表、哈希表
 */
class LFUCache {
    /**
     * 用于存储缓存的键值对，key对应node
     */
    private final Map<Integer, Node> map;
    /**
     * 用于存储使用频率相同的缓存节点的双向链表，freq对应到双向链表list
     */
    private final Map<Integer, DoublyLinkedList> freqMap;
    /**
     * 容量
     */
    private final int capacity;
    /**
     * 当前最小的使用频率
     */
    private int minFreq;


    /**
     * 初始化
     *
     * @param capacity 初始容量
     */
    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        freqMap = new HashMap<>();
    }


    /**
     * get节点
     *
     * @param key 获取节点的key
     * @return value 要获取节点的value
     */
    public int get(int key) {
        // 如果capacity为0，直接返回-1
        if (capacity == 0) {
            return -1;
        }
        // 如果map中不存在该key，直接返回-1
        if (!map.containsKey(key)) {
            return -1;
        }
        // 获取node，使用次数+1，返回value
        Node node = map.get(key);
        incrFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            incrFreq(node);
            return;
        }
        if (map.size() == capacity) {
            DoublyLinkedList list = freqMap.get(minFreq);
            map.remove(list.removeLast().key);
        }
        Node node = new Node(key, value);
        addNode(node);
        map.put(key, node);
        minFreq = 1;
    }

    /**
     * 增加node的使用次数
     *
     * @param node 要增加使用次数的节点
     */
    private void incrFreq(Node node) {
        // 根据使用频率获取对应的双向链表
        int freq = node.freq;
        DoublyLinkedList list = freqMap.get(freq);
        // 在当前链表中移除该节点
        list.remove(node);
        if (list.isEmpty()) {
            // 如果链表为空，则从freqMap中移除该频率的记录
            freqMap.remove(freq);
            if (freq == minFreq) {
                // 如果使用freq == minFreq，则最小频率+1
                minFreq++;
            }
        }
        node.freq++;
        addNode(node);
    }

    /**
     * 添加节点到对应的双向链表中
     *
     * @param node 要添加的节点
     */
    private void addNode(Node node) {
        int freq = node.freq;
        DoublyLinkedList list = freqMap.getOrDefault(freq, new DoublyLinkedList());
        list.addFirst(node);
        freqMap.put(freq, list);
    }

    /**
     * 节点
     */
    private static class Node {
        int key;
        int value;
        int freq;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    /**
     * 双向链表
     */
    private static class DoublyLinkedList {

        private final Node head;
        private final Node tail;

        public DoublyLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public void addFirst(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        public Node remove(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.next = null;
            node.prev = null;
            return node;
        }

        public Node removeLast() {
            return remove(tail.prev);
        }

        public boolean isEmpty() {
            return head.next == tail;
        }
    }
}
