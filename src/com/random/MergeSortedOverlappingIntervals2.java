/*
Problem Description

You have a set of non-overlapping intervals. You are given a new interval [start, end], insert this new interval into the set of intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.



Problem Constraints

0 <= |intervals| <= 105



Input Format

First argument is the vector of intervals

second argument is the new interval to be merged



Output Format

Return the vector of intervals after merging



Example Input

Input 1:

Given intervals [1, 3], [6, 9] insert and merge [2, 5] .

Input 2:

Given intervals [1, 3], [6, 9] insert and merge [2, 6] .



Example Output

Output 1:

 [ [1, 5], [6, 9] ]

Output 2:

 [ [1, 9] ]



Example Explanation

Explanation 1:

(2,5) does not completely merge the given intervals

Explanation 2:

(2,6) completely merges the given intervals

 */
package com.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeSortedOverlappingIntervals2 {
    public static void main(String[] args) {
        int[][] A = {{1,2},{3,6}};
        int[] B ={8,10};
//        int[][] A = {{1, 3}, {4, 7}, {10,14},{16,19},{21,24},{27,30}, {32,35}};
//        int[] B = {12,22};    // insert and merge  -> output : { {1,5}, {6,9} }


  //      ArrayList<int[]> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int n = A.length;
        int a2 = B[0];
        int b2 = B[1];



        for (int i=0;i<n;i++){
            int a1= A[i][0];
            int b1= A[i][1];


            if (a2>b1){     // first array becomes left element B remains the same
//                ArrayList<Integer> temp = new ArrayList<>();
//             //   ans.add(A[i]);
//                temp.add(a1);
//                temp.add(b1);
//                ans.add(temp);

                ans.add(new ArrayList<Integer>(Arrays.asList(a1,b1)));


            } else if(a1>b2) { // B becomes the left element and then array will come .. add B i..e add a2 b2 and all other Array A
//                ArrayList<Integer> temp1 = new ArrayList<>();
//                temp1.add(a2);
//                temp1.add(b2);
//   //             int[] tmp = {a2,b2};
//                ans.add(temp1);
                ans.add(new ArrayList<Integer>(Arrays.asList(a1,b1)));


      //          System.out.println(" B becomes left Side array, go on loop to add all Array " + temp1);


                while (i<n) {
                    a1 = A[i][0];
                    b1 = A[i][1];
//                    ArrayList<Integer> temp2 = new ArrayList<>();
//                    temp2.add(a1);
//                    temp2.add(b1);
//                    ans.add(temp2);
  //                  ans.add(A[i]);

                    ans.add(new ArrayList<Integer>(Arrays.asList(a1,b1)));
 //                   System.out.println(" Added all Array and Exit " +temp2);


                    i++;
                }



                int[][] result = new int[ans.size()][2];

           //     result = ans.toArray();
                for (int j = 0; j < ans.size(); j++) {
                    result[j][0] = ans.get(j).get(0);
                    result[j][1] = ans.get(j).get(1);
                }

                for (int j=0; j<result.length; j++){

                    System.out.println(result[j][0]);
                    System.out.println(result[j][1]);
                }


                System.out.println(ans);
                System.exit(0);
            } else {
                a2 = Math.min(a1,a2);
                b2 = Math.max(b1,b2);


            }


        }

//        ArrayList<Integer> temp3 = new ArrayList<>();
//        System.out.println(" new temp3 " +temp3);
//        temp3.add(a2);
//        temp3.add(b2);
////        int[] tmp = {a2,b2};
//        ans.add(temp3);

        ans.add(new ArrayList<Integer>(Arrays.asList(a2,b2)));

//        int[][] result = ans.toArray(new int[ans.size()][]);
//
//        for (int j=0; j<result.length; j++){
//            System.out.println(result[j][0]);
//            System.out.println(result[j][1]);
//        }

   //     System.out.println(temp3);

        System.out.println("-------------------------");
        System.out.println(ans);

        System.out.println("-------------------------");


        int[][] result = new int[ans.size()][2]; // required as original prob is to return [][]int not arraylist


        for (int j = 0; j < ans.size(); j++) {
            result[j][0] = ans.get(j).get(0);
            result[j][1] = ans.get(j).get(1);
        }

        for (int j=0; j<result.length; j++){
            System.out.println(Arrays.toString(result[j]));
        }


    }
}
