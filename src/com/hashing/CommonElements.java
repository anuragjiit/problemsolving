package com.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class CommonElements {
    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 2, 1));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(2, 3, 1, 2));

        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> freqA = new HashMap<>();
        HashMap<Integer, Integer> freqB = new HashMap<>();

        int nA = A.size();
        int nB = B.size();

        for (int i=0; i<nA; i++){
            if(freqA.containsKey(A.get(i))) {
                freqA.put(A.get(i), freqA.get(A.get(i))+1);
            } else {
                freqA.put(A.get(i), 1);
            }
        }

        for (int i=0; i<nB; i++){
            if(freqB.containsKey(B.get(i))) {
                freqB.put(B.get(i), freqB.get(B.get(i))+1);
            } else {
                freqB.put(B.get(i), 1);
            }
        }

        for (int ele : freqA.keySet()){

            if (freqA.containsKey(ele) && freqB.containsKey(ele)) {

                int values = Math.min(freqA.get(ele), freqB.get(ele));

                for (int i=0; i<values; i++) {
                    ans.add(ele);
                }
            }

        }

        System.out.println(ans);
    }
}
