/*
Problem Description

An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each string may be an integer or an operator.

Note: Reverse Polish Notation is equivalent to Postfix Expression, where operators are written after their operands.



Problem Constraints

1 <= N <= 105



Input Format

The only argument given is string array A.



Output Format

Return the value of arithmetic expression formed using reverse Polish Notation.



Example Input
Input 1:

A =   ["2", "1", "+", "3", "*"]

Input 2:

A = ["4", "13", "5", "/", "+"]



Example Output
Output 1:

9

Output 2:

6



Example Explanation
Explaination 1:

starting from backside:
    * : () * ()
    3 : () * (3)
    + : (() + ()) * (3)
    1 : (() + (1)) * (3)
    2 : ((2) + (1)) * (3)
    ((2) + (1)) * (3) = 9

Explaination 2:

starting from backside:
    + : () + ()
    / : () + (() / ())
    5 : () + (() / (5))
    13 : () + ((13) / (5))
    4 : (4) + ((13) / (5))
    (4) + ((13) / (5)) = 6

 */
package com.stack;

import java.util.Stack;

public class EvaluateExpression {
    public static void main(String[] args) {
        String[] A =  {"4", "13", "5", "/", "+"};
     //   String[] A =  {"2", "2", "/"};
        String operator = "+-*/";
        int len = A.length;
        Stack<Integer> operands = new Stack<>();

        for(int i=0; i<len; i++) {
            String str = A[i];
            if(!operator.contains(str)){
                int num = Integer.parseInt(str);
                operands.push(num);
            } else {
                int firstEle = operands.isEmpty() ? 0:operands.pop();
                int secondEle = operands.isEmpty() ? 0:operands.pop();
                if(str.equals("+")){      // dont use str=="+" in String comparison.
                    operands.push(firstEle+secondEle);
                }
                else if(str.equals("*")){
                    operands.push(firstEle*secondEle);
                }
                else if(str.equals("-")){
                    operands.push(secondEle-firstEle);
                }
                else if(str.equals("/")){
                    operands.push(secondEle/firstEle);
                }
            }
        }
        if(operands.isEmpty()){
           System.out.println(0);
           System.exit(0);
        }
        System.out.println(operands.peek());
    }
}
