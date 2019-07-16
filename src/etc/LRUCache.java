package etc;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/lru-cache-implementation/
 * https://github.com/PengFTang/Algorithms-in-Java/blob/master/Hashing/LRUCache.java
 */
public class LRUCache {
    class ListNode {
        int key;
        int val;
        ListNode prev, next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    ListNode head, tail;
    Map<Integer, ListNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        ListNode node = map.getOrDefault(key, head); // 매핑된 값이 없다면 기본값을 준다.
        if (map.containsKey(key)) {
            // todo move to head
            return map.get(key).val;
        }

        return -1;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            // update
            ListNode node = map.get(key);
            node.val = val;

            node.prev = null;
            node.next = head.next;

            head = node;

            map.put(key, node);
        } else {
            // insert
            ListNode node = new ListNode(key, val);
            map.put(key, node);
            setHead(node);

            if(map.size() > capacity){
                map.remove(tail.key);

                // tail을 보정해준다.
                tail.prev.next = null;
                tail = tail.prev;
            }
        }
    }

    // HEAD의 위치를 조정해준다.
    private void setHead(ListNode node){
        node.next = head;
        node.prev = null;

        if(head != null)
            head.prev = node;

        head = node;

        if(tail == null){
            tail = head;
        }
    }

    public void print(ListNode node) {
        if (node == null) {
            System.out.println("");
            return;
        }

        System.out.print(node.val + " ->");
        print(node.next);
    }


    public static void main(String[] args) {
        int capacity = 2;
        LRUCache lruCache = new LRUCache(capacity);

        lruCache.put(1, 3);
        lruCache.print(lruCache.head);
        lruCache.put(2, 5);
        lruCache.print(lruCache.head);
        lruCache.put(3, 7);
        lruCache.print(lruCache.head);
        lruCache.put(4, 9);
        lruCache.print(lruCache.head);
        lruCache.put(5, 11);
        lruCache.print(lruCache.head);

        lruCache.put(4, 15);
        lruCache.print(lruCache.head);
    }
}
