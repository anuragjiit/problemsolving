package com.recrusion;

import java.util.ArrayList;
import java.util.Arrays;

public class KthSymbolEasy {

    public static ArrayList<Integer> list (int A){

        if (A==1) return new ArrayList<>(Arrays.asList(0));

        ArrayList<Integer> arr = list(A-1);

        ArrayList<Integer> currentArr = new ArrayList<>();

        for (int i=0; i<arr.size(); i++){
            if(arr.get(i)==0) {
                currentArr.add(0);
                currentArr.add(1);
            }
            if(arr.get(i)==1) {
                currentArr.add(1);
                currentArr.add(0);
            }
        }

        return currentArr;
    }

    public static void main(String[] args) {

        int A = 4;
        int B = 0;

        ArrayList<Integer> ans = list(A);

        System.out.println(ans.get(B));

    }
}
