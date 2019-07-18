package etc;

/**
 * https://geonlee.tistory.com/75
 * 최대 공약수(GDC)와 최소 공배수(LCM) 구하기
 * <p>
 * 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요.
 * 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다.
 * 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.
 * <p>
 * 개인적인 의견 : 솔까 공식알아야 풀수 있음
 **/
public class GdcLcm {
    public static void main(String[] args) {
        GdcLcm gdcLcm = new GdcLcm();
        gdcLcm.solution(3, 12);
    }

    public int[] solution(int n, int m) {
        int[] answer = {};

        int min = n;
        int max = m;
        if (n > m) {
            max = n;
            min = m;
        }

        /**
         * GDC
         * 3 = 1,3
         *12 = 1,2,3,4,6,12
         * => 3
         */
        int gdc = GDC(max, min);

        /**
         * 3 = 3,6,9,12
         * 12 = 12
         * => 12
         */
        int lcm = (min * max) / gdc;

        answer = new int[]{gdc, lcm};

        return answer;
    }

    private int GDC(int max, int min) {
        if (min == 0) return max;
        return GDC(min, max % min);
    }
}
