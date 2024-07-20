/*
Problem Description
You are given an array A of N integers.
Return a 2D array consisting of all the subarrays of the array

Note : The order of the subarrays in the resulting 2D array does not matter.


Problem Constraints
1 <= N <= 100
1 <= A[i] <= 105


Input Format
First argument A is an array of integers.


Output Format
Return a 2D array of integers in any order.


Example Input
Input 1:
A = [1, 2, 3]
Input 2:
A = [5, 2, 1, 4]


Example Output
Output 1:
[[1], [1, 2], [1, 2, 3], [2], [2, 3], [3]]
Output 2:
[[1 ], [1 4 ], [2 ], [2 1 ], [2 1 4 ], [4 ], [5 ], [5 2 ], [5 2 1 ], [5 2 1 4 ] ]


Example Explanation
For Input 1:
All the subarrays of the array are returned. There are a total of 6 subarrays.
For Input 2:
All the subarrays of the array are returned. There are a total of 10 subarrays.
 */
package com.array;

public class GenerateAllSubarrays {

    public static void main(String[] args){
     //   int[] A = {1,2,3};
        int[] A = {36,63,63,26,87,28,77,93,7};
        int n = A.length;
        int r = n*(n+1)/2;
        int[][] arr=new int[r][];
        int subarrayIndex = 0;

        for (int i=0; i<n;i++){
            for (int j=i; j<n; j++){

                int subarraySize = j - i + 1;   //
                arr[subarrayIndex] = new int[subarraySize];  // 0->1 , 1->2 ,2->3

                for(int k=i, l=0; k<=j; k++,l++){
                    arr[subarrayIndex][l]=A[k];   //arr[0][0] = 1, arr[1][0] = 1, arr[1][1]=2.. arr[2]={1,2,3}..arr[3]=2,arr[4]=2,3..arr[5]=3
                }
                subarrayIndex++;

            }

        }

        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                if (j < arr[i].length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.print("]");
            if (i < arr.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.print("]");

    }
}
//[[36] [36 63] [36 63 63] [36 63 63 26] [36 63 63 26 87] [36 63 63 26 87 28] [36 63 63 26 87 28 77] [36 63 63 26 87 28 77 93]
// [36 63 63 26 87 28 77 93 7] [63] [63 63] [63 63 26] [63 63 26 87] [63 63 26 87 28] [63 63 26 87 28 77] [63 63 26 87 28 77 93]
// [63 63 26 87 28 77 93 7] [63] [63 26] [63 26 87] [63 26 87 28] [63 26 87 28 77] [63 26 87 28 77 93] [63 26 87 28 77 93 7]
// [26] [26 87] [26 87 28] [26 87 28 77] [26 87 28 77 93] [26 87 28 77 93 7] [87] [87 28] [87 28 77] [87 28 77 93] [87 28 77 93 7]
// [28] [28 77] [28 77 93] [28 77 93 7] [77] [77 93] [77 93 7] [93] [93 7] [7]]