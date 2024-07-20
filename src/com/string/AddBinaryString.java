/*
Problem Description
Given two binary strings A and B. Return their sum (also a binary string).



Problem Constraints

1 <= length of A <= 105

1 <= length of B <= 105

A and B are binary strings



Input Format

The two argument A and B are binary strings.



Output Format

Return a binary string denoting the sum of A and B



Example Input
Input 1:

A = "100"
B = "11"

Input 2:

A = "110"
B = "10"



Example Output
Output 1:

"111"

Output 2:

"1000"



 */

package com.string;

public class AddBinaryString {

    public static String appendZero(String C, int diff){
        StringBuilder sb = new StringBuilder(C);
   //     String result = "";
        for(int i=0; i < diff; i++){
            sb.insert(0,"0");
    //        sb.append("0");
    //        result+= "0";
        }
        return sb.toString();
  //      return (result+C);
    }

    public static void main(String[] args){

        String A = "110";
        String B = "10";

        int lenA = A.length();
        int lenB = B.length();
   //     String strB = "";
   //     String strA = "";

        if (lenA>lenB){
            B = appendZero(B, lenA-lenB);
        } else {
            A = appendZero(A, lenB-lenA);
        }

        int counter = A.length()-1;
        StringBuilder sb = new StringBuilder();

   //     String result = "";
        int carry = 0, sum = 0;

        for (int i=counter; i>=0; i--)
        {
            int strAInt = A.charAt(i) - '0';
            int strBInt = B.charAt(i) - '0';

            sum = strAInt+strBInt+carry;
            carry = sum/2;
            sb.insert(0, sum%2);
      //      result+= sum % 2;
        }

        if (carry != 0){
            sb.insert(0, carry);
      //      result+=carry;
        }

//        String ans = "";
//        for(int i=result.length()-1; i>=0; i--){
//            ans+=result.charAt(i);
//        }

        System.out.println(sb.toString());
    }
}
