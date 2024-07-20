package com.recrusion;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;



public class TowerOfHanoi {
    public static void main(String[] args) {

        int n = 3; // disk are 3
        int A = 1; // tower 1
        int B = 2; //tower 2
        int C = 3; //tower 3

        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        towerOfHanoiHelper(n, A, B, C, ans);

        System.out.println(ans);

    }

    public static ArrayList<ArrayList<Integer>> towerOfHanoiHelper(int n, int A, int B, int C, ArrayList<ArrayList<Integer>> ans){

        if(n==0) return ans;

        towerOfHanoiHelper(n-1, A, C, B, ans);

//        ArrayList<Integer> anotherList = new ArrayList<>();
//        anotherList.add(n);
//        anotherList.add(A);
//        anotherList.add(C);
        ans.add(new ArrayList<Integer>(Arrays.asList(n,A,C)));



        towerOfHanoiHelper(n-1, B, A, C, ans);

        return ans;
    }

}
