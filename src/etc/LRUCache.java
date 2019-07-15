package etc;

import java.util.HashMap;
import java.util.Map;

/**
 * https://github.com/PengFTang/Algorithms-in-Java/blob/master/Hashing/LRUCache.java
 */
public class LRUCache {
    class ListNode{
        int val;
        ListNode prev, next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    int size = 0;
    int capacity;
    ListNode head, tail;
    Map<Integer, ListNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new ListNode(-1);
        this.tail = new ListNode(-1);

        head.prev = head;
        head.next = tail;
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key){
        ListNode node = map.getOrDefault(key, head); // 매핑된 값이 없다면 기본값을 준다.
        if(node.val == -1) moveToHead(node);

        return node.val;
    }

    private void moveToHead(ListNode node) {
        if(node == head || node.prev == head){
            System.out.println("head: "+head.val);
            return;
        }
    }

    public static void main(String[] args){
        int capacity = 2;
        LRUCache lruCache = new LRUCache(capacity);
        lruCache.get(3);
    }
}
