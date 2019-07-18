package etc;

import java.util.HashMap;
import java.util.Map;

public class TempQuestion {
    public static void main(String[] args) {
        TempQuestion tempQuestion = new TempQuestion();
        tempQuestion.solution(new String[]{"sun", "bed", "car"}, 1);
    }

    public String[] solution(String[] strings, int n) {
        String[] answer = {};

        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            int positionChar = strings[i].charAt(n);
            map.put(positionChar, strings[i]);
        }

        return answer;
    }
}
