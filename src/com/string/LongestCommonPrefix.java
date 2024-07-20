/*
Problem Description

Given the array of strings A, you need to find the longest string S, which is the prefix of ALL the strings in the array.

The longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".



Problem Constraints

0 <= sum of length of all strings <= 1000000



Input Format

The only argument given is an array of strings A.



Output Format

Return the longest common prefix of all strings in A.



Example Input

Input 1:

A = ["abcdefgh", "aefghijk", "abcefgh"]

Input 2:

A = ["abab", "ab", "abcd"];



Example Output

Output 1:

"a"

Output 2:

"ab"



Example Explanation

Explanation 1:

Longest common prefix of all the strings is "a".

Explanation 2:

Longest common prefix of all the strings is "ab".
 */
package com.string;

public class LongestCommonPrefix {
    public static void main(String[] args){
        String[] A = {"abcdefgh", "aefghijk", "abcefgh"};
    //    String[] A = {"abcd", "abcd", "abdc"};
        int n = A.length;
        int min = Integer.MAX_VALUE;

        String minStr ="";
        String ans = "";

        // Find minimum length String for Prefix as Common prefix cant be longer than minimum String in Array

        for (int i =0; i< n ; i++){
            if (A[i].length() < min) {
                min = A[i].length();
                minStr = A[i];
            }
        }

        // Loop through the string and compare each chars of min String to Array

        for (int i =0; i<minStr.length(); i++){
            char ch = minStr.charAt(i);     // each char of Min length String
            int count = 0;
            for (String str : A){          // Iterate through String Array
                if (str.charAt(i)!=ch){
                    System.out.println(ans);
                   System.exit(0);
                } else {
                    count++;    // If equal, increase the count top 1 i.e. found the common Prefix in one of String array
                }
                if (count == n) {   // If found in all the String of array, add the char to ans and loop to next
                    ans+=ch;
                }
            }

        }

        System.out.println(ans);
    }
}
