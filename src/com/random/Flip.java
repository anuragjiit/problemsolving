/*




Example Output

Output 1:

[1, 1]

Output 2:

[]



Example Explanation

Explanation 1:

A = "010"

Pair of [L, R] | Final string
_______________|_____________
[1 1]          | "110"
[1 2]          | "100"
[1 3]          | "101"
[2 2]          | "000"
[2 3]          | "001"

We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].

Explanation 2:

No operation can give us more than three 1s in final string. So, we return empty array [].
 */
package com.random;

public class Flip {
    public static void main(String[] args){
        int[] A = {1,1,0,0,0,0,1,1,1,0,0,1};
    //    int[]A = {1,1,1,1};
        int n = A.length;
        int currentSum = 0, l=0, r=0;;
        int maxSum = 0;
        int[] ans = new int[2];


        for (int i=0; i< n; i++){

            if(A[i]==1){
                currentSum-=1;
            } else currentSum+=1;

            if (currentSum > maxSum){
                maxSum = currentSum;
                ans[0] = l+1;
                ans[1] = r+1;
            }
            if (currentSum < 0){
                currentSum = 0;
                l = i+1;
                r = i+1;
            } else r+=1;

        }

        if (maxSum==0) {
            int[] zero = new int[1];
            System.out.println(zero[0]);
        }

        System.out.println(ans[0]);
        System.out.println(ans[1]);

    }
}
