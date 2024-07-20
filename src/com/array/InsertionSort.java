package com.array;

public class InsertionSort {
    public static void main(String[] args){
        int[] A =  { 12, 31, 25, 8, 32, 17 };
        int n = A.length, i =0;

        for (i=1; i< n; i++){
            int j = i-1;
            int temp = A[i];
            while( j >= 0 && A[j] >= temp ){    // temp is A[i]
                A[j+1] = A[j];
                j--;
            }
            A[j+1] = temp;
        }


        for (i=0; i< n; i++){
            System.out.println(A[i]);
        }
    }
}
