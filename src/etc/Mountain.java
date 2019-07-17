package etc;

/**
 * 산의 봉우리 갯수 파악하기
 * [0, 1, 2, 3, 4, 2, 1, 3, 4, 2, 1] == 2
 */
public class Mountain {

    public static void main(String[] args) {
        int[] mountain = {3, 3, 3, 4, 5, 2, 2, 1, 1};
        Mountain m = new Mountain();
        m.solution(mountain);
    }


    public int solution(int[] mountain) {
        int count = 0;
        int maxHeight = 0;

        for (int i = 0; i < mountain.length; i++) {

            if (maxHeight <= mountain[i]) {
                maxHeight = mountain[i];

                if ((i + 1) < mountain.length && mountain[i + 1] < maxHeight) {
                    count++;
                    maxHeight = mountain[i];
                }
            }

            if (i == (mountain.length - 1)) {
                if (mountain[i] > mountain[i - 1]) {
                    count++;
                }
            }
        }

        System.out.println(count);
        return count;
    }
}
