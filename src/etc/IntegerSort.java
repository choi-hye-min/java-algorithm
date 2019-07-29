package etc;

/**
 * 0, 1, 2, 2, 1, 0 -> 0, 0, 1, 1, 2, 2로 정렬하라
 */
public class IntegerSort {
    public static void main(String[] args) {
        IntegerSort integerSort = new IntegerSort();

        integerSort.solution(new int[]{0, 1, 2, 2, 1, 0});
    }

    private int[] solution(int[] input) {
        int[] output = recursiveQuickSort(input, 0, input.length-1);
        return output;
    }

    private int[] recursiveQuickSort(int[] arr, int leftPosition, int rightPosition) {
        int pivot = arr[(leftPosition + rightPosition) / 2];
        int left = leftPosition;
        int right = rightPosition;

        do {
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;

            if(left <= right){
                swap(arr, left++, right--);
            }
        }while(left <= right);

        if(leftPosition < right) recursiveQuickSort(arr, leftPosition, right);
        if(left > rightPosition) recursiveQuickSort(arr, left, rightPosition);

        return arr;
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
