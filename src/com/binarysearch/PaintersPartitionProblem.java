/*
Problem Description

Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.
Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.

NOTE:
1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.

Return the ans % 10000003.



Problem Constraints

1 <= A <= 1000
1 <= B <= 10^6
1 <= N <= 10^5
1 <= C[i] <= 10^6



Input Format

The first argument given is the integer A.
The second argument given is the integer B.
The third argument given is the integer array C.



Output Format

Return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board % 10000003.



Example Input

Input 1:

 A = 2
 B = 5
 C = [1, 10]

Input 2:

 A = 10
 B = 1
 C = [1, 8, 11, 3]



Example Output

Output 1:

 50

Output 2:

 11



Example Explanation

Explanation 1:

 Possibility 1:- One painter paints both blocks, time taken = 55 units.
 Possibility 2:- Painter 1 paints block 1, painter 2 paints block 2, time take = max(5, 50) = 50
 There are no other distinct ways to paint boards.
 ans = 50 % 10000003

Explanation 2:

 Each block is painted by a painter so, Painter 1 paints block 1, painter 2 paints block 2, painter 3 paints block 3
 and painter 4 paints block 4, time taken = max(1, 8, 11, 3) = 11
 ans = 11 % 10000003
 */
package com.binarysearch;

public class PaintersPartitionProblem {
    public static void main(String[] args) {


//        int A = 3;   // no of painter
//        int B  = 10;   // units of time to paint 1 unit of board
//        int[] C = new int[] {185,186,938,558,655,461,441,234,902,681};   // unit ob board

//        int A = 1;   // no of painter
//        int B  = 1000000;   // units of time to paint 1 unit of board
//        int[] C = new int[] {1000000,1000000};

        int A = 4;   // no of painter
        int B  = 10;   // units of time to paint 1 unit of board
        int[] C = new int[] {884,228,442,889};

        int n = C.length;
        long ans = 1;

        long mod = 10000003;
        long minPaint = 0;
        long maxPaint = 0;

        for (int i=0; i<n; i++){
            if(C[i]>=minPaint){
                minPaint=C[i];
            }
            maxPaint+=C[i];
        }
//
//        if (A>=n) {
//            ans = (minPaint*B)%mod;
//
//        }

         if(A==1) {
             ans = (maxPaint*B)%mod;
             System.out.println((int)(ans)%mod);
             System.exit(0);
        }

          // 1,3,8,11

//        minPaint*=B;
//        maxPaint*=B;


        while(minPaint<=maxPaint){
            long mid = (maxPaint-minPaint)/2+minPaint;    //23/2 = 11
            if(isPossible(C, A, mid)){
                ans = mid;
                maxPaint = mid-1;
            }
            else {
                minPaint = mid+1;
            }
        }
        ans = (ans*B)%mod;
        System.out.println((int)ans);

    }

    public static boolean isPossible(int[] C, int A, long mid) {
        int sum=0;
        int painter = 1;
        for(int ele : C) {
            sum+=ele;
            if(sum>mid) {
                painter++;
                sum = ele;
            }
            if(painter>A) {
                return false;
            }
        }

        return true;
    }
}
