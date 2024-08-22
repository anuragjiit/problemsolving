/*
Problem Description

Given an array A of positive elements, you have to flip the sign of some of its elements such that the resultant sum of the elements of array should be minimum non-negative(as close to zero as possible).

Return the minimum number of elements whose sign needs to be flipped such that the resultant sum is minimum non-negative.



Problem Constraints

1 <= length of(A) <= 100

Sum of all the elements will not exceed 10,000.



Input Format

First and only argument is an integer array A.


Output Format

Return an integer denoting the minimum number of elements whose sign needs to be flipped.


Example Input

Input 1:

 A = [15, 10, 6]

Input 2:

 A = [14, 10, 4]



Example Output

Output 1:

 1

Output 2:

 1



Example Explanation

Explanation 1:

 Here, we will flip the sign of 15 and the resultant sum will be 1.

Explanation 2:

 Here, we will flip the sign of 14 and the resultant sum will be 0.
 Note that flipping the sign of 10 and 4 also gives the resultant sum 0 but flippings there sign are not minimum.
 */
package com.dynamicprograming;

class Pair {
    int sum;
    int flip;

    Pair(int s, int f) {
        this.sum = s;
        this.flip = f;
    }
}

    public class FlipArray {
        public static void main(String[] args) {
            int[] A = new int[]{15, 10, 6};
            int n = A.length;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += A[i];
            }
            sum = sum / 2;
  /*         int[][] dp = new int[n+1][sum+1];

            for(int j = 1;j<=sum;j++){
                dp[0][j] = 9999999;   // Integer.MAX_VALUE does not work , so added larger value -9999999
            }

            for(int i = 1;i<=n;i++){
                int currentVal = A[i - 1];
                for(int j = 1;j<=sum;j++){
                    if(j<currentVal){
                        dp[i][j] = dp[i-1][j];
                    }else{
                        dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i-1][j-currentVal]);
                    }
                }
            }
            // If the total sum can't be make into half equal sum then look for the sum which can be made using all the values
            // by moving twards the left from the bottom right corner
            while(dp[n][sum]==9999999){
                sum-=1;
            }
            System.out.println(dp[n][sum]); */
            Pair[][] dp = new Pair[n+1][sum+1];

     /*In this problem

     /**
         * Let’s consider an example to understand the problem
         * A:[15,10,6] totalSum = 31
         * If we flip sign of 15 to -15 we will get totalSum as -15+10+6->1 and it is closest to zero so 1
         * is the answer as only single flip is required to make it closest to zero
         * If we calculate half Sum that is 31/2 → 15 so we have other half left as 16
         * So, we have to make our negative sum as close to 15 as possible because in that case
         * we can get negative contribution close to halfSum(negativeContribution <= halfSum) and
         * positive contribution will be left half which will be greaterThan equal to halfSum

          In the above case we have halfSum as 15 and we have to find minimum number of elements that can make
         * the sum <= halfSum i.e sum <= 15.
         * In first go it might look like a knapsack problem in which we have a capacity of bag as 15 and we have
         * to get the items with maxValue where weight is <= 15.(But the problem is knapsack talks about the maximum
         * value we can obtain and not the weight much close to 15 is a better ans)
         * Here, the question talks about minimum elements required to make sum <= halfSum which means the closer we
         * get to half Sum the answer is better.
         * For eg. if half Sum is 15 and we get possible set of answer possible as 14 or 13 or 12 in that case 14 is
         * a better ans and minimum steps required to make 14 will be the final answer

         /

        step 1:- we need to find maxSum that can be achieve for the given capacity.
        step 2:- the maxSum that we got from step 1 pass it to the function in which we need to find min number of
                 elements needed to achieve capacity = maxSum;
     */

            for (int i=0; i<=n; i++) {
                for (int j=0; j<=sum; j++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = new Pair(0, 0);
                        continue;
                    }
                    int currentValue = A[i-1];

                    if (currentValue > j) {
                        // you can't flip the A[i] as sum will become negative- so skip selection
                        dp[i][j] = dp[i-1][j];
                    }
                    else {
                        // we get two option
                        // option 1 not choosing the element
                        Pair p1 = dp[i-1][j];
                        //option2 chossing the element
                        Pair p2 = new Pair(dp[i-1][j-currentValue].sum + currentValue, dp[i-1][j-currentValue].flip + 1);

                        // now in order the select one between p1 and p2 choose
                        // one with lower flips when sum are equal else chose the one
                        // with higher sum
                        if (p1.sum == p2.sum) {
                            if (p1.flip < p2.flip) {
                                dp[i][j] = p1;
                            } else {
                                dp[i][j] = p2;
                            }
                        } else {
                            if (p1.sum > p2.sum) {
                                dp[i][j] = p1;
                            } else {
                                dp[i][j] = p2;
                            }
                        }
                    }
                }
            }
        System.out.println(dp[n][sum].flip);
        }
    }
