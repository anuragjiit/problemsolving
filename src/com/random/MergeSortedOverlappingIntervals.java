package com.random;
import java.util.ArrayList;
import java.util.Arrays;


public class MergeSortedOverlappingIntervals {
    public static void main(String[] args) {
        int[][] A = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int a1 = A[0][0];
        int b1 = A[0][1];
        int n = A.length;
        int i = 1;

        while (i < n) {
            int a2 = A[i][0];
            int b2 = A[i][1];

            if (b1 >= a2) {
                b1 = Math.max(b1, b2);
            } else {
                // add a1 & a2 becomes a1
//                ArrayList<Integer> temp = new ArrayList<>();
//                temp.add(a1);
//                temp.add(b1);
//                ans.add(temp);
                ans.add(new ArrayList<Integer>(Arrays.asList(a1,b1)));

                a1 = a2;
                b1 = b2;
            }
            i++;
        }

//        ArrayList<Integer> temp = new ArrayList<>();
//        temp.add(a1);
//        temp.add(b1);
//        ans.add(temp);

        ans.add(new ArrayList<Integer>(Arrays.asList(a1,b1)));

        int[][] result = new int[ans.size()][2];



        System.out.println(ans.toArray());

        for (i = 0; i < ans.size(); i++) {
            result[i][0] = ans.get(i).get(0);
            result[i][1] = ans.get(i).get(1);
        }

        for (i = 0; i < result.length; i++) {
            System.out.println(result[i][0]);
            System.out.println(result[i][1]);
        }

        System.out.println("-------------------------");
        System.out.println(ans);


    }
}
