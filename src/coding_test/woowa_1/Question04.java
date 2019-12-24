package coding_test.woowa_1;

import java.util.Arrays;

public class Question04 {
    public static void main(String[] args) {
        Question04 question = new Question04();
        System.out.println(question.solution(new int[]{1, 2, 3, 13}, new int[]{10, 11, 12, 9, 13}));
    }

    int solution(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        for (int k = n-1; k >= 0; k--) { // <--
            while (i < m -1 && B[i] < A[k]) // <--
                i += 1;
            if (A[k] == B[i])
                return A[k];
        }
        return -1;
    }
}
