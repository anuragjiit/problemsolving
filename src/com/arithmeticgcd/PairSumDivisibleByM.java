package com.arithmeticgcd;

public class PairSumDivisibleByM {
    public static void main(String[] args) {

        int[] A = {1, 2, 3, 4, 5};
        int B  = 2;
        int n = A.length;

        int modulo = 1000000007;
        int[] freq = new int[B];

        for (int i=0; i<n; i++){
            freq[A[i] % B]++;
        }

        int ans = (freq[0]*(freq[0]-1))/2;
        ans %= modulo;
        int s = 1; int e = B-1;

        while (s <= e) {

            if (s==e){
                ans+= freq[s]*(freq[s]-1)/2;
                ans %= modulo;
            } else {
                ans+= freq[s]*freq[e];
                ans %= modulo;
            }

            s++;
            e--;
        }



        System.out.println(ans);
    }
}
