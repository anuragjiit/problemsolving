
package com.array;

import java.util.Scanner;

public class MaxInt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers to find the largest number ");
        int n = sc.nextInt();
        int maxIntValue = Integer.MIN_VALUE;
        System.out.println(String.format("Enter %d integers to find the largest among number :", n));
        for (int i =0; i< n; i++){
            int number = sc.nextInt();
            maxIntValue = (maxIntValue <= number) ? number : maxIntValue;
        }
        System.out.println("Max integer value is :" + maxIntValue);
    }
}
