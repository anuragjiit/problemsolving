package com.array;
/*Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:

    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] consists of only lowercase English letters.
*/
import java.util.*;


public class LongestComPrefix {

    public static void main(String[] args){

        String[] strs = {"flower","flow","flight"};
   //    String[] strs = {"dog","racecar","car"};
        int arrSize = strs.length;
     //   StringBuilder str = new StringBuilder();
    //    ArrayList<String> strList = new ArrayList<String>();
        String str="";

        if (arrSize == 0 || arrSize == 1) System.out.println("");

        Arrays.sort(strs);

        int commCharsSize = Math.min(strs[0].length(), strs[arrSize-1].length());

        for (int i=0; i<commCharsSize; i++){
            if (strs[0].charAt(i) != strs[arrSize-1].charAt(i)) break;
            else str+=strs[0].charAt(i);
        }
        System.out.println(str);
    }
}
