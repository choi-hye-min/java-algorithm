package etc;

import java.util.HashMap;
import java.util.Map;

// https://jins-dev.tistory.com/entry/LRU-Cache-Algorithm-정리
public class LRUCacheImpl {
    private class ListNode {
        private int key;
        private int val;
        private ListNode prev;
        private ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    private Map<Integer, ListNode> nodeMap;
    private int capacity;
    private ListNode head;
    private ListNode tail;

    public LRUCacheImpl(int capacity) {
        this.nodeMap = new HashMap<>();
        this.capacity = capacity;

        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    private void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        nodeMap.remove(node.key);
    }

    private void insertToHead(ListNode node) {
        this.head.next.prev = node;
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next = node;
        nodeMap.put(node.key, node);
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        }
        ListNode node = nodeMap.get(key);
        remove(node);
        insertToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        ListNode newNode = new ListNode(key, value);
        if (nodeMap.containsKey(key)) {
            ListNode oldNode = nodeMap.get(key);
            remove(oldNode);
        } else {
            if (nodeMap.size() >= capacity) {
                ListNode tailNode = tail.prev;
                remove(tailNode);
            }
        }
        insertToHead(newNode);
    }

    public void print(){
        ListNode node = head;

        while(true){
            if(node == null) break;

            System.out.print("[key:"+node.key+" val:"+node.val+"] -> ");
            node = node.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        LRUCacheImpl cache = new LRUCacheImpl(2);
        cache.put(1, 1);
        cache.print();
        cache.put(2, 2);
        cache.print();
        cache.put(3, 3);
        cache.print();
        cache.put(2, 5);
        cache.print();
    }
}

