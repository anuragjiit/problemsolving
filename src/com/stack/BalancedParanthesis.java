package com.stack;
/*
Problem Description

Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.

Refer to the examples for more clarity.



Problem Constraints

1 <= |A| <= 100



Input Format

The first and the only argument of input contains the string A having the parenthesis sequence.



Output Format

Return 0 if the parenthesis sequence is not balanced.

Return 1 if the parenthesis sequence is balanced.



Example Input

Input 1:

 A = {([])}

Input 2:

 A = (){

Input 3:

 A = ()[]



Example Output

Output 1:

 1

Output 2:

 0

Output 3:

 1
 */
import java.util.Stack;

public class BalancedParanthesis {
    public static void main(String[] args) {
        String A = "{([])}";
    //    String A = "(){";
    //    String A = "()[]";
        int length = A.length();
        Stack<Character> paranthesis = new Stack<>();

        for(int i=0; i<length; i++){
            char ch = A.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[') {
                paranthesis.push(ch);
            } else {

                if(!paranthesis.isEmpty()){
                    char stackChar = paranthesis.pop();
                    if(!isValid(stackChar, ch)){
                        System.out.println("0 -> parenthesis sequence is not balanced");
                        System.exit(0);
                    }
                } else {
                    System.out.println("0 -> parenthesis sequence is not balanced");
                    System.exit(0);
                }
            /*    if(paranthesis.isEmpty()){
                    System.out.println("0 -> parenthesis sequence is not balanced");
                    System.exit(0);
                }
                char stackChar = paranthesis.pop();
                if(!isValid(stackChar, ch)){
                    System.out.println("0 -> parenthesis sequence is not balanced");
                    System.exit(0);
                } */
            }
        }

        if(!paranthesis.isEmpty()){
            System.out.println(0);
            System.exit(0);
        }
        System.out.println("1 -> parenthesis sequence is balanced");
    }

    public static boolean isValid(char stackChar, char ch){
        if( (stackChar=='(' && ch==')') || (stackChar=='{' && ch=='}') || (stackChar=='[' && ch==']')) {
            return true;
        }
        return false;
    }
}
