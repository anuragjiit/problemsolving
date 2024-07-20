package com.arithmeticgcd;

import java.util.HashMap;

public class CountNumberOfDivisors {

    public static void main(String[] args) {

        int[] A = {8,9,10};
        int n = A.length;
        int[] ans = new int[n];

        int spf[] = new int[1000001]; // as A constraint is that it can go upto 10^6 ...
        for(int i=1; i<=1000000; i++) spf[i]=i;

        for (int i=2; i*i<=1000000; i++){
            for(int j=i*i; j<=1000000; j+=i) {
                if (spf[j] == j) spf[j] = i;
            }
        }


        for (int i=0; i<n; i++){
            HashMap<Integer,Integer> freq = new HashMap<>();
            int num = A[i];
            while(num>1){
                int spfactor = spf[num];
                if(freq.containsKey(spfactor)) freq.put(spfactor, freq.get(spfactor)+1);
                else freq.put(spfactor, 1);

                num = num/spfactor;

            }

            int temp = 1;
            for( int values : freq.values()){
                   temp*=values+1;
            }

            ans[i] = temp;

            freq.clear();

        }

        for (int i=0; i<n; i++){
            System.out.println(ans[i]);
        }

    }
}
