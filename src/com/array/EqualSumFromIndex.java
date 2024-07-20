/*

1) Initialize leftsum  as 0
2) Get the total sum of the array as sum
3) Iterate through the array and for each index i, do following.
    a)  Update sum to get the right sum.
           sum = sum - arr[i]
       // sum is now right sum
    b) If leftsum is equal to sum, then return current index.
       // update leftsum for next iteration.
    c) leftsum = leftsum + arr[i]
4) return -1
// If we come out of loop without returning then
// there is no equilibrium index



Time Complexity : O(N)
Space Complexity : O(1)

 */

package com.array;

public class EqualSumFromIndex {

    public static void main(String[] args){
        int[] A = {-7,1,5,2,-4,3,0};
        // pf =   {-7,-6,-1,1,-3,0,0}

    /*    int length = A.length;
        int sum =0, leftSum=0;

        for (int i=0; i<length; i++){
            sum+= A[i];
        }

        for (int i=0; i<length; i++){
            sum = sum-A[i];

            if (leftSum==sum){
                System.out.println(i);
            } else leftSum = leftSum+A[i];
        } */

        int n = A.length;
        int[] pf = new int[n];

        pf[0]=A[0];
        for(int i=1;i<n; i++){
            pf[i]=pf[i-1]+A[i];
        }

        int minIndex = Integer.MAX_VALUE;
        int l=0;
        int r =0;
        for(int i=0; i<n; i++){
            if(i==0){
                l=0;
                r= pf[n-1]-pf[i];
            } else {
                l = pf[i-1];
                r = pf[n-1]-pf[i];
            }
            if (l==r){
                minIndex = Math.min(minIndex,i);
            }
        }
        if (minIndex==Integer.MAX_VALUE){
            System.out.println("-1");
        }

        System.out.println(minIndex);

    }
}
