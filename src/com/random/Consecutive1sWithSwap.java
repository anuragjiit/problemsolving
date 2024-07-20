/*
Given a binary string A. It is allowed to do at most one swap between any 0 and 1. Find and return the length of the longest consecutive 1’s that can be achieved.


Input Format

The only argument given is string A.

Output Format

Return the length of the longest consecutive 1’s that can be achieved.

Constraints

1 <= length of string <= 1000000
A contains only characters 0 and 1.

For Example

Input 1:
    A = "111000"
Output 1:
    3

Input 2:
    A = "111011101"
Output 2:
    7

 */
package com.random;

public class Consecutive1sWithSwap {
    public static void main(String[] args){
     //   int[] A = {0,1,1,1,0,1,1,0,1,1,0};
     //   String A ="111011101";
    //    String A ="011110000111110101001011101100000001001001111111101";   //28 ones
        String A ="111111";   //28 ones
        int n = A.length();
        int[] pf = new int[n];
        int[] sf = new int[n];
        int totalOnes = 0;
        int ones=0;
        int ans = 0, l = 0, r= 0;

        for(int i =0; i<n; i++){
            if (A.charAt(i)=='1'){
                totalOnes++;
            }
        }
   //     System.out.println(totalOnes);
        if (totalOnes==n) { ans = n; }


        for (int i=0; i<n; i++){
            if (A.charAt(i)=='1'){
                ones++;
            } else ones = 0;
            pf[i]=ones;
        }

        ones=0;
        for (int i=n-1; i>=0; i--){
            if (A.charAt(i)=='1'){
                ones++;
            } else ones = 0;
            sf[i]=ones;
        }



        if (A.charAt(0)=='0'){
            l = 0;
            r = sf[1];
            if (totalOnes > l+r){
                ans = Math.max(ans, l+r+1);
            } else ans = Math.max(ans, l+r);
        }

        if (A.charAt(n-1)=='0'){
            r = 0;
            l = pf[n-2];
            if (totalOnes > l+r){
                ans = Math.max(ans, l+r+1);
            } else ans = Math.max(ans, l+r);
        }

        for (int i=1; i<n-1; i++) {

            if (A.charAt(i)=='0') {
                l = pf[i - 1];
                r = sf[i + 1];

                if (totalOnes > l + r) {
                    ans = Math.max(ans, l + r + 1);
                } else ans = Math.max(ans, l + r);
            }
        }

        System.out.println(ans);


    }
}
