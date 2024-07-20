package com.bitmanipulation;

import java.util.Arrays;

public class FindTwoMissingNumber {
    public static void main(String[] args){
        int[] A = {1,3,10,4,9,8,5,6};   //1,3,5,6

        int xor =0;
        int n = A.length;

        for ( int ele : A) xor = xor ^ ele;

        for(int i = 1; i<=n+2; i++) xor = xor ^ i;


        int rsb = xor & (~xor+1);

        int zeros =0;
        int ones =0;

        for (int i=1; i<=n+2; i++) {
            if ((i & rsb) ==0)
                zeros = zeros ^ i;
            else
                ones = ones ^ i;
        }

        for (int ele: A) {
            if ((ele & rsb) ==0)
                zeros = zeros ^ ele;
            else
                ones = ones ^ ele;
        }

        zeros = zeros==0 ? n+2 : zeros;
        ones  = ones==0 ? n+2 : ones;

        if (zeros > ones)
            System.out.println(Arrays.toString(new int[]{ones,zeros}));

        else System.out.println(Arrays.toString(new int[]{zeros,ones}));


    }
}
