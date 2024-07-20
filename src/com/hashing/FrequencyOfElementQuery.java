package com.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class FrequencyOfElementQuery {
    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2,1,1));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1,2));

        int n = A.size();
        int bSize = B.size();

        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i=0; i<n; i++){
            if (freq.containsKey(A.get(i))) freq.put(A.get(i), freq.get(A.get(i))+1);
            else freq.put(A.get(i), 1);
        }

        for (int i=0; i<bSize; i++){
            if (freq.containsKey(B.get(i)))  ans.add(freq.get(B.get(i)));
        }

        System.out.println(ans);
    }
}
