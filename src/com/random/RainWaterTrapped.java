/*

 */
package com.random;

public class RainWaterTrapped {
    public static int[] prefixMax(int[] A){
        int n = A.length;
        int[] pre = new int[n];
        pre[0] = A[0];   //{0,1,0,2,1,0,1,3,2,1,2,1}
        for (int i=1;i<n;i++){
            if(pre[i-1]>A[i]){
                pre[i]=pre[i-1];
            } else pre[i]=A[i];
        }
        return pre;
    }

    public static int[] sufixMax(int[] A){
        int n = A.length;
        int[] pre = new int[n];
        pre[n-1] = A[n-1];
        for (int i=n-2;i>=0;i--){
            if(pre[i+1]>A[i]){
                pre[i]=pre[i+1];
            } else pre[i]=A[i];
        }
        return pre;
    }

    public static void main(String[] args){
        int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
        int n = A.length;
        int[] lMax = prefixMax(A);
        int[] rMax = sufixMax(A);
        int ans =0;


        for(int i =1; i<n-1; i++){
            int maxL = lMax[i-1];
            int maxR = rMax[i+1];

            int water = Math.min(maxR,maxL)-A[i];

            if (water < 0){
                water = 0;
            }
            ans+=water;
        }

        System.out.println(ans);

    }
}
