/*
Problem Description

Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.

NOTE: All the A integers will fit in 32-bit integers.



Problem Constraints

1 <= A <= 29500



Input Format

The only argument given is integer A.



Output Format

Return an integer array denoting the first positive A integers in ascending order containing only digits 1, 2 and 3.



Example Input

Input 1:

 A = 3

Input 2:

 A = 7



Example Output

Output 1:

 [1, 2, 3]

Output 2:

 [1, 2, 3, 11, 12, 13, 21]



Example Explanation

Explanation 1:

 Output denotes the first 3 integers that contains only digits 1, 2 and 3.

Explanation 2:

 Output denotes the first 7 integers that contains only digits 1, 2 and 3.
 */
package com.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Integer123 {
    public static void main(String[] args) {
        int A = 7;
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();


        if (A == 1){
            result.add(1);
            System.out.println(result);
            System.exit(0);
        }
        else if (A == 2) {
            result.add(1);
            result.add(2);
            System.out.println(result);
            System.exit(0);
        }
        else if (A == 3) {
            result.add(1);
            result.add(2);
            result.add(3);
            System.out.println(result);
            System.exit(0);
        }

        queue.add(1);
        queue.add(2);
        queue.add(3);
        result.add(1);
        result.add(2);
        result.add(3);

        int counter = 4;

        while(counter <= A){
            int first = 10*queue.remove()+1;
            int second = first+1;
            int third = second+1;

            result.add(first);
            if(counter==A){
                System.out.println(result);
                System.exit(0);
            }
            result.add(second);
            if( counter+1 == A){
                System.out.println(result);
                System.exit(0);
            }
            result.add(third);
            if( counter+2 == A){
                System.out.println(result);
                System.exit(0);
            }
            queue.add(first);
            queue.add(second);
            queue.add(third);
            counter+=3;
        }

    }
}
