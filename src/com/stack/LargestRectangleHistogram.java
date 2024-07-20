/*
Problem Description

Given an array of integers A.

A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.

Find the area of the largest rectangle formed by the histogram.



Problem Constraints

1 <= |A| <= 100000

1 <= A[i] <= 10000



Input Format

The only argument given is the integer array A.



Output Format

Return the area of the largest rectangle in the histogram.



Example Input

Input 1:

 A = [2, 1, 5, 6, 2, 3]

Input 2:

 A = [2]



Example Output

Output 1:

 10

Output 2:

 2



Example Explanation

Explanation 1:

The largest rectangle has area = 10 unit. Formed by A[3] to A[4].

Explanation 2:

Largest rectangle has area 2.
 */
package com.stack;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleHistogram {
    public static int[] nearestLeft(int[] arr) {
        int len = arr.length;
        int[] result = new int[arr.length];

        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<len; i++) {
            while( !stack.isEmpty() && arr[i] <= arr[stack.peek()] ) {
                stack.pop();
            }

            if(!stack.isEmpty()){
                result[i] = stack.peek();
            } else {
                result[i] = -1;
            }

            stack.push(i);
        }
        return result;
    }

    public static int[] nearestRight(int[] arr) {
        int len = arr.length;
        int[] result = new int[arr.length];

        Stack<Integer> stack = new Stack<>();

        for (int i=len-1; i>=0; i--) {
            while( !stack.isEmpty() && arr[i] <= arr[stack.peek()] ) {
                stack.pop();
            }

            if(!stack.isEmpty()){
                result[i] = stack.peek();
            } else {
                result[i] = len;
            }

            stack.push(i);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 6, 2, 3};
        int[] left = nearestLeft(arr);
        int[] right = nearestRight(arr);
        int area = 0;

        for (int i=0; i<arr.length; i++) {
            int height = arr[i];
            int width = right[i]-(left[i]+1);
            area = Math.max(area,height * width);
        }
        System.out.println(area);
    }
}
