package com.stack;

import java.util.Stack;

public class InfixtoPostfix {

    public static void main(String[] args) {
   //     String A = "a+b*(c^d-e)^(f+g*h)-i";
        String A = "x^y/(a*z)+b";
        Stack<Character> stack = new Stack<>();
        StringBuilder postFix = new StringBuilder();
        int len = A.length();

        for (int i = 0; i < len; i++) {
            char ch = A.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            }
            else if (isOperator(ch)) {
                if (ch == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                            postFix.append(stack.pop());
                    }
                    stack.pop();         // removing '(' from the stack
                } else {
                    // Addding high or equal precedence operators from Stack to postFix String
                    while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                        postFix.append(stack.pop());
                    }
                    stack.push(ch);
                }
            }
            else {
                postFix.append(ch);
                }
            }
        while (!stack.isEmpty()) {
            postFix.append(stack.pop());
        }
        System.out.println(postFix.toString());
    }


    public static boolean isOperator(char ch){  //xy^az*/b+
        String operator = "+-*/^)";
        if (operator.indexOf(ch)!=-1){
  //      if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch == ')'){
            return true;
        }
        return false;
    }

    public static int precedence(char ch){
        switch (ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

}
