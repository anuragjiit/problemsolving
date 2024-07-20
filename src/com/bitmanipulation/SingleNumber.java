package com.bitmanipulation;

public class SingleNumber {
    public static void  main(String[] args){

        int[] A ={1, 2, 2, 3, 1};

        int ans =0;
        for ( int ele : A){
            ans = ans ^ ele;
        }

        System.out.println(ans);
    }
}
