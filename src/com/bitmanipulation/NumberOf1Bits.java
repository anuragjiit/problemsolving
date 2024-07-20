package com.bitmanipulation;

public class NumberOf1Bits {
    public static void main(String[] args){
        int A =6;    // count number of 1 in binary
        int count =0;

        while (A >0){
            if ((A & 1) ==1 ){
                count++;
            }
            A = A >> 1;
        }
        System.out.println(count);
    }
}
