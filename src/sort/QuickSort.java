package sort;

import java.util.Arrays;

public class QuickSort {
    private void sort(int[] data, int l, int r) {
        int left = l;
        int right = r;
        int pivot = data[(l + r) / 2];

        do {
            while (data[left] < pivot) left++;
            while (data[right] > pivot) right--;

            if (left <= right) {
                swap(data, left++, right--);
            }
        } while (left <= right);

        if (l < right) sort(data, l, right); // 0...right
        if (r > left) sort(data, left, r); // left...10
    }

    private void swap(int[] data, int left, int right) {
        int temp = data[left];

        data[left] = data[right];
        data[right] = temp;
    }

    public static void main(String[] args) {
        int[] data = {7, 4, 6, 5, 8, 3, 2, 0};

        QuickSort quickSort = new QuickSort();
        quickSort.sort(data, 0, data.length - 1);

        Arrays.stream(data).forEach(System.out::print);
    }
}