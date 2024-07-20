package com.random;

public class PickupFromBothSides {
    public static void main(String[] args){
        int[] A = {5, -2, 3 , 1, 2};
        int B =3;
        int n = A.length;
        int[] pf = new int[n];  // 2,5,4,8,10,11
        int[] sf = new int[n];  // 11,9,6,7,3,1
        pf[0] = A[0];
        sf[n-1] = A[n-1];
        int sum=0;

        for (int i=1; i<n;i++){
            pf[i]=pf[i-1]+A[i];
        }

        for (int i=n-2; i>=0;i--){
            sf[i]=sf[i+1]+A[i];
        }

       if (pf[B-1]>sf[n-B]){
           sum=pf[B-1];
       } else sum=sf[n-B];

       for (int i=1;i<B;i++){
           sum=Math.max(sum, pf[i-1]+sf[n-B+i]);
       }

       System.out.println(sum);
    }
}
