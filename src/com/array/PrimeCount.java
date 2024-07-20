package com.array;

public class PrimeCount {

    public static boolean prime(int n){

        if (n==0 || n==1){
            return false;
        } else {
            for (int j = 2; j * j <= n; j++) {
                if (n % j == 0) {
                    return false;
                }
            }
        }
        return true;
    }



    public  static void main(String[] args){
        int A = 10;
        int count =0;

            for (int i=0; i<=A; i++){
                if (prime(i)){
                    count++;
                }
            }
            System.out.println("Number of Prime number in  "+ A +  "   :   " + count);

        }


}
