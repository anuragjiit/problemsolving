package com.recrusion;

public class SampleTest1 {
    public static int func(int x, int n){
        if(n==0) return 1;

        else if (n%2==0) return func(x*x, n/2);

        else return x* func(x*x, (n-1)/2);
    }
    public static void main(String[] args) {
        int ans = func(2,10);
        System.out.println(ans);
    }
}

