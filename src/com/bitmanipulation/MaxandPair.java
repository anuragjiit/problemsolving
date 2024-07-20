/*
Problem Description
Given an array A. For every pair of indices i and j (i != j), find the maximum A[i] & A[j].



Problem Constraints
1 <= len(A) <= 105
1 <= A[i] <= 109



Input Format
The first argument is an integer array A.



Output Format
Return a single integer that is the maximum A[i] & A[j].



Example Input
Input 1:-

A = [53, 39, 88]

Input 2:-

A = [38, 44, 84, 12]



Example Output
Output 1:-

37

Output 2:-

36



Example Explanation
Explanation 1:-

53 & 39 = 37
39 & 88 = 0
53 & 88 = 16
Maximum among all these pairs is 37

Explanation 2:-

Maximum bitwise and among all pairs is (38, 44) = 36

 */
package com.bitmanipulation;


public class MaxandPair {
    public static void main(String[] args) {
        int[] A = {38, 44, 84, 12};

        int ans =0;

        for (int i=31; i>=0; i--){
            int setBitCount = 0;

            for (int ele : A){
                if ( (ele & 1 << i) == 1 <<i){
                    setBitCount++;
                }
            }

            if (setBitCount >=2){
                ans+= 1<<i;
                for (int j=0; j<A.length; j++){
                    if((A[j] & 1 << i) == 0){
                        A[j] =0;
                    }
                }
            }
        }

        System.out.println(ans);

  /*      ArrayList<Integer> set2 = new ArrayList<>();

        for (int i =0; i<A.length; i++){
            set2.add(A[i]);
        }


        for (int i=31; i>=0; i--){
            ArrayList<Integer> set1 = new ArrayList<>();

            for (int ele : set2){
                if (( ele & 1 << i) == 1 << i){
                    set1.add(ele);
                }
            }
                if (set1.size()>=2) {
                    set2 = set1;
                }
            }

        int max = set2.get(0) & set2.get(1);

        System.out.println(max); */



    }
}
