package com.recrusion;

public class SumOfDigits {

    public static int digit(int A, int sum){
        if(A==0) return sum;

        sum+=A%10;

       return digit(A/10,sum);

    }

    public static void main(String[] args) {

        int A = 456;

        System.out.println(digit(A,0));


    }
}
