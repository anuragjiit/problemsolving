
//Write a program to find the difference between the sum of all even elements and the sum of all odd elements from the given array, A.

package com.array;

public class Arr5 {
    public static void main(String[] args){
        int[] A = {1,2,3,4,5,6,7,8};
        int evenSum = 0, oddSum = 0;

            for (int i = 0; i< A.length; i++){
                if (A[i] %2 == 0) {
                    evenSum += A[i];
                }
                else oddSum+=A[i];
            }

    System.out.println(evenSum-oddSum);


    }
}
