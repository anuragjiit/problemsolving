package com.random;

public class MaxSbArraySum {
    public static void main(String[] args){
       int[] A={-2, 1, 4, -3, -1, 2, 1, -5, 4}; // output ->6   A = [1, 2, 3, 4, -10] => output ->10

     //   int[] A={1, 2, 3, 4, -10};
     //   int[] A={5,6,7,-3,2,-10,-12,8,12,21,-4,7};  // output -> 44
     //   int[] A={-4,-3,-6,-9,-2};
    //     int[] A={0, 0, 1, 0, -1};

        // TC: O(n^2) .. SC : O(n)
  /*      int n= A.length, minIndex=0, maxIndex=0;
        int ans = Integer.MIN_VALUE;
        int[]pf = new int[n];
        pf[0]=A[0];
        for (int i=1;i<n;i++){
            pf[i]=pf[i-1]+A[i];
        }

        for (int i=0;i<n;i++){
            for (int j=i;j<n;j++){
                int sum=0;
                if(i==0){
                    sum = pf[j];
                } else {
                    sum = pf[j]-pf[i-1];
                }
                if (ans < sum){
                    ans = sum;
                    minIndex=i;
                    maxIndex = j;
                }
            }
        } */

        // TC: O(n) .. SC : O(1)

        int n= A.length;
        int sum = 0, minIndex=0, maxIndex=0;;
        int ans = Integer.MIN_VALUE;
      //  int previousMin = 0;
        int l=0, r=0;

        for (int i=0; i< n; i++){

            sum+=A[i];

            if (sum > ans){
                ans = sum;
                maxIndex = r;
                minIndex = l;
//                maxIndex=i;
//                minIndex = previousMin;
            }

            if (sum<=0){
                sum=0;
                l = l+1;
                r = r+1;
     //           previousMin = i!=n-1 ? i+1 : i;
            } else r+=1;

        }
        System.out.println(ans); //5

        System.out.println(minIndex);  //1
        System.out.println(maxIndex); //2
    }
}
