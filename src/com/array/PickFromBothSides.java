/*
Problem Description
You are given an integer array A of size N.

You have to perform B operations. In one operation, you can remove either the leftmost or the rightmost element of the array A.

Find and return the maximum possible sum of the B elements that were removed after the B operations.

NOTE: Suppose B = 3, and array A contains 10 elements, then you can:

Remove 3 elements from front and 0 elements from the back, OR
Remove 2 elements from front and 1 element from the back, OR
Remove 1 element from front and 2 elements from the back, OR
Remove 0 elements from front and 3 elements from the back.


Problem Constraints
1 <= N <= 105

1 <= B <= N

-103 <= A[i] <= 103


Input Format
First argument is an integer array A.

Second argument is an integer B.

Output Format
Return an integer denoting the maximum possible sum of elements you removed.

Example Input
Input 1:

 A = [5, -2, 3 , 1, 2]
 B = 3
Input 2:

 A = [ 2, 3, -1, 4, 2, 1 ]
 B = 4

Example Output
Output 1:
 8
Output 2:
 9

Example Explanation
Explanation 1:

 Remove element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
Explanation 2:

 Remove the first element and the last 3 elements. So we get 2 + 4 + 2 + 1 = 9

 ans :

 Approach using Prefix and Suffix Sums:

Maintain two arrays prefix[i] and suffix[i] where prefix[i] denotes sum of elements from index [0,i] and suffix[i] denotes sum of elements from index [i,N-1].

Now iterate from left and one by one pick elements from left for example: if you pick ‘a’ elements from left and remaining ‘k-a’ elements from right.
So the sum in this case will be prefix[a-1] + suffix[n-(k-a)]

Maintain the maximum among all and return it.

Time Complexity: O(N)
Space Complexity: O(N)

where N is number of elements in array A

Bonus: Try solving it in O(1) space.
 */
package com.array;

public class PickFromBothSides {
    public static void main(String[] args){
        int[] A = {2, 3, -1, 4, 2, 1 };
        int B =4;
        int n = A.length;
        int sum=0;
        int[] preSum = new int[n];
        int[] suffSum = new int[n];

        preSum[0] = A[0];
        suffSum[n-1] =A[n-1];
        for (int i=1; i<n; i++){
            preSum[i]=preSum[i-1]+A[i];
        }

        for (int i=n-2; i>=0; i--){
            suffSum[i]=suffSum[i+1]+A[i];
        }

        if (preSum[B-1]>=suffSum[n-B]){
            sum = preSum[B-1];
        } else {sum=suffSum[n-B];}

        for (int i=1; i<B; i++){

            if(preSum[i-1] + suffSum[n-(B-i)]>sum){
                sum = preSum[i-1]+suffSum[n-B+i];
            }

//            if(suffSum[n-i] + preSum[B-i-1] > sum){
//                sum = suffSum[n-i] + preSum[B-i-1];
//            }

        }

        System.out.println(sum);
    }
}
