/*
Problem Description

Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.

If such arrangement is not possible, it must be rearranged as the lowest possible order, i.e., sorted in ascending order.

NOTE:

    The replacement must be in-place, do not allocate extra memory.
    DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.



Problem Constraints

1 <= N <= 5 * 105

1 <= A[i] <= 109



Input Format

The first and the only argument of input has an array of integers, A.



Output Format

Return an array of integers, representing the next permutation of the given array.



Example Input

Input 1:

 A = [1, 2, 3]

Input 2:

 A = [3, 2, 1]



Example Output

Output 1:

 [1, 3, 2]

Output 2:

 [1, 2, 3]



Example Explanation

Explanation 1:

 Next permutaion of [1, 2, 3] will be [1, 3, 2].

Explanation 2:

 No arrangement is possible such that the number are arranged into the numerically next greater permutation of numbers.
 So will rearranges it in the lowest possible order.
 */
package com.random;

import java.util.Arrays;

public class NextPermutation {
    public static void reverse(int j, int n, int[] A) {
        while (j < n){
            int temp = A[n-1];
            A[n-1]= A[j];
            A[j] = temp;
            j++;
            n--;
        }

    }
    public static void main(String[] args){
     //   int[] A = {3,2,1};
     //   int[] A ={251,844,767, 778, 658, 337, 10, 252, 632, 262, 707, 506, 701, 475, 410, 696, 631, 903, 516, 149, 344, 101, 42, 891, 991};
        //251 844 767 778 658 337 10 252 632 262 707 506 701 475 410 696 631 903 516 149 344 101 42 991 891

        int[] A = {444, 994, 508, 72, 125, 299, 181, 238, 354, 223, 691, 249, 838, 890, 758, 675, 424, 199, 201, 788, 609, 582, 979,
                259, 901, 371, 766, 759, 983, 728, 220, 16, 158, 822, 515, 488, 846, 321, 908, 469, 84, 460, 961, 285, 417, 142,
                952, 626, 916, 247, 116, 975, 202, 734, 128, 312, 499, 274, 213, 208, 472, 265, 315, 335, 205, 784, 708,
                681, 160, 448, 365, 165, 190, 693, 606, 226, 351, 241, 526, 311, 164, 98, 422, 363, 103, 747, 507, 669, 153, 856, 701, 319, 695, 52};

        int n = A.length;
        int i = 0;

        for (i=n-2; i>=0; i--){
            if(A[i+1] > A[i]) {
                break;
            }
        }

        if (i==-1){
            i = 0;
            int j = n-1;
            while(i < j){
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
                i++;
                j--;
            }
            System.out.println(Arrays.toString(A));
        }

         int j =n-1;
        while (j >i ){
            if(A[j]>A[i]){
                int tmp = A[j];
                A[j] = A[i];
                A[i] = tmp;
                break;
            }
            j--;
        }

        // reverse i+1 to n-1
        i++;
        j =n-1;
        while(i < j){
            int temp = A[j];
            A[j] = A[i];
            A[i] = temp;
            i++;
            j--;
        }

    System.out.println(Arrays.toString(A));

    }
}
