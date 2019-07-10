package etc;

import java.util.PriorityQueue;
import java.util.UUID;

// 생성할땐 one thread
// 소비할땐 multi thread
public class PriorityQueueExample {
    public static void main(String[] agrs) {
        Node node1 = new Node(3d, 3d);
        Node node2 = new Node(5d, 7d);
        Node node3 = new Node(1d, 8d);
        Node node4 = new Node(8d, 12d);

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(node1);
        priorityQueue.add(node2);
        priorityQueue.add(node3);
        priorityQueue.add(node4);

        Node removeNode = priorityQueue.remove();
        System.out.println(removeNode);
    }
}

class Node implements Comparable<Node> {
    private String UUID;
    private String parentUUID;
    private double G;
    private double H;

    @Override
    public String toString() {
        return "Node{" +
                "UUID='" + UUID + '\'' +
                ", parentUUID='" + parentUUID + '\'' +
                ", G=" + G +
                ", H=" + H +
                '}';
    }

    public Node(double g, double h) {
        this.UUID = java.util.UUID.randomUUID().toString();
        this.parentUUID = null;
        G = g;
        H = h;
    }

    public double getF() {
        return G + H;
    }

    public double getG() {
        return G;
    }

    public String getParentUUID() {
        return parentUUID;
    }

    public double getH() {
        return H;
    }

    public void setG(double g) {
        G = g;
    }

    public void setParentUUID(String parentUUID) {
        this.parentUUID = parentUUID;
    }

    public void setH(double h) {
        H = h;
    }

    @Override
    public int compareTo(Node target) {
        if(this.getF() > target.getF()){
            return 1;
        }else if(this.getF() < target.getF()){
            return -11;
        }

        return 0;
    }
}