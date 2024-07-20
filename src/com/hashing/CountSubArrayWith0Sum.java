package com.hashing;

import java.util.HashMap;

public class CountSubArrayWith0Sum {
    public static void main(String[] args) {

        int[] A = {-1,8,-4,7,-4,0,-8,-2,-7}; //ans =1 -1,7,3,10,6,6,-2,-4,-7
        int n = A.length;
        long[] pfSum = new long[n];
        int mod = 1000000007;
        pfSum[0] = A[0];
        long count =0;

        for (int i=1; i<n; i++){
            pfSum[i] = pfSum[i-1]+A[i];
        }

        HashMap<Long,Long> fre = new HashMap<>();
        fre.put(0L, 1L);

        for (long ele: pfSum) {
            if(fre.containsKey(ele)) {
                count = (count+fre.get(ele))%mod;
                fre.put(ele, fre.get(ele)+1);
            } else fre.put(ele, 1L);
        }

        System.out.println(count);

    }
}
