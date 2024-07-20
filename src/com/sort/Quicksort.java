// worst case TC is n^2 .. best case is nlogn .. so if Array lenght is more than 10^4 i.e 10^5 .. we will get TLE

package com.sort;

import java.util.Arrays;

public class Quicksort  {

    public static int partition(int[]A , int s, int e){
        int p = A[s];
        int i = s+1;
        int j = e;

        while (i<=j){
            if(A[i]<p) i++;
            else if(A[j]>p) j--;
            else {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
                j--;
            }
        }

        int temp = A[s];
        A[s] = A[j];
        A[j] = temp;

        return j;

    }

    public static void quickSort(int[]A , int s, int e){
        if(s>=e) return;
        int p = partition(A, s, e);
        quickSort(A, s, p-1);
        quickSort(A, p+1, e);

    }

    public static void main(String[] args) {

        int[] A = new int[]{0, 1, 2, 0, 1, 2};
        int n = A.length-1;

        quickSort(A,0,n);

        System.out.println(Arrays.toString(A));
    }
}
