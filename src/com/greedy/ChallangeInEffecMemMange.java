/*
Problem Description

In the recent expansion into grocery delivery, Flipkart faces a crucial challenge in effective inventory management. Each grocery item on the platform carries its own expiration date and profit margin, represented by two arrays, A and B of size N. A[i] denotes the time left before expiration date for the ith item, and B[i] denotes profit margin for the ith item. To mitigate potential losses due to expiring items, Flipkart is seeking a strategic solution.

The objective is to identify a method to strategically buy certain items, ensuring they are sold before their expiration date, thereby maximizing overall profit. Can you assist Flipkart in developing an innovative approach to optimize their grocery inventory and enhance profitability?

Your task is to find the maximum profit one can earn by buying groceries considering that you can only buy one grocery item at a time.

NOTE:

    You can assume that it takes 1 minute to buy a grocery item, so you can only buy the ith grocery item when the current time <= A[i] - 1.
    You can start buying from day = 0.
    Return your answer modulo 10^9 + 7.



Problem Constraints

1 <= N <= 10^5
1 <= A[i] <= 10^9
0 <= B[i] <= 10^9



Input Format

The first argument is an integer array A represents the deadline for buying the grocery items.
The second argument is an integer array B represents the profit obtained after buying the grocery items.



Output Format

Return an integer denoting the maximum profit you can earn.



Example Input

Input 1:

 A = [1, 3, 2, 3, 3]
 B = [5, 6, 1, 3, 9]

Input 2:

 A = [3, 8, 7, 5]
 B = [3, 1, 7, 19]



Example Output

Output 1:

 20

Output 2:

 30



Example Explanation

Explanation 1:

 At time 0, buy item with profit 5.
 At time 1, buy item with profit 6.
 At time 2, buy item with profit 9.
 At time = 3 or after , you can't buy any item, as there is no item with deadline >= 4.
 So, total profit that one can earn is 20.

Explanation 2:

 At time 0, buy item with profit 3.
 At time 1, buy item with profit 1.
 At time 2, buy item with profit 7.
 At time 3, buy item with profit 19.
 We are able to buy all items within their deadline. So, total profit that one can earn is 30.

 */

package com.greedy;

import java.util.*;

class Pair{
    int expiry;
    int profit;

    Pair(int expiry, int profit) {
        this.expiry = expiry;
        this.profit = profit;
    }
}

class SortPair implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        return o1.expiry-o2.expiry;
//        if(o1.expiry < o2.expiry) {
//            return -1;
//        }
//        else if (o1.expiry > o2.expiry) {
//            return 1;
//        }
//        return 0;
    }
}

public class ChallangeInEffecMemMange {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 3, 2, 3, 3)); // profit
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(5, 6, 1, 3, 9)); // expiry

        int mod = 1000000007;
        int time = 0;
        int n = A.size();
        ArrayList<Pair> info = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            info.add(new Pair(A.get(i), B.get(i)));
        }

        Collections.sort(info, new SortPair());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int expiry = info.get(i).expiry;
            int profit = info.get(i).profit;
            if (time < expiry) {
                pq.add(profit);
                time++;
            }
            else {
                if(profit > pq.peek()) {
                    pq.poll();
                    pq.add(profit);
                }
            }
        }
        long result = 0L;
        while (!pq.isEmpty()) {
            result += pq.poll();
            result%=mod;
        }

        System.out.println(result);
    }
}
