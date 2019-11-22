package codility;

import java.util.stream.IntStream;

public class PermMissingElem {
    public static void main(String[] args) {
        PermMissingElem permMissingElem = new PermMissingElem();

        int solution = permMissingElem.solution(new int[]{2, 3, 1, 5});
        System.out.println(solution);
    }

    public int solution(int[] A) {
        Integer min = null;
        Integer max = null;
        int totalSum = 0;

        for (int currentValue : A) {
            if (min == null || min >= currentValue) {
                min = currentValue;
            }

            if (max == null || max <= currentValue) {
                max = currentValue;
            }

            totalSum += currentValue;
        }

        return IntStream.range(min, max+1).sum() - totalSum;
    }
}
