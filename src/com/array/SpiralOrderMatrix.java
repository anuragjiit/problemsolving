/*
Problem Description
Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order and return the generated square matrix.



Problem Constraints
1 <= A <= 1000



Input Format
First and only argument is integer A


Output Format
Return a 2-D matrix which consists of the elements added in spiral order.



Example Input
Input 1:

1
Input 2:

2
Input 3:

5


Example Output
Output 1:

[ [1] ]
Output 2:

[ [1, 2],
  [4, 3] ]
Output 2:

[ [1,   2,  3,  4, 5],
  [16, 17, 18, 19, 6],
  [15, 24, 25, 20, 7],
  [14, 23, 22, 21, 8],
  [13, 12, 11, 10, 9] ]
 */
package com.array;

import java.util.Scanner;

public class SpiralOrderMatrix {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int[][] arr = new int[A][A];
        int c= 0, r=0, value =1;

        while(A>1){
            for (int i=1; i<A; i++){
                arr[r][c]=value;
                c++;
                value++;
            }

            for (int i=1; i<A; i++){
                arr[r][c]=value;
                r++;
                value++;
            }

            for (int i=1; i<A; i++){
                arr[r][c]=value;
                c--;
                value++;
            }

            for (int i=1; i<A; i++){
                arr[r][c]=value;
                r--;
                value++;
            }
            A -= 2;
            r+=1;
            c+=1;
        }

        if(A==1) { arr[r][c]= value;}

        for (int i=0;i<arr.length;i++){
            for (int j=0; j<arr[i].length; j++){
                System.out.print("||"+arr[i][j]+"||");
            }
            System.out.println();
        }
    }
}
