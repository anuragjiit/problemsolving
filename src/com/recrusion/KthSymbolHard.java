package com.recrusion;


public class KthSymbolHard {

    public static int solve(int A, int B) {

        if (A==1) return 0;

        int value = solve(A-1, B/2);

        if (B%2==0) return value;

        return 1-value;

    }
    public static void main(String[] args) {

        System.out.println(solve(3,2));

    }
}
