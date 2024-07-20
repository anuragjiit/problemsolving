/*
Problem Description

You are given a function isalpha() consisting of a character array A.

Return 1 if all the characters of a character array are alphanumeric (a-z, A-Z, and 0-9) else, return 0.



Problem Constraints

1 <= |A| <= 105



Input Format

Only argument is a character array A.



Output Format

Return 1 if all the characters of the character array are alphanumeric (a-z, A-Z and 0-9), else return 0.



Example Input

Input 1:

 A = ['S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0']

Input 2:

 A = ['S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0']



Example Output

Output 1:

 1

Output 2:

 0
 */
package com.string;

public class Isalnum {
    public static void main(String[] args){
        char[] A = {'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '9'};
        int count = 0;
        for (char ch : A){
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') ){
                count = 1;
            } else {
                count = 0;
                break;
            }
        }
        System.out.println(count);
    }
}
