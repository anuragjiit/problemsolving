/*
Given a string s, return the longest
palindromic
substring
in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

Constraints:

    1 <= s.length <= 1000
    s consist of only digits and English letters.
 */
package com.array;

public class LongestPalindromic {

    public static void main(String[] args){
        String s = "aba";
        int maxLen =1;
        String maxStr = s.substring(0, 1);
      //  System.out.println(maxStr);

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + maxLen; j <= s.length(); j++) {
                if (isPalindromic(s.substring(i, j))) {
                    maxLen = j - i;
                    maxStr = s.substring(i, j);
                }
            }
        }
        System.out.println(maxStr);
      /*  String str = "cbbd";
        //ccc , ccd , aaa, acc
        String tmp ="", tmp1 = "";
        int endIndex = str.length();

        if (str.length() == 1){
            System.out.println(str);
        } else {
            for (int startIndex =0;startIndex<endIndex;startIndex++){
                tmp = isPalindromic(str.substring(startIndex,endIndex));
                if (tmp.length()>0) break;
            }

            for (;endIndex>1;endIndex--){
                tmp1 = isPalindromic(str.substring(0,endIndex));
                if (tmp1.length()>0) break;
            }

            if (tmp.length() > tmp1.length()){
                System.out.println("Longest Palindromic substring count : " + tmp.length());
                System.out.println("Longest Palindromic substring : " + tmp);
            } else {
                System.out.println("Longest Palindromic substring count : " + tmp1.length());
                System.out.println("Longest Palindromic substring : " + tmp1);
            }*/
        }



    /*    while (startIndex+2!=endIndex){
            tmp = str.substring(startIndex,endIndex);
            if (isPalindromic(tmp)){
                subStrLength = tmp.length();
                System.out.println("Longest Palindromic substring count : " + subStrLength);
                System.out.println("Longest Palindromic substring : " + tmp);
                break;
            } else {
                endIndex -=1;
            }
        }
        startIndex = 1;
        endIndex = str.length();

        while (startIndex!=endIndex-2){
            tmp1 = str.substring(startIndex,endIndex);
            if (isPalindromic(tmp1)){
                subStrLength = tmp1.length();
                System.out.println("Longest Palindromic substring count : " + subStrLength);
                System.out.println("Longest Palindromic substring : " + tmp);
                break;
            } else {
                startIndex +=1;
            }
        }*/
    static boolean isPalindromic(String str){
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    }



