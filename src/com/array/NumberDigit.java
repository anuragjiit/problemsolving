package com.array;

import java.util.Scanner;

public class NumberDigit {
    public static void main(String[] args) {
        System.out.print("Enter the number to find the digit : ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int digit = 0;
        while (number > 0){
            number /= 10;
            digit++;
        }
        System.out.println(String.format("Number of digit in given integer is : %d", digit));
    }
}
