/*
Given A[n] and an integer B. find if there exits a subset with target sum B. if yes, return 1 else 0

 */
package com.dynamicprograming;

public class TargetSumSubsets {

    public static void main(String[] args) {
        int[] arr = {3,34,4,12,6,2,5};
        int sum = 9;
        boolean[][] dpPrevious = new boolean[1][sum+1];
        boolean[][] dpCurent = new boolean[1][sum+1];
//        boolean[][] dp = new boolean[arr.length+1][sum+1];
        dpPrevious[0][0] = true;  // base case when we pick 0 element and sum is 0. so its true

//        for (int i=0; i<1; i++) {
//            dpPrevious[i][0] = true;
//        }


        System.out.println(targetSum(arr, 0, sum, dpPrevious, dpCurent) ? 1:0);
    }

    private static boolean targetSum(int[] arr, int idx, int target, boolean[][] dpPrevious, boolean[][] dpCurrent) {
        boolean inclusive = false;
        boolean exclusive;
        for (int i=1; i<=arr.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j - arr[i - 1] >= 0) {
                    inclusive = dpPrevious[0][j - arr[i - 1]];
                }
                exclusive = dpPrevious[0][j];
                dpCurrent[0][j] = inclusive || exclusive;
                dpPrevious[0][j] = dpCurrent[0][j];
            }
        }

        return dpCurrent[0][target];
    }
}
