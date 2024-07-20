package com.recrusion;

public class reverseInt {

    public static int reverse(int A, int digits){

        if (A%10==A) return A;

        int remainder = A%10;
        return (remainder* (int) Math.pow(10,digits)) + reverse(A/10, --digits);
    }

    public static int reverse1(int A, int sum){

        if (A%10==0) return sum;

        int remainder = A%10;
        sum = sum*10+remainder;

        return reverse1(A/10, sum);
    }

    public static void main(String[] args) {

        int A = 1234;
        int digits = (int) Math.log10(A);
    //    System.out.println(digits+1);

        System.out.println(reverse(A, digits));

        System.out.println(reverse1(A,0));
    }
}
