package com.random;

import java.sql.SQLSyntaxErrorException;

public class Ndivide3RepeatNumber {
    public static void main(String[] args){
        int[] A = { 1, 1, 1, 2, 3, 5, 7};
        int n = A.length;
        int maj1 = A[0];
        int maj2= 0;
        int count1 = 1;
        int count2 = 1;
        if (n<2) { System.out.println(maj1);} else {maj2=A[1];}


        for (int i=2; i<n; i++){
            if (A[i]==maj1){
                count1++;

            } else if (A[i]==maj2){
                count2++;
            } else if (count1==0){
                maj1 = A[i];
            } else if (count2==0){
                maj2 = A[i];
            }
            else {
                count1--;
                count2--;
            }
        }

        count1=0;
        count2=0;
        for (int i=0; i<n; i++){
            if (A[i]==maj1) {
                count1++;
            }
            if (A[i]==maj2) {
                count2++;
            }
        }

        if (count1 > (n/3)){
            System.out.println(maj1);
        } else if (count2 > (n/3)){
            System.out.println(maj2);
        }

        System.out.println("-1");
    }
}
