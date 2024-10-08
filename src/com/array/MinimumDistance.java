/*
Problem Description

Given a string A which contains only three characters {'x', 'o', '.'}.

Find minimum possible distance between any pair of 'x' and 'o' in the string.

Distance is defined as the absolute difference between the index of 'x' and 'o'.

NOTE: If there is no such pair return -1.



Problem Constraints

1 <= |A| <= 105


Input Format

First and only argument is a string A.


Output Format

Return an integer denoting the minimum possible distance.


Example Input

Input 1:

 A = "x...o.x...o"

Input 2:

 A = "xxx...xxx"



Example Output

Output 1:

 2

Output 2:

 -1



Example Explanation

Explanation 1:

 Minimum distance is between 'o' at index 5 and 'x' at index 7 i.e |7 - 5| = 2

Explanation 2:

 There is no such pair, return -1.
 */
package com.array;

public class MinimumDistance {

    public static void main(String[] args){
        String A = "x...x.x";
        int oo=-1, xx = -1, min=Integer.MAX_VALUE;
        for (int i=0;i<A.length();i++){
            if (A.charAt(i)=='x'){
                xx = i;
            }
            else if (A.charAt(i)=='o'){
                oo = i;
            }
            if((xx!=-1) && (oo!=-1)){
                min = Math.min(min, Math.abs(oo-xx));
            }
        }
        if  ((xx==-1)||(oo==-1)) {
            min=-1;
        }

         System.out.println(min);
    }


}
