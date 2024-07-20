package com.bitmanipulation;

public class UnsetIthBit {
    public static void main(String[] args){

        int A = 13; //  1101
        int B =2;  //    100


        if ( (A & (1 << B)) == 1 << B) {
            A = A ^ ( 1<< B);
            //A = A - (1 << B);
        }

        System.out.println(A);

    }
}
