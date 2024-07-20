package com.hashing;

import java.util.HashSet;

public class SubArrayWith0Sum {
    public static void main(String[] args) {
        int[] A = {4,-1,1};
        int n = A.length;
        long[] pfSum = new long[n];
        pfSum[0] = A[0];

        for (int i=1; i<n; i++){
            pfSum[i] = pfSum[i-1]+A[i];
        }

        HashSet<Long> subArraySum = new HashSet<>();


        for (long ele : pfSum){
            if(ele == 0) System.out.println("1");
            else subArraySum.add(ele);
        }

        System.out.println(subArraySum.size() < n ? 1 : 0);
    }
}
