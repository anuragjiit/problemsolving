/*
Problem Description

You are given three positive integers, A, B, and C.

Any positive integer is magical if divisible by either B or C.

Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.

Note: Ensure to prevent integer overflow while calculating.



Problem Constraints

1 <= A <= 10^9

2 <= B, C <= 40000



Input Format

The first argument given is an integer A.

The second argument given is an integer B.

The third argument given is an integer C.



Output Format

Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.



Example Input

Input 1:

 A = 1
 B = 2
 C = 3

Input 2:

 A = 4
 B = 2
 C = 3



Example Output

Output 1:

 2

Output 2:

 6



Example Explanation

Explanation 1:

 1st magical number is 2.

Explanation 2:

 First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.

 */
package com.binarysearch;

public class AthMagicalNumber {

    public static int gcd(int a, int b){
        if(a==0) return b;

        if(a>b) {
            return gcd(a%b,b);
        }
        return gcd(b%a,a);
    }

    public static int count(long mid, int b, int c, int lcm){
        return (int)(mid/b)+(int)(mid/c)-(int)(mid/lcm);
    }

    public static void main(String[] args) {
        int A = 4;
        int B = 2;
        int C = 3;
        int mod = 1000000007;

        long ans = 0;
        int lcm = (B*C)/gcd(B,C);
        long s = Math.min(B,C);
        long e = s*A;
        long mid = 0;

        while(s<=e){
            mid = (e-s)/2+s;
            int num = count(mid, B, C, lcm);
            if (num>A) e=mid-1;
            else if (num<A) s=mid+1;
            else {
                ans = mid;
                ans %= mod;
                e = mid-1;
            }
        }

    System.out.println(ans);
    }
}
