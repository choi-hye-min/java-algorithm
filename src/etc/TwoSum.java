package etc;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        //twoSum.twoSum(new int[]{3,2,3}, 6);
    }

    private int[] twoSum(int[] arr, int target) {
        int[] answer = {};

        answer= searchIndex(arr, 0, target);

        return answer;
    }

    private int[] searchIndex(int[] arr, int index, int target){
        if(index == arr.length-1) return new int[]{};

        for (int i = (index+1); i < arr.length; i++) {
            if(arr[index] + arr[i] == target){
                return new int[]{index, i};
            }
        }

        return searchIndex(arr, index+1, target);
    }
}
