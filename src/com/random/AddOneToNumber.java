/*
Problem Description

Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, the following are some good questions to ask :

    Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
    A: For the purpose of this question, YES
    Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
    A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.



Problem Constraints

1 <= size of the array <= 1000000



Input Format

First argument is an array of digits.



Output Format

Return the array of digits after adding one.



Example Input

Input 1:

[1, 2, 3]



Example Output

Output 1:

[1, 2, 4]



Example Explanation

Explanation 1:

Given vector is [1, 2, 3].
The returned vector should be [1, 2, 4] as 123 + 1 = 124.
 */

package com.random;

public class AddOneToNumber {
    public static void main(String[] args){
    //    int[] A = {9,9,9,9,9};
        int[] A = {0,0,3,7,6,4,0,5,5,5};
        int n = A.length;
        StringBuilder newNum = new StringBuilder();
        int num = A[n-1];
        int carry = (num+1)/10;
        num = (num+1)%10;
        newNum.append(num);
        while (n-2>=0){
            num = (A[n-2]+carry)%10;
            newNum.insert(0,num);
            carry = (A[n-2]+carry)/10;
            n--;
        }

        if (carry==1){
            newNum.insert(0,carry);
        }


        int count =0;

        for (int i=0; i<newNum.length(); i++){
            if (newNum.charAt(i)=='0') count++;
            else break;
        }

        String sum = newNum.delete(0,count).toString();
        int[] B = new int[sum.length()];
        for (int i=0; i<sum.length(); i++){
            B[i] = sum.charAt(i) - 48;
        }

        for (int i=0; i<sum.length(); i++){
            System.out.println(B[i]);
        }

    }
}
