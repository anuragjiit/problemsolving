/*
Problem Description

Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.

Also given an integer C which represents knapsack capacity.

Find out the maximum total value that we can fit in the knapsack. If the maximum total value is ans, then return ⌊ans × 100⌋ , i.e., floor of (ans × 100).

NOTE:

    You can break an item for maximizing the total value of the knapsack



Problem Constraints

1 <= N <= 10^5

1 <= A[i], B[i] <= 10^3

1 <= C <= 10^3



Input Format

First argument is an integer array A of size N denoting the values on N items.

Second argument is an integer array B of size N denoting the weights on N items.

Third argument is an integer C denoting the knapsack capacity.



Output Format

Return a single integer denoting the maximum total value of A such that sum of the weights of this subset is smaller than or equal to C.



Example Input

Input 1:

 A = [60, 100, 120]
 B = [10, 20, 30]
 C = 50

Input 2:

 A = [10, 20, 30, 40]
 B = [12, 13, 15, 19]
 C = 10



Example Output

Output 1:

 24000

Output 2:

 2105



Example Explanation

Explanation 1:

Taking the full items with weight 10 and 20 and 2/3 of the item with weight 30 will give us
the maximum value i.e 60 + 100 + 80 = 240. So we return 24000.

Explanation 2:

Taking 10/19 the fourth item gives us the maximum value i.e. 21.0526. So we return 2105.

 */
package com.dynamicprograming;

import java.util.Arrays;
import java.util.Comparator;

class Cake {
    int weight;
    int happiness;
    double cost;

    Cake(int weight, int happiness) {
        this.weight = weight;
        this.happiness = happiness;
        cost = happiness*1.0/weight;
    }
}

class SortCost implements Comparator<Cake> {
    @Override
    public int compare(Cake c1, Cake c2) {
     if (c1.cost > c2.cost) return -1;
     if (c1.cost < c2.cost) return 1;
     return 0;

    }
}

public class FractionalKnapsack {
    public static void main(String[] args) {
//        int[] h = new int[]{16,3,3,6,7,8,17,13,7};    // happiness
//        int[] w = new int[]{3,10,9,18,17,17,6,16,13};  // weight
//        int wCapacity = 11;

        int[] h = new int[]{3};    // happiness
        int[] w = new int[]{20};  // weight
        int wCapacity = 17;

        int n = h.length;
        Double total = 0.0;
        Cake[] cakes = new Cake[n];

        for (int i=0; i<n; i++) {
            cakes[i] = new Cake(w[i],h[i]);
        }

        Arrays.sort(cakes, new SortCost());

        for (int i=0; i<n; i++) {
            wCapacity -= cakes[i].weight;
            if (wCapacity >=0) {
                total += cakes[i].happiness;
            }
            else {
                wCapacity += cakes[i].weight;
                total += wCapacity* cakes[i].cost;
                break;
            }
        }

  //      int ans1 = (int) (total*100); not working for 254.99 ..
        int ans = (int) (total *1000/10);
        System.out.println(ans);

  //      System.out.println(total.intValue()); // cant be used as it outputs 254 .. total is 254.99999.. answers for this use case is 255.

    }
}
