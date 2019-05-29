package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RouteBetweenNodes {

    public static void main(String[] args){
        ArrayList[] graph = new ArrayList[6];

        // add connections
        graph[0] = new ArrayList<>();
        graph[0].add(1)


        graph[1] = new ArrayList<>();
        graph[1].add(2);


        //graph[2] = new ArrayList<>();
        //graph[2].add(3);


        graph[3] = new ArrayList<>();
        graph[3].add(4);


        graph[4] = new ArrayList<>();
        graph[4].add(5);

        System.out.println(isRouteExist(1, 5, graph));
    }

    private static boolean isRouteExist(int node1, int node2, List<Integer>[] graph){
        // 입력된 노드가 범위를 벗어난다면 실패
        if (node1 >= graph.length || node2 >= graph.length) return false;

        // DFS
        Stack<Integer> stack = new Stack<>();
        stack.add(node1); // 시작노드를 담는다

        // 방문을 체크하기위해 확보한다.
        boolean visited[] = new boolean[graph.length];

        while (stack.isEmpty() == false) {
            int idx = stack.pop();
            visited[idx] = true;
            if (graph[idx] != null) {
                for (int node : graph[idx]) {
                    if (visited[node]) continue;

                    if (node2 == node) return true;

                    stack.add(node);
                }
            }
        }

        return false;
    }
}
