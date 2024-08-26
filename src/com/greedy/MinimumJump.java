/*
Gievn A[n], You are initially present at A[0], Each element represents max number of jump from index i.
Return minimum no of jumps required to reach A[n-1]
A = {2,3,1,1,4} => ans = 2
A = {3,3,0,2,1,2,4,2,0,0} => ans = 4
A[0] = 3, represent max number of jump it can take i.e. 3 .. similarly for all other index value.
 */
package com.greedy;

public class MinimumJump {
    public static void main(String[] args) {
        int[] A = {3,3,0,2,1,2,4,2,0,0};
        int start = 0;
        int jump = 0;
        int n = A.length;

        while (start<n) {

            int currentJump = A[start];

            if(currentJump==0) {
                System.out.println(-1);
                System.exit(0);
            }
            if (start+currentJump >= n-1) {
                System.out.println(++jump);
                System.exit(0);
            }

            int candidateJumpIndex = -1;
            int maxJumpOfStartChild = -1;

            for (int i=start+1; i<=start+currentJump; i++) {
                if (A[i]+i > maxJumpOfStartChild) {
                    maxJumpOfStartChild = A[i]+i;
                    candidateJumpIndex = i;
                }
            }
            start = candidateJumpIndex;
            jump++;
        }
        System.out.println(jump);
    }
}
