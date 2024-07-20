package com.recrusion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;

public class SubSets {

    public static void subSet(ArrayList<Integer> A, int idx, LinkedHashSet<ArrayList<Integer>> ans,  ArrayList<Integer> temp) {


        if (idx ==A.size()) {
            return;
        }


        temp.add(A.get(idx));
        System.out.println(temp);
        ans.add(new ArrayList<Integer>(temp));
        System.out.println(ans);

        subSet(A,idx+1, ans, temp);

        System.out.println(temp);
        temp.remove(temp.size()-1);

        subSet(A,idx+1, ans, temp);

    }

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2,3));

     //   ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        LinkedHashSet<ArrayList<Integer>> ans = new LinkedHashSet<>();
        ArrayList<Integer> temp = new ArrayList<>();
        ans.add(new ArrayList<Integer>());

        Collections.sort(A);

        subSet(A, 0, ans,temp);


        System.out.println(ans);


    }
}
