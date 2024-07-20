package com.array;

public class PrimeNumber {

    public static boolean prime(int n){
        boolean b=true;
        for (int i=2;i*i<=n;i++){
            if (n%i == 0){
                    b = false;
                }
            }
        return b;
    }
    public static void main(String[] args){

        int n = 5;
        if (n ==0 || n==1){
            System.out.println("false");
        }
        System.out.println(prime(n));
    }
}
