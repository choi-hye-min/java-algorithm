package sort;

import java.util.Arrays;

public class QuickSort {
    private void _quicksSort(int[] data, int leftPosition, int rightPosition) {
        int left = leftPosition;
        int right = rightPosition;
        int pivot = data[(leftPosition + rightPosition) / 2];

        do {
            while (data[left] < pivot) left++;
            while (data[right] > pivot) right--;

            if (left <= right) {
                swap(data, left++, right--);
            }
        } while (left <= right);

        // 재귀로 분할하여 정렬한다.
        if (leftPosition < right) _quicksSort(data, leftPosition, right); // 0...right
        if (rightPosition > left) _quicksSort(data, left, rightPosition); // left...10
    }

    private void swap(int[] data, int left, int right) {
        int temp = data[left];

        data[left] = data[right];
        data[right] = temp;
    }

    public static void main(String[] args) {
        int[] data = {7, 4, 6, 5, 8, 3, 2, 0};

        QuickSort quickSort = new QuickSort();
        quickSort._quicksSort(data, 0, data.length - 1);

        Arrays.stream(data).forEach(System.out::print);
    }
}