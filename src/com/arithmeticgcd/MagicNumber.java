package com.arithmeticgcd;

public class MagicNumber {
    public static void main(String[] args) {
   //     int[] A = {42,1,7,5,48}; // ans = 42

       int[] A = {8,9,6};
        int n = A.length;
        //    Arrays.sort(A, Collections.reverseOrder());
        int[]fac = new int[n];



         boolean[]spf = new boolean[1000001];
         for(int i=1; i<=1000000; i++) spf[i]=true;

         for(int i=2; i*i<=1000000; i++) {

             for(int j=i*i; j<=1000000; j=j+i){
                 if(spf[j]==true) spf[j]=false;
             }
         }

//        int[]spf = new int[1000001];
//        for(int i=1; i<=1000000; i++) spf[i]=i;
//
//        for(int i=2; i*i<=1000000; i++) {
//
//            for(int j=i*i; j<=1000000; j=j+i){
//                if(spf[j]==j) spf[j]=i;
//            }
//        }

        for(int i=0;i<n;i++){
            int num = A[i];
            int count =0;
            for(int j=2; j<=num; j++){
                if (spf[j]==true && num%j==0) {
                    num = num/j;
                    count++;
       //             if (spf[temp]==true) count= count+2;
       //             else count++;
                }
            }
            fac[i] = count;
        }

        int ans = Integer.MIN_VALUE;
        int index = 0;

        for(int i=0;i<n;i++){

            if(fac[i]>index) {
                index = fac[i];
                ans = A[i];
            }

            if(fac[i]==index) {
          //      index=fac[i];
                ans = Math.max(ans, A[i]);
            }

        }

        System.out.println(ans);

    }
}
