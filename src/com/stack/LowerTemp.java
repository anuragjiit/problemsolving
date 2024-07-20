/*

 */
package com.stack;

import java.util.Arrays;
import java.util.Stack;

public class LowerTemp {
    public static void main(String[] args) {
        int[] A = new int[]{73,72,75,71,77,70,79,80};
        int len = A.length;
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>(); // 73,72,75,71,77,70,79,80  need to find lower temp or cooler days
        /*
        ex - first day temp is 73, next day is 72..so cooler day is 1 ..at 72, next cooler day is 71.. so after 2 days.. so on
         */

        for (int i=len-1; i>=0; i--) {
            while(!stack.empty() && A[i] <= A[stack.peek()]){
                stack.pop();
            }
            if(stack.empty()){
                result[i] = 0;
            } else {
                result[i] = stack.peek()-i;
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(result));
    }
}
