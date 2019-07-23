package etc;

public class TempQuestion {
    public static void main(String[] args) {
        TempQuestion tempQuestion = new TempQuestion();
        tempQuestion.solution(new int[]{4, 3, 2, 1});
    }

    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length - 1];

        if (arr[0] == 10) return new int[]{-1};

        int minIndex = 1;
        int minValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minIndex = i;
                minValue = arr[i];
            }
        }

        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (minIndex == i) continue;
            answer[j++] = arr[i];
        }

        return answer;
    }
}


