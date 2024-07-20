package com.bitmanipulation;

public class SubArrayOr {
    public static void main(String[] args){
        int[] A = {1, 2, 3, 4, 5};
        int n = A.length;
        int mod = 1000000007;
        int totalSubArray = (n+1)*n/2;
        int sum=0;
        int zero =0;
        int zeroNext = 0;

        for (int i=0; i<32; i++){

            if( (1<<i & A[0]) == 0 )  {
                zero++;
            }

            for (int j=1; j<n; j++){
                if((A[j] & 1 << i) ==0) zero++;
                else if (zero !=0 ){
                    zeroNext += zero *( zero+1)/2;
                    zero = 0;
                }

            }
            zeroNext += zero *( zero+1)/2;
            sum+= (totalSubArray-zeroNext) * 1 << i;
            zero =0;
            zeroNext=0;
        }


       System.out.println(sum%mod);
    }
}
