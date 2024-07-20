package com.array;

import java.util.Arrays;

public class MaxSumOfAsendingSubArray {
    public static void main(String[] args) {
      //  int[] A = {9,2,4,2};
        int[] A = {9,17,19,13,13,20,13,2,18,3};
        int n = A.length;


        int sum = A[0];
        int max = A[0];

        for (int s = 1; s<n; s++){
            if (A[s] > A[s-1]) {
                sum += A[s];
                max = Math.max(max, sum);
            } else sum = A[s];
        }

//        for (int s = 0; s<n; s++){
//            int sum=A[s];
//            num = Math.max(num,sum);
//            for (int e = s+1; e<n; e++){
//                if (A[e] > A[e-1]){
//                    sum+=A[e];
//                } else break;
//                num = Math.max(num,sum);
//            }
//        }

        System.out.println(max);
 /*       int[] A = {2,4,7,11};
        int[] B = {3};
        int bLength = B.length;
        int n = A.length;
        int[] ans = new int[bLength];

        for (int j=0; j<bLength; j++){
            int q = B[j];
            int ones=0;
            int zeros=0;

            for (int ele : A){
                if( (ele & 1<<q) != 0 ) {
                    ones++;
                } else zeros++;
            }

            ans[j] = ones*zeros;

        }

        System.out.println(Arrays.toString(ans)); */
    }
}
