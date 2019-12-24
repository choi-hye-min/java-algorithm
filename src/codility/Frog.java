package codility;

import java.util.HashSet;
import java.util.Set;

public class Frog {
    public static void main(String[] args) {
        Frog frog = new Frog();
        System.out.println(frog.solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4})); // 6
        System.out.println(frog.solution(2, new int[]{2, 2, 2, 2, 2})); // -1
        System.out.println(frog.solution(3, new int[]{1, 3, 1, 3, 2, 1, 3})); // 4
        System.out.println(frog.solution(1, new int[]{1})); // 0
    }

    public int solution(int X, int[] A) {
        Set<Integer> set = new HashSet<>();
        int time = -1;
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);

            if (set.size() == X) {
                time = i;
                break;
            }
        }

        return time;
    }
}
