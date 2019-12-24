package coding_test.woowa_1;

public class Question01 {
    public static void main(String[] args) {
        Question01 question01 = new Question01();

        System.out.println(question01.solution(3, 2, new int[]{2, 1, 1, 0, 1}));
        System.out.println(question01.solution(2, 3, new int[]{0, 0, 1, 1, 2}));
        System.out.println(question01.solution(2, 2, new int[]{2, 0, 2, 0}));
        System.out.println(question01.solution(3, 2, new int[]{1, 1, 1, 1}));
    }

    // IMPOSSIBLE
    public String solution(int U, int L, int[] C) {
        // write your code in Java SE 8
        int upperCount = U;
        int lowCount = L;

        int[] uResult = new int[C.length];
        int[] lResult = new int[C.length];

        for (int i = 0; i < C.length; i++) {
            int arrayPositionCount = C[i];

            if (arrayPositionCount == 0)
                continue;

            if (arrayPositionCount == 2) {
                uResult[i] = 1;
                lResult[i] = 1;

                upperCount = upperCount--;
                lowCount = lowCount--;

                continue;
            }

            if (arrayPositionCount == 1) {
                if (upperCount > lowCount) {
                    uResult[i] = 1;
                    upperCount--;
                } else {
                    lResult[i] = 1;
                    lowCount--;
                }
                continue;
            }
        }

        if (U != arraySum(uResult) || L != arraySum(lResult)) {
            return "IMPOSSIBLE";
        }

        return arrayToString(uResult) + "," + arrayToString(lResult);
    }

    private String arrayToString(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i]);
        }

        return stringBuilder.toString();
    }

    private int arraySum(int[] array) {
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }

        return total;
    }
}
