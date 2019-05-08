package sort;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 병합정렬 (n log n)
 * - 정렬을 마친 배열의 병합을 으용하여 분할 정복법에 따라 정렬하는 알고리즘
 * Step
 * 1. 배열의 앞부분을 병합 정렬로 정렬
 * 2. 배열의 뒷부분을 병합 정렬로 정렬
 * 3. 배열의 앞부분과 뒷부분을 병합
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = {4, 6, 3, 9, 2, 1, 7, 5, 8, 0, 10};
        mergeSort(array, 0, array.length - 1);
        Arrays.stream(array).forEach(System.out::println);
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int leftIndex = left;
        int midIndex = mid + 1;
        int tempIndex = left;
        int[] tempArray = new int[array.length];

        while (leftIndex <= mid && midIndex <= right)
            tempArray[tempIndex++] = array[leftIndex] < array[midIndex] ? array[leftIndex++] : array[midIndex++];

        while (leftIndex <= mid)
            tempArray[tempIndex++] = array[leftIndex++];

        while (midIndex <= right)
            tempArray[tempIndex++] = array[midIndex++];

        for (int index = left; index < tempIndex; index++)
            array[index] = tempArray[index];
    }
}
