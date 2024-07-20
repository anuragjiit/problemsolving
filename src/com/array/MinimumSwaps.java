package com.array;

public class MinimumSwaps {

    public static void main(String[] args){
   //     int[] A = {1, 12, 10, 3, 14, 10, 5};
   //     int B = 8;
        int[] A = {5, 17, 100, 11};
        int B = 20;
        int l = 0,r = 0,count = 0,ans = 0,x = 0;
        int n = A.length;

        for (int i=0; i<n; i++ ){
            if (A[i]<=B) {count++;}
        }

        if (count <=1) System.out.println("0");
        else {
            while (r < count){
                if (A[r] > B){
                    x++;
                }
                r++;
            }
        }
        ans = x;
        while (r < n) {
            if (A[r]>B) {
                x++;
            }
            if (A[l]>B) {
                x--;
            }
            ans = Math.min(ans,x);
            l++;
            r++;
        }

        System.out.println(ans);


    }
}
