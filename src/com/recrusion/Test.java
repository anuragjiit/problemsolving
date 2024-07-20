package com.recrusion;


public class Test {
    public static int helper(int n, int k){
        if(n==1) return 0;
        return (helper((n-1),k)+k)%n;
    }

    public static int function(int n, int k){
        return helper(n,k)+1;
    }
    public static void main(String[] args) {
        int n =5;
        int k =2;
        System.out.println(function(n,k));
    }
}
