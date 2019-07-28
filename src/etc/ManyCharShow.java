package etc;

import java.util.HashMap;
import java.util.Map;

/**
 * 주어진 문자배열에서 가장 많이 나타난 문자를 프린트하시오.
 */
public class ManyCharShow {
    public static void main(String[] args) {
        ManyCharShow manyCharShow = new ManyCharShow();

        //char[] input = new char[]{'a', 'a', 'a', 'b', 'a', 'a'};
        char[] input = new char[]{'a', 'c', 'c', 'b', 'c', 'a'};
        //manyCharShow.solution(input);

        Map<Character, Integer> map = new HashMap<>();
        char manyChar = manyCharShow.solution2(map, input, 0, ' ');
        System.out.println(manyChar);
    }

    // iterator
    private char solution(char[] input) {
        Map<Character, Integer> map = new HashMap<>();
        char manyChar = ' ';
        for (int i = 0; i < input.length; i++) {
            Integer getCount = map.get(manyChar) == null ? 1 : map.get(manyChar);
            Integer currentCount = map.get(input[i]) == null ? 1 : map.get(input[i]);

            if (getCount < currentCount) {
                manyChar = input[i];
            }

            map.put(input[i], currentCount + 1);
        }

        return manyChar;
    }

    // recursive
    private char solution2(Map<Character, Integer> map, char[] input, int index, char manyChar) {
        if (index > input.length - 1) {
            return manyChar;
        }

        Integer getCount = map.get(manyChar) == null ? 1 : map.get(manyChar);
        Integer currentCount = map.get(input[index]) == null ? 1 : map.get(input[index]);

        if (getCount < currentCount) {
            manyChar = input[index];
        }

        map.put(input[index], currentCount + 1);

        return solution2(map, input, index + 1, manyChar);
    }
}
