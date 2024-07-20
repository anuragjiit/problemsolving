package com.recrusion;

import java.util.Arrays;
import java.util.Optional;

public class SubSetsAnotherApproach {

    public static void main(String[] args) {
        int[] A = {3,2,1};
        Arrays.sort(A);

        int result[][] = helper(A);

        for(int i=0; i<result.length; i++) {
            System.out.println(Arrays.stream(result[i]).toArray());
        }

    }

    public static int[][] helper(int[] arr) {

        if(arr.length==1) {
            int[][] ans = new int[2][1];
            ans[0] = new int[]{};
            ans[1] = new int[]{arr[0]};
            return ans;
        }

        int[] arr1 = new int[arr.length-1];
        for (int i =1; i<arr.length; i++){
            arr1[i-1]= arr[i];
        }

        int[][] smallSet = helper(arr1);
        int[][] ans = new int[2*smallSet.length][];

        for (int i=0; i<smallSet.length; i++){
            ans[i] = smallSet[i];
        }
        for (int i=smallSet.length; i< ans.length; i++){
   //         ans[i] = new int[arr[0]][]{smallSet[i]};


        }

        return ans;
    }
}
