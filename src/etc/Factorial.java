package etc;

/**
 * 팩토리얼 구하기
 * 10 = (10 * 9!)
 */
public class Factorial {
    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println(factorial.factorial(10));
    }

    private int factorial(int n) {
        if (n > 0) {
            return n * factorial(n - 1);
        } else {
            return 1;
        }
    }
}
