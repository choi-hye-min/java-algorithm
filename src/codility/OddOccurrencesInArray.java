package codility;

import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
        oddOccurrencesInArray.solution(new int[]{9, 3, 9, 3, 9, 7, 9});
    }

    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            if (set.contains(a) == false) {
                set.add(a);
            } else {
                set.remove(a);
            }
        }

        return (int) set.toArray()[0];
    }
}
