package com.random;

public class MinimumSwaps {
    public static void main(String[] args){
   //     int[] A = {1, 12, 10, 3, 14, 10, 5}; int B = 8;
        int[] A = {5, 17, 100, 11};
        int B =20;

        int n = A.length;
        int count = 0;
        int badNum = 0;

        for (int i=0; i<n; i++){
            if (A[i]<=B) count++;
        }

        // or we can do here .. if n<=1 return 0// or count == n return 0;

        for (int i=0; i<count; i++){
            if (A[i]>B) badNum++;
        }

        int l = 1;
        int r = count;   // n =7.. count = 3.. [window 0-2] then 1-3
        int ans = Integer.MAX_VALUE;

        while (r <n){
            ans = Math.min(badNum, ans);
            if(A[r]>B) badNum++;
            if(A[l-1]>B) badNum--;

            r++;
            l++;
        }

        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }
}
