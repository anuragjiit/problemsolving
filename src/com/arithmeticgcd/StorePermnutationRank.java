/*
Problem Description

Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
Assume that no characters are repeated.

Note: The answer might not fit in an integer, so return your answer % 1000003



Problem Constraints

1 <= |A| <= 1000



Input Format

First argument is a string A.



Output Format

Return an integer denoting the rank of the given string.



Example Input

Input 1:

A = "acb"

Input 2:

A = "a"



Example Output

Output 1:

2

Output 2:

1
 */
package com.arithmeticgcd;

public class StorePermnutationRank {

    public static int fact(int n){

        int mod = 1000003;
        if(n==0 || n ==1 ) return 1;

        return (n*fact(n-1))%mod;
    }

    public static void main(String[] args) {
        String A = "DTNGJPURFHYEW";    //342501
       int n = A.length();
       int ans = 1;
       int mod = 1000003;

       for (int i=0; i<n; i++){
           int count =0;
           for (int j = i+1; j<n; j++){
               if(A.charAt(i) > A.charAt(j)) {
                   count++;
               }
           }
           ans+= (count* fact(n-i-1))%mod;
       }

    System.out.println(ans%mod);
    }
}
