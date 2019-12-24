package etc;

/*
For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.
*/
public class BinaryGap {

    public static void main(String[] args) {
    
    }

    private int solution(int N) {
        //000111100111101101
        boolean isCheck = false;
        int maxCount = 0;
        int tempCount = 0;

        // 1111100000011010010110011001110
        for (int mok = N; mok > 0; mok = mok / 2) {
            int nmg = mok % 2;
            System.out.println("MOK : " + mok + " NMG : " + nmg);

            if (nmg == 1) isCheck = true;

            if (nmg == 0 && isCheck) {
                tempCount++;
            }

            if (nmg == 1) {
                maxCount = maxCount > tempCount ? maxCount : tempCount;
                tempCount = 0;
            }
        }

        return maxCount > tempCount ? maxCount : tempCount;
    }
}
