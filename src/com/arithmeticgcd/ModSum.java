/*
roblem Description

Given an array of integers A, calculate the sum of A [ i ] % A [ j ] for all possible i, j pairs. Return sum % (109 + 7) as an output.



Problem Constraints

1 <= length of the array A <= 105

1 <= A[i] <= 103



Input Format

The only argument given is the integer array A.



Output Format

Return a single integer denoting sum % (109 + 7).



Example Input

Input 1:

 A = [1, 2, 3]

Input 2:

 A = [17, 100, 11]



Example Output

Output 1:

 5

Output 2:

 61



Example Explanation

Explanation 1:

 (1 % 1) + (1 % 2) + (1 % 3) + (2 % 1) + (2 % 2) + (2 % 3) + (3 % 1) + (3 % 2) + (3 % 3) = 5

 */
package com.arithmeticgcd;

public class ModSum     {
    public static void main(String[] args) {
        int[] A = {17, 100, 11};
        int[] count = new int[1001];
        int mod = 1000000007;
        long sum = 0;

        for (int ele : A){
            count[ele]++;
        }

        for (int i =1; i<1001; i++){
            for (int j =1; j<1001; j++){
                sum+= (i%j) * count[i] * count[j];
                sum= sum%mod;
            }
        }

        System.out.println(sum);
    }

}
