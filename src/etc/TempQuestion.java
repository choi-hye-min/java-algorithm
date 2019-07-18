package etc;

public class TempQuestion {
    public static void main(String[] args) {
        TempQuestion tempQuestion = new TempQuestion();
        tempQuestion.solution(3, 12);
    }

    public int[] solution(int n, int m) {
        int[] answer = {};

        // n을 항상 큰수로 만들어 계산하기 위해서
        if (n < m) {
            int temp = n;
            n = m;
            m = temp;
        }

        // 최대공약수 얻기
        int maxCalcuate = n % m == 0 ? m : 1;
        //int gdc = GDC(n, m);

        // 최소공배수 얻기
        int lcm = n * m / maxCalcuate;

        return answer;
    }

    private int GDC(int max, int min) {
        if (min == 0) return max;
        return GDC(min, max % min);
    }

    /*public int solution(int n) {
        int answer = 0;

        String number = Integer.toString(n);
        for ( int i = 0; i < number.length(); i++ ) {
            answer += Integer.valueOf(String.valueOf(number.charAt(i)));
        }

        return answer;
    }*/

    /*public String solution(String s) {
        String answer = "";
        int cutStartPosition = 0;
        int cutEndPosition = 0;

        if (s.length() % 2 == 0) {
            cutStartPosition = (s.length() / 2) - 1;
            cutEndPosition = cutStartPosition + 2;
        } else {
            cutStartPosition = (s.length() / 2);
            cutEndPosition = cutStartPosition + 1;
        }

        answer = s.substring(cutStartPosition, cutEndPosition);

        return answer;
    }*/
}
