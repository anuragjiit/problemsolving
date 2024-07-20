/*
Problem Description

Misha likes finding all Subarrays of an Array. Now she gives you an array A of N elements and told you to find the number of subarrays of A, that have unique elements.

Since the number of subarrays could be large, return value % 109 +7.



Problem Constraints

1 <= N <= 105

1 <= A[i] <= 106



Input Format

The only argument given is an Array A, having N integers.



Output Format

Return the number of subarrays of A, that have unique elements.



Example Input

Input 1:

 A = [1, 1, 3]
Input 2:

 A = [2, 1, 2]


Example Output
Output 1:
 4
Output 1:
 5
Explanation 1:

 Subarrays of A that have unique elements only:
 [1], [1], [1, 3], [3]
Explanation 2:

 Subarrays of A that have unique elements only:
 [2], [1], [2, 1], [1, 2], [2]
 */
package com.array;
import java.util.HashSet;

public class CountSubarrays {
    public static void main(String[] args){

   //    int[] A = {1, 1, 3};
    //   int[] A = {2, 1, 2};
        int[] A ={93,9,12,32,97,75,32,77,40,79,61,42,57,19,64,16,86,47,41,67,76,63,24,10,25,96,1,30,73,91,70,65,53,75,5,19,65,6,96,33,73,55,4,90,72,83,54,78,67,56,8,70,43,63};
   //      int[] A = {93,9,12,32,97,75,32,77,40};   //should be 33 coming as 42
    //    int[] A={93,9,12,32,97,75,32,77,40,79,61,42,57,19,64,16,86,47,41,67,76,63,24,10,25,96,1}; //249  //19 , 65 & 96 duplicate
   //     int[] A = {93,9,12,32,97,75,32,77,40,79,61,42,57,19,64,16,86,47,41,67,76,63,24,10,25,96,1,30,73,91,70,65,53,75,5,19,65,6,96};    //550
        int l=0, r=0, ans=0, n=A.length;
        int modulus = 1000000007;

        HashSet<Integer> count = new HashSet<>();

        while (r<n) {

            if (!count.contains(A[r])){
                count.add(A[r]);
                ans= (ans+(r-l+1)) % modulus;
                r++;
            }
            else {
                count.remove(A[l]);
                l++;
            }

        }

        System.out.println(ans);

    }
}
