/*
Problem Description

There are two sorted arrays A and B of sizes N and M respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

NOTE:

    The overall run time complexity should be O(log(m+n)).
    IF the number of elements in the merged array is even, then the median is the average of (n/2)th and (n/2+1)th element. For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.



Problem Constraints

1 <= N + M <= 2*106



Input Format

The first argument is an integer array A of size N.
The second argument is an integer array B of size M.



Output Format

Return a decimal value denoting the median of two sorted arrays.



Example Input

Input 1:

 A = [1, 4, 5]
 B = [2, 3]

Input 2:

 A = [1, 2, 3]
 B = [4]



Example Output

Output 1:

 3.0

Output 2:

 2.5



Example Explanation

Explanation 1:

 The median of both the sorted arrays will be 3.0.

Explanation 2:

 The median of both the sorted arrays will be (2+3)/2 = 2.5.
 */
package com.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class MedianOfTwoSortedArray {
    public static void main(String[] args) {

        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(4));

        if (a.size() > b.size()) {
            ArrayList<Integer> temp = new ArrayList<>(a);
            //      temp = A;
            a = b;  // A is smaller in size
            b = temp;
        }

//        if(a.size()>b.size()){
//            return findMedianSortedArrays(b,a);
//        }
        int n1 = a.size();
        int n2 = b.size();

        int s = 0;
        int e = a.size();

        while (s <= e) {
            int partitionX = (e - s) / 2 + s;          // elements from Array A   index value
            int partitionY = (n1 + n2 + 1) / 2 - partitionX;   // elements from Array B   index value

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : a.get(partitionX - 1);
            int minRightX = (partitionX == n1) ? Integer.MAX_VALUE : a.get(partitionX);

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : b.get(partitionY - 1);
            int minRightY = (partitionY == n2) ? Integer.MAX_VALUE : b.get(partitionY);


            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {

                if ((n1 + n2) % 2 == 0) {
                    System.out.println((double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightY, minRightX)) / 2);
                    System.exit(0);
                } else {
                    System.out.println((double) (Math.max(maxLeftX, maxLeftY)));
                    System.exit(0);
                }

            } else if (maxLeftX > minRightY) {
                e = partitionX - 1;
            } else {
                s = partitionX + 1;
            }
        }

    }
}

