package com.queue;

/*
Problem Description

Given an integer A, you have to find the Ath Perfect Number.

A Perfect Number has the following properties:

    It comprises only 1 and 2.
    The number of digits in a Perfect number is even.
    It is a palindrome number.

For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.



Problem Constraints

1 <= A <= 100000



Input Format

The only argument given is an integer A.



Output Format

Return a string that denotes the Ath Perfect Number.



Example Input

Input 1:

 A = 2

Input 2:

 A = 3



Example Output

Output 1:

 22

Output 2:

 1111



Example Explanation

Explanation 1:

First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221
Return the 2nd Perfect number.

Explanation 2:

First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221
Return the 3rd Perfect number.
 */
import java.util.LinkedList;
import java.util.Queue;

public class PerfectNumbers {
    public static void main(String[] args) {
        Queue<String> perfectNumQ = new LinkedList<>();
        int A = 15;
        String first = "1";
        String second = "2";
        perfectNumQ.add(first);
        perfectNumQ.add(second);
        int counter = 1;

        while (counter <= A) {
            String front = perfectNumQ.remove();
            StringBuilder sb = new StringBuilder(front);
            String palindrom = front + sb.reverse();
            if (counter == A) {
                System.out.println(palindrom);
                System.exit(0);
            } else {
                counter++;
            }
            perfectNumQ.add(front+first);
            perfectNumQ.add(front+second);
        }

    }
}
