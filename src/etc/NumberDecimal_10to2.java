package etc;

import java.util.Scanner;
import java.util.Stack;

/**
 * 진수 변환
 * https://dyndy.tistory.com/6
 */
public class NumberDecimal_10to2 {
    private static final int TRANS_NUMBER = 2; // 변환진수

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 10; // 입력값

        Stack<Integer> stack = new Stack<>();

        while (number != 1){
            int na = number % TRANS_NUMBER;
            number = number / TRANS_NUMBER;

            stack.push(na);
        }
        stack.push(1);

        showStackNumber(stack);
    }

    private static void showStackNumber(Stack<Integer> stack) {
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
