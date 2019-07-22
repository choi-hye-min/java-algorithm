package search;

/**
 * 이진탐색(binary search)는 정렬되어 있는 자료들의 집합에서 특정 자료를 찾고자 할 때 많이 사용되며 매우 빠른 탐색 알고리즘이다.
 */
public class Binarysearch {

    public void search(int[] arr, int findValue){
        int mid;
        int left = 0;
        int right = arr.length-1;

        while(left <= right){
            mid = (left+right)/2;

            if(findValue == arr[mid]){
                System.out.println("findValue index : "+mid);
                break;
            }

            if(arr[mid] > findValue){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
    }

    // 재귀적 이진검색
    public void solution(int[] arr, int findValue) {
        int answer = binaryRecursive(arr, 0, arr.length - 1, findValue);
        System.out.println(answer);
    }

    private int binaryRecursive(int[] arr, int startPosition, int endPosition, int findValue) {
        int middle = (startPosition + endPosition) / 2; // 중간 인덱스를 구함

        // 포지션 범위를 넘어갔다면 값이 존재하지않음
        if (startPosition > endPosition) {
            return -1;
        }

        // 중간값보다 찾는값이 크다면 뒤로 찾는다
        if (arr[middle] < findValue) {
            return binaryRecursive(arr, middle + 1, endPosition, findValue);
        }

        // 중간값보다 찾는값이 작다면 앞으로 찾는다.
        if (arr[middle] > findValue) {
            return binaryRecursive(arr, startPosition, middle - 1, findValue);
        }

        // 값이 일치하면 반환
        if (arr[middle] == findValue) {
            return middle;
        }

        return -1;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int findValue = 19;

        Binarysearch binarysearch = new Binarysearch();
        //binarysearch.search(arr, findValue);

        binarysearch.solution(arr, findValue);
    }
}
