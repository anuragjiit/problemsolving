/*
 Approach 1 - O(n^2)

Maintain PrefixSum and SuffixSum for odd and even index seperately.
Let consider the following variable:
leftOdd[i] : Denote the prefixSum of element on odd index till i-1.
leftEven[i] : Denote the prefixSum of element on even index till i-1.
rightOdd[i] : Denote the SuffixSum of element of odd index till i+1.
rightEven[i] : Denote the SuffixSum of element of even index till i+1.

Now, check if the ith element is the special or not.

If leftOdd[i] + rightEven[i] == leftEven[i] + rightOdd[i], then ith element is special, so we increase the count.

Input 1:
A = [2, 1, 6, 4]

Input 2:
A = [5, 5, 2, 5, 8]

leftEven starts from i-1.. 1st element .. +2 for next .. till arrary 0th
leftOdd starts from i-2.. 1st element ..  +2 for next .. till arrary 0th
rightEven starts from i+1.. 1st element .. +2 for next ..till array length
rightOdd starts from i+2.. 1st element ..  +2 for next .. till array length
 */

/*  Approach 2 - O(n)

Based on the observation that removing any element from the given array makes even indices of succeeding elements
as odd and odd indices of the succeeding elements as even.
Follow the steps below to solve the problem:

Initialize two variables, say evenSum and oddSum,
to store the sum of odd-indexed and even-indexed elements of the given array respectively.

Traverse the array using variable i.
Remove every ith element of the array and update the sum of the remaining even-indexed elements
and the odd-indexed elements based on the above observation. Check if the sums are equal or not.
If found to be true, then increment the count.

Finally, print the count obtained. Check out the complete solution for more clarity.


Time complexity : O(N)
Space Complexity : O(1)

 */
package com.array;

public class BalanceArray {

    public static int[] evenPreSum(int[] A, int n){
        int[] even = new int[n];
        even[0]=A[0];
        for(int i=1; i<n; i++){
            if(i%2==0){
                even[i]=even[i-1]+A[i];
            }
            else {even[i]=even[i-1]; }
        }
        return even;
    }

    public static int[] oddPreSum(int[] A, int n){
        int[] odd = new int[n];
        odd[0]=0;
        for(int i=1; i<n; i++){
            if(i%2!=0){
                odd[i]=odd[i-1]+A[i];
            }
            else {odd[i]=odd[i-1]; }
        }
        return odd;
    }

    public static int[] evenSuffixSum(int[] A, int n){
        int[] even = new int[n];
        if ((n-1)%2==0){even[n-1]=A[n-1];} else {even[n-1]=0;}  //{2, 1, 6, 4}
        for(int i=n-2; i>=0; i--){
            if(i%2==0){
                even[i]=even[i+1]+A[i];
            }
            else {even[i]=even[i+1]; }
        }
        return even;
    }

    public static int[] oddSuffixSum(int[] A, int n){
        int[] odd = new int[n];
        if ((n-1)%2!=0){odd[n-1]=A[n-1];} else {odd[n-1]=0;}

        for(int i=n-2; i>=0; i--){                       //{2, 1, 6, 4}
            if(i%2!=0){
                odd[i]=odd[i+1]+A[i];
            }
            else {odd[i]=odd[i+1]; }
        }
        return odd;
    }

    public static void main(String[] args){
        int[] A= {5, 5, 2, 5, 8};
    //    int[] A ={2, 1, 6, 4};
    //    int[] A= {1,1,1};
        int n = A.length, count=0;


        int[] evenPrefix = evenPreSum(A, n);   //       2,2,8,8    1,1,2
        int[] oddPrefix = oddPreSum(A, n);   //         0,1,1,5    0,1,1
        int[] evenSuffix = evenSuffixSum(A, n);   //    8,6,6,0    2,2,1
        int[] oddSuffix = oddSuffixSum(A, n);   //      5,5,4,4    1,0,0
        int evenP=0, oddP=0, evenS=0, oddS=0;

        for (int i=0; i<n;i++){  //0,1,2,3
            if ( i==0 ) {
                evenP=0;
                oddP=0;
                oddS= oddSuffix[i+1];
                evenS = evenSuffix[i+1];

            } else if (i==n-1){
                evenP=evenPrefix[i-1];
                oddP=oddPrefix[i-1];
                oddS= 0;
                evenS = 0;
            }
            else {   //i =1, 2+4 == 0+6
                evenP=evenPrefix[i-1];
                oddS= oddSuffix[i+1];

                oddP=oddPrefix[i-1];
                evenS = evenSuffix[i+1];
            }
            if (evenP+oddS==oddP+evenS){
                count++;
            }
        }



        //    int[] A= {2, 1, 6, 4};
    //    int[] A= {1,1,1};
        // Approach 2

 /*       int count =0;   Approach 1

            for (int i = 0; i < A.length; i++) {
                int leftOdd = 0, leftEven = 0, rightEven = 0, rightOdd = 0;
                int leftSide = i - 1;
                int rightSide = i + 1;

                while (leftSide >= 0) {
                    leftEven += A[leftSide];
                    if (leftSide - 1 >= 0) {
                        leftOdd += A[leftSide - 1];
                    }
                    leftSide -= 2;
                }

                while (rightSide < A.length) {
                    rightEven += A[rightSide];
                    if (rightSide + 1 < A.length) {
                        rightOdd += A[rightSide + 1];
                    }
                    rightSide += 2;
                }
                if ((leftOdd + rightEven) == (leftEven + rightOdd)) {
                    count += 1;
                }
            }
*/
        System.out.println(count);
    }
}
