/*
Problem Description

Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single integer "-1".

First sub-array means the sub-array for which starting index in minimum.



Problem Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9



Input Format

The first argument given is the integer array A.

The second argument given is integer B.



Output Format

Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single integer "-1".



Example Input

Input 1:

 A = [1, 2, 3, 4, 5]
 B = 5

Input 2:

 A = [5, 10, 20, 100, 105]
 B = 110



Example Output

Output 1:

 [2, 3]

Output 2:

 [-1]



Example Explanation

Explanation 1:

 [2, 3] sums up to 5.

Explanation 2:

 No subarray sums up to required number.

 */
package com.twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] inputArray = new int[]{5, 10, 20, 100, 105};  // it has only positive number & min value is 1
        int sumCheck = 110;

        // Try solution with Prefix Sum .. did not work out for hard test cases


  /*      long[] pf = new long[inputArray.length];   // it will be always in increasing order
  //      long sum = 0L;
        pf[0] = inputArray[0];

        for(int i=1; i<inputArray.length; i++){
            pf[i] = pf[i-1]+inputArray[i];     // 1,3,6,10,15
        }

        int leftPointer = 0;
        int rightPointer = 1;
        boolean isFound = false;

        while (rightPointer<inputArray.length){
            long diff = pf[rightPointer]-pf[leftPointer];
            if(diff<sumCheck){
                rightPointer++;
            } else if (diff>sumCheck){
                leftPointer++;
            } else {
                isFound = true;
                break;
            }
        }

        if(isFound){
            int[] answer = new int[rightPointer-leftPointer];
            int counter = 0;

            while (leftPointer<rightPointer){
                answer[counter] = inputArray[leftPointer+1];
                counter++;
                leftPointer++;
            }
            System.out.println(Arrays.toString(answer));
            System.exit(0);
        }


        System.out.println(Arrays.toString(new int[]{-1})); */


       // input array is not sorted .. else it can tried with Binary search to reduce the SC
           // solution with hashmap

        Map<Long,Integer> sumMap = new HashMap<>();
        sumMap.put(0L,-1);
        Long sum = 0L;
        int startIndex = -1;
        int endIndex = -1;

        for(int i=0; i<inputArray.length; i++){
            sum+=inputArray[i];
            if(sumMap.containsKey(sum-sumCheck)){
                startIndex = sumMap.get(sum-sumCheck)+1;
                endIndex = i;
                break;
            }
            else {
                sumMap.put(sum,i);
            }
        }

        if(startIndex==-1) {
            System.out.println(Arrays.toString(new int[]{-1}));
            System.exit(0);
        }

        int[] answer = new int[endIndex-startIndex+1];
        int counter = 0;

        while (startIndex<=endIndex){
            answer[counter] = inputArray[startIndex];
            counter++;
            startIndex++;
        }

      System.out.println(Arrays.toString(answer));

    }
}
