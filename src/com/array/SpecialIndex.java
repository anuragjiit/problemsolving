/*
Problem Description
Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.



Problem Constraints
1 <= N <= 105
-105 <= A[i] <= 105
Sum of all elements of A <= 109


Input Format
First argument contains an array A of integers of size N


Output Format
Return the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.



Example Input
Input 1:
A = [2, 1, 6, 4]
Input 2:

A = [1, 1, 1]


Example Output
Output 1:
1
Output 2:

3


Example Explanation
Explanation 1:
Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1].
Therefore, the required output is 1.
Explanation 2:

Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
Therefore, the required output is 3.
 */

package com.array;

public class SpecialIndex {

        public int[] evenPreSum(int[] A, int n){
            int[] even = new int[n];
            even[0]=A[0];
            for(int i=1; i<n; i++){
                if(i%2==0){
                    even[i]=even[i-1]+A[i];
                }
                else {even[i]=even[i-1]; }
            }
            return even;
        }

        public int[] oddPreSum(int[] A, int n){
            int[] odd = new int[n];
            odd[0]=0;
            for(int i=1; i<n; i++){
                if(i%2!=0){
                    odd[i]=odd[i-1]+A[i];
                }
                else {odd[i]=odd[i-1]; }
            }
            return odd;
        }

        public int[] evenSuffixSum(int[] A, int n){
            int[] even = new int[n];
            if ((n-1)%2==0){even[n-1]=A[n-1];} else {even[n-1]=0;}
            for(int i=n-2; i>=0; i--){
                if(i%2==0){
                    even[i]=even[i+1]+A[i];
                }
                else {even[i]=even[i+1]; }
            }
            return even;
        }

        public int[] oddSuffixSum(int[] A, int n){
            int[] odd = new int[n];
            if ((n-1)%2!=0){odd[n-1]=A[n-1];} else {odd[n-1]=0;}

            for(int i=n-2; i>=0; i--){
                if(i%2!=0){
                    odd[i]=odd[i+1]+A[i];
                }
                else {odd[i]=odd[i+1]; }
            }
            return odd;
        }

        public int solve(int[] A) {

            int n = A.length, count=0;

            int[] evenPrefix = evenPreSum(A, n);
            int[] oddPrefix = oddPreSum(A, n);
            int[] evenSuffix = evenSuffixSum(A, n);
            int[] oddSuffix = oddSuffixSum(A, n);
            int evenP=0, oddP=0, evenS=0, oddS=0;

            for (int i=0; i<n;i++){
                if ( i==0 ) {
                    oddS= oddSuffix[i+1];
                    evenS = evenSuffix[i+1];

                } else if (i==n-1){
                    evenP=evenPrefix[i-1];
                    oddP=oddPrefix[i-1];
                }
                else {
                    evenP=evenPrefix[i-1];
                    oddS= oddSuffix[i+1];

                    oddP=oddPrefix[i-1];
                    evenS = evenSuffix[i+1];
                }
                if (evenP+oddS==oddP+evenS){
                    count++;
                }
            }

            return count;
        }


}
