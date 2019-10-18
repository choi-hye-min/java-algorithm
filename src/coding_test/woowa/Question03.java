package coding_test.woowa;

import java.util.HashMap;
import java.util.Map;

public class Question03 {
    public static void main(String[] args) {
        Question03 question = new Question03();
        System.out.println(question.solution(new int[]{-1,3, 2, -2, 5, -3}));
    }

    public int solution(int [] A) {
        Map<Integer, Integer> minusMap = new HashMap<>();
        for (int i = 0; i < A.length;i++) {
            if (A[i] < 0) {
                minusMap.put(-A[i], 1);
            }
        }

        int maxResult = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0 && minusMap.containsKey(A[i])) {
                maxResult = Math.max(A[i], maxResult);
            }
        }
        return maxResult;
    }
}
