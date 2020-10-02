package linked_list;

import java.util.HashMap;
import java.util.LinkedHashMap;

// Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
//
//Implement the LRUCache class:
//
//LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
//int get(int key) Return the value of the key if the key exists, otherwise return -1.
//void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache.
// If the number of keys exceeds the capacity from this operation, evict the least recently used key.
public class GLRUCache {

    // Approach 1 : uses LinkedHashMap provided by Java.
    // This solves the problem and makes it super easy to implement LRU cache.
    // We will discuss the manual, painful approach next.
    // This is not thread-safe. use Collections.synchronizedMap() to make it synchronous.
    class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        public boolean remove(Object key, Object value) {
            return size() > capacity;
        }
    }

    // Approach 2 : Using doubly-linkedlist and hashmap
    class LRUCacheDetailed {
        private int capacity;
        private int size;
        HashMap<Integer, ListNode> cache;
        ListNode headOfDLL, tailOfDLL;

        class ListNode {
            int data;
            int key;
            ListNode prev;
            ListNode next;
        }

        LRUCacheDetailed(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>();
            this.headOfDLL = new ListNode();
            this.tailOfDLL = new ListNode();
        }

        private void removeNode(ListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void addNode(ListNode node) {
            node.prev = headOfDLL;
            node.next = headOfDLL.next;

            headOfDLL.next.prev = node;
            headOfDLL.next = node;
        }

        private void addToFront(ListNode node) {
            removeNode(node);
            addNode(node);
        }

        private ListNode popTail() {
            ListNode res = tailOfDLL.prev;
            removeNode(res);
            return res;
        }

        public int get(int key) {
            ListNode node = cache.getOrDefault(key, null);
            if (node == null) {
                return -1;
            }
            addToFront(node);
            return node.data;
        }

        public void put(int key, int value) {
            ListNode node = cache.getOrDefault(key, null);
            if (node != null) {
                node.data = value;
                cache.put(key, node);
                addToFront(node);
            } else {
                node = new ListNode();
                node.key = key;
                node.data = value;
                cache.put(key, node);
                addNode(node);
                ++size;

                if (size > capacity) {
                    ListNode tail = popTail();
                    cache.remove(tail.key);
                    --size;
                }
            }
        }

    }

}
