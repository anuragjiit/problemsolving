/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer.
 */
package com.array;


import java.util.Scanner;
import java.util.HashMap;

public class RomanInt {
    public static void main(String[] args){
        HashMap<String, Integer> romanVaule = new HashMap<String, Integer>();
        romanVaule.put("I", 1);
        romanVaule.put("V", 5);
        romanVaule.put("X", 10);
        romanVaule.put("L", 50);
        romanVaule.put("C", 100);
        romanVaule.put("D", 500);
        romanVaule.put("M", 1000);

        int sum = 0, i = 0;
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        while (i < str.length()){
              if ((i+1 < str.length()) && romanVaule.get(String.valueOf(str.charAt(i))) < romanVaule.get(String.valueOf(str.charAt(i+1))) ) {
                   sum += (romanVaule.get(String.valueOf(str.charAt(i+1))) - romanVaule.get(String.valueOf(str.charAt(i))));
                    i+= 2;
                }
                else {
                    sum += romanVaule.get(String.valueOf(str.charAt(i)));
                  i+= 1;
              }
            }

        System.out.println(sum);
    }
}
