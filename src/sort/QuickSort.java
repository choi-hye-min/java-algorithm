package sort;

import java.util.Arrays;

public class QuickSort {
    private static void _quicksSort(int[] data, int leftPosition, int rightPosition) {
        int left = leftPosition;
        int right = rightPosition;
        int pivot = data[(leftPosition + rightPosition) / 2];

        do {
            while (data[left] < pivot) left++;
            while (data[right] > pivot) right--;

            if (left <= right)
                swap(data, left++, right--);

        } while (left <= right);

        // 재귀로 분할하여 정렬한다.
        if (leftPosition < right) _quicksSort(data, leftPosition, right); // 0...right
        if (rightPosition > left) _quicksSort(data, left, rightPosition); // left...10
    }

    private static void swap(int[] data, int left, int right) {
        Arrays.stream(data).forEach(System.out::print);System.out.println();

        int temp = data[left];

        data[left] = data[right];
        data[right] = temp;
    }

    public static void main(String[] args) {
        int[] data = {2, 4, 3, 1, 5};
        _quicksSort(data, 0, data.length - 1);
//        Arrays.stream(data).forEach(System.out::print);
    }
}