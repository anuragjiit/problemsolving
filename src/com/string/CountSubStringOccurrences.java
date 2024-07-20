/*
Problem Description

Find the number of occurrences of bob in string A consisting of lowercase English alphabets.



Problem Constraints
1 <= |A| <= 1000



Input Format
The first and only argument contains the string A, consisting of lowercase English alphabets.



Output Format
Return an integer containing the answer.



Example Input

Input 1:

  "abobc"

Input 2:

  "bobob"



Example Output

Output 1:

  1

Output 2:

  2



Example Explanation

Explanation 1:

  The only occurrence is at second position.

Explanation 2:

  Bob occures at first and third position.

 */

package com.string;

public class CountSubStringOccurrences {

    public static void main(String[] args){
        String A = "bobob";
        int n = A.length();   //10
        String find = "bob";  //3
        int n1 = find.length();
        int count = 0;

        for (int i=0; i<=(n-n1); i++){
            if (A.charAt(i)=='b' && A.charAt(i+1)=='o' && A.charAt(i+2)=='b'){
    //        if (A.substring(i,i+n1).contains(find)){   //0,3 ..
                count++;   //1
            }
        }
        System.out.println(count);
    }
}
