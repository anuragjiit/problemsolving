package com.arithmeticgcd;

import java.util.Arrays;


public class PrimeFactorMin {
    public static void main(String[] args) {
        int A = 1;
        int[] B = {11};
        int[] ans = new int[A];
        int p[] = new int[1000001];
        for (int i=1; i<=1000000; i++){
            p[i] = i;
        }



        for (int i=2; i*i<=1000000; i++){

            for(int j=i*i; j<=1000000; j+=i) {
                if (p[j] == j) p[j] = i;

            }

       }


        for (int i=0; i<A; i++){
            int count = 1;
            int num = B[i];

            for(int j=num*num; j<=1000000; j+=num){   // in prob constraint A is till 10^5 .. so loop will cross 10^9 .. TLE .. could not figure out the logic
                                                        // to optimise it with 10^9 ... otherwise answer is correct
                if(p[j]==num) count++;
            }
            ans[i] = count;
        }

        System.out.println(Arrays.toString(ans));
    }
}
