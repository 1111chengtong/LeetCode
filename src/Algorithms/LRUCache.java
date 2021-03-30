package Algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * Follow up:
 * Could you do get and put in O(1) time complexity?
 *
 *  
 *
 * Example 1:
 *
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 *  
 *
 * Constraints:
 *
 * 1 <= capacity <= 3000
 * 0 <= key <= 3000
 * 0 <= value <= 104
 * At most 3 * 104 calls will be made to get and put.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LRUCache {

    private DoubleLinkedList list;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        list = new DoubleLinkedList(capacity);
        map = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        list.remove(node);
        list.addLast(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            list.remove(node);
            list.addLast(node);
        } else {
            if (list.size() >=list.getCapacity()) {
                Node node = list.removeFirst();
                map.remove(node.key);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            list.addLast(newNode);
        }
    }

    public static class Node {
        public int key;
        public int value;
        public Node prev;
        public Node next;

        public Node() {
            this.key = 0;
            this.value = 0;
            this.prev = null;
            this.next = null;
        }
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    public static class DoubleLinkedList {
        private Node head;
        private Node tail;
        private int size;
        private int capacity;

        public DoubleLinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
            this.capacity = 3000;
        }

        public DoubleLinkedList(int capacity) {
            this.head = null;
            this.tail = null;
            this.size = 0;
            this.capacity = capacity;
        }

        public int size() {
            return this.size;
        }
        public int getCapacity() {
            return capacity;
        }

        public Node addLast(Node node) {
            if (tail == null) {
                head = tail = node;
                size++;
                return tail;
            }
            tail.next = node;
            node.prev = tail;
            tail = node;
            tail.next = null;
            size++;
            return tail;
        }
        public Node removeFirst() {
            if (size == 0) {
                return null;
            }
            if (size == 1) {
                Node node = head;
                head = tail = null;
                size--;
                return node;
            }
            Node node = head;
            head = head.next;
            head.prev = null;
            size--;
            return node;
        }
        public Node removeLast() {
            if (size == 0) {
                return null;
            }
            if (size == 1) {
                Node node = head;
                head = tail = null;
                size--;
                return node;
            }
            Node node = tail;
            tail = tail.prev;
            tail.next = null;
            size--;
            return node;
        }
        public Node remove(Node node) {
            if (node == head) {
                return removeFirst();
            }
            if (node == tail) {
                return removeLast();
            }
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
            return node;
        }
    }
}
