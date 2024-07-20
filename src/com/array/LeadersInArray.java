/*
Problem Description
Given an integer array A containing N distinct integers, you have to find all the leaders in array A. An element is a leader if it is strictly greater than all the elements to its right side.

NOTE: The rightmost element is always a leader.

Problem Constraints
1 <= N <= 105
1 <= A[i] <= 108

Input Format
There is a single input argument which a integer array A

Output Format
Return an integer array denoting all the leader elements of the array.

Ans :

Scan from right) Optimized Approach

Note that for an element to be greater than all the elements towards its right , it just needs to be greater than the maximum element towards its right.
Keep a variable ‘mx’ which stores the maximum till now and initialize it with the last element of the array and also add the last element to our answer array. Iterate from n-2 to 0 , at every index we check if that number is greater than the variable mx. If it is we add the element to our answer array and change mx to that variable.

Time Complexity: O(N)
Space Complexity: O(1)
 */

package com.array;

import java.util.ArrayList;

public class LeadersInArray {

    public static void main(String[] args){
        int[] A = {16, 17, 4, 3, 5, 2};
        ArrayList<Integer> arrList = new ArrayList<>();
        int n=A.length;
        int max =A[n-1];
        arrList.add(max);

        for (int i=n-2; i>=0; i--){
            if (A[i]>max){
                arrList.add(A[i]);
                max = A[i];
            }
        }

        /*required if function has to return int array not integer
        int[] B = new int[arrList.size()];
        int len = arrList.size();
        for (int i=0; i<len; i++){
            B[i] = arrList.get(i);
        } */

        for (int i=0; i<arrList.size(); i++){
            System.out.println(arrList.get(i));
        }
    }
}
