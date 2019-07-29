package datastructure;

/**
 * [enqueue][index(0)] : 1
 * [enqueue][index(1)] : 2
 * [enqueue][index(2)] : 3
 * [increment] size : 4
 * [enqueue][index(3)] : 5
 * [dequeue][index(4)] : 1
 * [dequeue][index(3)] : 2
 * [dequeue][index(2)] : 3
 */
public class Queue {
    private int[] queue;
    private int currentIndex = 0;

    public Queue(int capacity) {
        this.queue = new int[capacity];
    }

    public void enqueue(int data) {
        if (queue.length <= currentIndex) {
            incrementSize();
        }

        System.out.println("[enqueue][index(" + currentIndex + ")] : " + data);
        queue[currentIndex++] = data;
    }

    public int dequeue() {
        int data = this.queue[0];
        moveData();
        System.out.println("[dequeue][index(" + currentIndex + ")] : " + data);
        currentIndex--;

        return data;
    }

    // 데이터를 한칸씩 앞으로 당긴다.
    private void moveData() {
        for (int i = 0; i < queue.length - 1; i++) {
            this.queue[i] = this.queue[i + 1];
        }
    }

    // capacity 1/2 UP!
    private void incrementSize() {
        int[] increment = new int[queue.length + (queue.length / 2)];
        for (int i = 0; i < queue.length; i++) {
            increment[i] = queue[i];
        }

        this.queue = increment;
        System.out.println("[increment] size : " + increment.length);
    }

    private int peek() {
        return this.queue[0];
    }

    private boolean isEmpty() {
        return currentIndex == 0;
    }

    public static void main(String[] args) {
        Queue queue = new Queue(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(5);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
    }
}
