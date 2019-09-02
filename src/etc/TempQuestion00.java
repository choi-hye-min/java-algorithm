package etc;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 반복된 알파벳으로 이루어진 문자배열이 주어지면 연속으로 중복된 알파벳이 없도록 문자배열을 재배열하여 리턴하시오. 불가능 하다면 empty string을 리턴하시오.
 * Given a string with repeated characters, rearrange the string so that no two adjacent characters are the same. If this is impossible, return an empty string.
 * <p>
 * input: "aaabbc"
 * output: "ababac"
 * <p>
 * input: "aaac"
 * output: ""
 */
public class TempQuestion00 {
    public static void main(String[] args) {
        TempQuestion00 question00 = new TempQuestion00();
        question00.solution("aaaaabbcc");
    }

    public void solution(String inString) {
        Map<Character, Integer> charMap = new HashMap<>();

        for (char c : inString.toCharArray()) {
            charMap.put(c, Optional.ofNullable(charMap.get(c)).orElse(0) + 1);
        }

        charMap = mapSort(charMap);





        System.out.println();
    }

    private Map<Character, Integer> mapSort(Map<Character, Integer> charMap) {
        return charMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (v1, v2) -> v1, LinkedHashMap::new));
    }
}