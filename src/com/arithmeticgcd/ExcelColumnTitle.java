/*
Problem Description

Given a positive integer A, return its corresponding column title as it appears in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB



Problem Constraints

1 <= A <= 109



Input Format

First and only argument of input contains single integer A



Output Format

Return a string denoting the corresponding title.



Example Input

Input 1:

A = 3

Input 2:


A = 27



Example Output

Output 1:

"C"

Output 2:

"AA"



Example Explanation

Explanation 1:


3 corrseponds to C.

Explanation 2:

    1 -> A,
    2 -> B,
    3 -> C,
    ...
    26 -> Z,
    27 -> AA,
    28 -> AB

 */
package com.arithmeticgcd;

public class ExcelColumnTitle {

    public static String subSet(String ans, int A, char[] chars){
        int limit = 26;

        if (A ==0) {
            return ans;
        }

        int temp = (A-1)%limit;

        if (temp >=0 && temp <26) ans = chars[(temp)]+ans;

        A=(A-1)/limit;

        return subSet(ans, A, chars);
    }

    public static void main(String[] args) {

        char[] chars = new char[26];
        String ans = "";
        chars[0] = 'A';
        int A = 943566;

        for (int i=1; i< 26; i++){
            chars[i] = (char) (chars[i-1]+1);
        }

        String ans1 = subSet(ans, A, chars);
        System.out.println(ans1);



    }
}
