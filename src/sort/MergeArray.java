package sort;

import java.util.Arrays;

/**
 * 병합정렬 하기전 이해를 돕기 위해
 * 정렬을 마친 배열의 병합
 */
public class MergeArray {
    public static void main(String[] args) {
        int[] aArray = {2, 4, 6, 8, 11, 13};
        int[] bArray = {1, 2, 3, 4, 9, 16, 21};
        int[] cArray = new int[aArray.length + bArray.length];

        merge(aArray, bArray, cArray);

        Arrays.stream(cArray).forEach(System.out::println);
    }

    private static void merge(int[] aArray, int[] bArray, int[] cArray) {
        int aIndex = 0, bIndex = 0, cIndex = 0;

        // cArray에 작은값부터 채워넣는다.
        while (aIndex < aArray.length && bIndex < bArray.length) {
            cArray[cIndex++] = aArray[aIndex] <= bArray[bIndex] ? aArray[aIndex++] : bArray[bIndex++];
        }

        // 남은 aArray에요소를 채워넣는다.
        while (aIndex < aArray.length) {
            cArray[cIndex++] = aArray[aIndex++];
        }

        // 남은 bArray에요소를 채워넣는다.
        while (bIndex < bArray.length) {
            cArray[cIndex++] = bArray[bIndex++];
        }
    }
}
