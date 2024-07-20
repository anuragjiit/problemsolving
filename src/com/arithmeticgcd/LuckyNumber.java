package com.arithmeticgcd;

public class LuckyNumber {
    public static void main(String[] args) {
        int A= 8;
        int ans = 0;
        boolean[] p = new boolean[A+1];
        for (int i=2; i<=A; i++){
            p[i] = true;
        }

        for (int i=2; i*i<=A; i++){

            for (int j = i*i; j<=A; j=j+i) {
                if(p[i]==true){
                    p[j] = false;
                }
            }
        }


        for (int i=2; i<=A; i++){  // 2 to 12 .. 2,3,4,5,6,7,8
            int count = 0;

            for (int j=2; j<=i; j++) {    // false. false , true, true, false, true, false, true, flase, false, flase, true, flase

                if(p[j]==true && i%j==0) count++;

            }

            if (count == 2) ans++;

        }


        System.out.println(ans);
    }
}
