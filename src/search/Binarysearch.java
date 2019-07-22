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
    public void searchRecursive(){

    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int findValue = 17;

        Binarysearch binarysearch = new Binarysearch();
        binarysearch.search(arr, findValue);
    }
}
