package com.arithmeticgcd;

public class Factors {
    public static void main(String[] args) {
        int n = 24;
        int count=0;

        for(int i=1; i*i<=n;i++){
            if(n%i==0){
                if(n/i==i) count++;
                else count+=2;
            }
        }
        System.out.println(count);
    }
}
