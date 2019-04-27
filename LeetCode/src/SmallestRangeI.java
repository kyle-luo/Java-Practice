//Given an array A of integers, for each integer A[i] we may choose any x with -K <= x <= K, and add x to A[i].
//
//After this process, we have some array B.
//
//Return the smallest possible difference between the maximum value of B and the minimum value of B.
//
//
//
//Example 1:
//
//Input: A = [1], K = 0
//Output: 0
//Explanation: B = [1]
//Example 2:
//
//Input: A = [0,10], K = 2
//Output: 6
//Explanation: B = [2,8]
//Example 3:
//
//Input: A = [1,3,6], K = 3
//Output: 0
//Explanation: B = [3,3,3] or B = [4,4,4]

public class SmallestRangeI {
    public static int smallestRangeI(int[] A, int K) {
        int max = A[0];
        int min = A[0];
        for (int i = 1; i < A.length; i++){
            if (A[i] > max) max = A[i];
            else if (A[i] < min) min = A[i];
        }
        int big = max - K;
        int small = min + K;
        if(big > small) return big - small;
        else return 0;
    }

    public static void main(String[] args){
        int[] A = {0,10};
        int K = 2;
        System.out.println(smallestRangeI(A,K));
    }
}
