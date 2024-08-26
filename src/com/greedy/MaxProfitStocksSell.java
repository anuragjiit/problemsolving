/*
Given A[n] represent stock price
ith element -> price of stock on ith day
find the max profit. You can do as many transactions as you want but engaging in multiple transaction is not allowed. (cant do same transaction multiple times)
buy in one day and sell in another day -> one transaction (it can be done multiple times with different stocks buy/sell)

Hints : maximise the profile -> so buy at low price and sell at max
 */
package com.greedy;

public class MaxProfitStocksSell {
    public static void main(String[] args) {
  //      int[] A = {7,1,5,3,6,4};
  //      int[] A = {1,2,3,4,5};
  //      int[] A = {2,6,10,14,11,16,21,18,20};
        int[] A = {10,6,5,16,21,30,23,20,26,28,35,30,21,15,17,19,18};
        int n = A.length;
        int i = 1;
        int profit = 0;
        int buyIdx = 0;
        int sellIdx = -1;

        while (i < n) {
            while ( i<n && A[i] <= A[i-1] ) {
                buyIdx = i;
                i += 1;
            }
            while ( i<n && A[i] > A[i-1] ) {
                sellIdx = i;
                i += 1;
            }

            if (sellIdx > buyIdx ) {
                profit+= A[sellIdx]-A[buyIdx];
            }
        }
        System.out.println(profit);
    }
}
