/*
Sort an array in increasing order using heap
intput arr[] = {13,14,7,6,10,2,5,8,3,1}
non leaf nodes = 0 to 4th index i..e total 5 nodes ..i.e  n-1/2

TC : nlogn
 */
package com.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SortArrayUsingHeap {
    public static void main(String[] args) {
        int[] arr = new int[] {13,14,7,6,10,2,5,8,3,1};
        int n = arr.length;

        while (n > 0) {
            downheapify(arr,0, n);
            swap(arr,0, n-1);
            n--;
        }
        System.out.println(Arrays.toString(arr));
    }

    static void downheapify(int[] arr, int i, int j) {
            while (i < j) {
                int leftChild = 2*i+1;
                int rightChild = 2*i+2;
                int x = arr[i];

                if (leftChild < j) {
                    x = Math.max(x, arr[leftChild]);
                }
                if (rightChild < j) {
                    x = Math.max(x, arr[rightChild]);
                }
                if (arr[i]==x) {
                    break;
                }
                if (x == arr[leftChild]) {
                    swap(arr, i, leftChild);
                    i = leftChild;
                } else {
                    swap(arr, i, rightChild);
                    i = rightChild;
                }
            }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
