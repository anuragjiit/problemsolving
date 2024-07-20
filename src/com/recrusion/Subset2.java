package com.recrusion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Subset2 {
    public static ArrayList<ArrayList<Integer>> subSet(ArrayList<Integer> A){
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        int start = 0;
        int end = 0;

        for (int i = 0; i< A.size(); i++){
            start =0;
            int temp = A.get(i);
            if( i>0 && A.get(i)==A.get(i-1)){
                start = end+1;
            }
            end = ans.size()-1;
            int n = ans.size();
            for (int j = start; j < n; j++){
                ArrayList<Integer> internal = new ArrayList<>(ans.get(j));

                internal.add(temp);

                ans.add(internal);


            }

        }


        return ans;

    }
    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(4,5));

        System.out.println(subSet(A));
    }
}
