/*
Need to find out factor of any number.
Factor of number will be in between 1 to n. 1 & n will always be factor on any given number..
ex : 10 .. so 1 & 10 will always be factor of 10. so we can say i*j=n .. for 6, its 1*6, 2*3, 3*2 & 6*1 .. so it will be always in pair .. except
when we have square number like 36 .. 6*6 will be only 1 pair
Prime will have only 2 factor
So to calculate a factor of number, we need not traverse all but i*i <=n and increase the count by 2 to include the pair.. for square root number where n/i=i, increase by 1

10 factor => 1*10, 2*5, 5*2, 10*1
24 factor => 8

 */

package com.array;

public class FactorNumber {

    public static void main(String[] args){
        int num =24, count=0;
        for (int i = 1; i*i<=num; i++){
            if (num%i==0){
                if (num/i==i){
                    count+=1;
                }
                count+=2;
            }
        }
        System.out.println(count);
    }
}
