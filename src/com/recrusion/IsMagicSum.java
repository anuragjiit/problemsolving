package com.recrusion;

public class IsMagicSum {

    public static int digit(int A, int sum){
        if(A==0 && sum>9) {
            A = sum;
            sum = 0;
        }

        if(A==0) {
            return sum;
        }

        sum+=A%10;

        return digit(A/10,sum);

    }

    public static void main(String[] args) {

        int A = 83557;

        int ans = digit(A,0);

        System.out.println(ans==1 ? ans : 0);


    }
}

