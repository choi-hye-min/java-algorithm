package datastructure;

/**
 * https://opentutorials.org/module/1335/8857
 */
public class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    private class Node {
        private Object data;
        private Node next;

        public Node(Object input) {
            this.data = input;
            this.next = null;
        }

        @Override
        public String toString() {
            return String.valueOf(this.data);
        }
    }

    // 시작에 데이터 추가
    public void addFirst(Object input) {
        Node newNode = new Node(input);

        newNode.next = head;
        head = newNode;

        size++;

        if (newNode.next == null) {
            tail = head;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        Node node = head;
        for (int i = 0; i < size; i++) {
            stringBuilder.append(node).append("\n");
            node = node.next;
        }

        return stringBuilder.toString();
    }

    // 중간에 추가
    // 마지막에 추가

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.addFirst(32);
        linkedList.addFirst(27);
        linkedList.addFirst(109);

        System.out.println(linkedList.toString());
    }
}
