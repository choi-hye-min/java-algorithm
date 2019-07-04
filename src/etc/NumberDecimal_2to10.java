package etc;

import java.util.Scanner;

/**
 * 진수 변환
 * 2 -> 10
 */
public class NumberDecimal_2to10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] binaryDecimal = {0, 0, 0, 0, 0, 1, 0, 1, 0};
        int total = 0;

        for(int i = 0; i < binaryDecimal.length; i++){
            int calculPointer = binaryDecimal.length - i;
            total += (int)(binaryDecimal[i] * Math.pow(2, calculPointer-1));
        }

        System.out.println(total);
    }
}
