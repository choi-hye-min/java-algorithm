package search;

/**
 * https://bowbowbow.tistory.com/6
 */
public class KMP {
    public static void main(String[] args){
        String inputStr = "ABCDABCDABEE";
        String pattern = "ABCDABE";

        char[] sourceChar = inputStr.toCharArray();
        char[] patternChar = pattern.toCharArray();

        for (int i = 0; i < sourceChar.length; i++) {
            System.out.println(sourceChar[i]);
        }
    }
}
