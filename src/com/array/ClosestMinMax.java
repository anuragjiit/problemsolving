/*
Problem Description
Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array

and at least one occurrence of the minimum value of the array.



Problem Constraints
1 <= |A| <= 2000



Input Format
First and only argument is vector A



Output Format
Return the length of the smallest subarray which has at least one occurrence of minimum and maximum element of the array



Example Input
Input 1:

A = [1, 3, 2]
Input 2:

A = [2, 6, 1, 6, 9]


Example Output
Output 1:

 2
Output 2:

 3


Example Explanation
Explanation 1:

 Take the 1st and 2nd elements as they are the minimum and maximum elements respectievly.
Explanation 2:

 Take the last 3 elements of the array.
 */
package com.array;

public class ClosestMinMax {

    public static void main(String[] args){
        int[] A = {2, 6, 1, 6, 9};

        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int n = A.length;
        int min_index=-1, max_index=-1, result=Integer.MAX_VALUE, size=0;

        for (int i=0; i<n; i++){
            if (A[i]>max){
                max = A[i];
            }
            if (A[i]<min){
                min=A[i];
            }
        }

   //     System.out.println(max);
   //     System.out.println(min);

        for (int i=n-1; i>=0; i--){
            if (A[i]==max){
                max_index = i;
            }
            if (A[i]==min){
                min_index = i;
            }
            if ((min_index!=-1) && (max_index!=-1)){
                size = Math.abs(max_index-min_index)+1;
                result = Math.min(result, size);
            }
        }

        System.out.println(result);
    }
}
