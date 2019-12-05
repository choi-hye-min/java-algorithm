package codility;

import java.util.HashSet;
import java.util.Set;

/**
 * 배열A가 주어지면 0에 가까운 가장작은수를 찾는다
 */
public class MissingInteger {
    public static void main(String[] args) {
        MissingInteger missingInteger = new MissingInteger();
        System.out.println(missingInteger.solution(new int[]{1, 3, 6, 4, 1, 2}));;
        System.out.println(missingInteger.solution(new int[]{-1, -3}));;
        System.out.println(missingInteger.solution(new int[]{2}));
    }

    public int solution(int[] A) {
        int result = -1;
        Set<Integer> set = new HashSet<>();
        for(int a : A){
            set.add(a);
        }

        for(int i = 1; i < 1000000; i++){
            if(set.contains(i) == false){
                result = i;
                break;
            }
        }

        return result;
    }
}
