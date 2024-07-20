package com.recrusion;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class permutations {

    public static void permu( ArrayList<Integer> A, int idex, ArrayList<ArrayList<Integer>> ans, int[] visited, ArrayList<Integer> temp){
        int n = A.size();

        if(A.size()==idex){
            ans.add(new ArrayList<>(temp));    //[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
         //   ans.add(temp);                      // [[3, 2, 1], [3, 2, 1], [3, 2, 1], [3, 2, 1], [3, 2, 1], [3, 2, 1]]
            return;
        }

        for (int i=0; i<n; i++) {
            if (visited[i]==0){
                visited[i] = 1;
                if (temp.size()<n) temp.add(A.get(i));
                else temp.set(idex, A.get(i));

                System.out.println("before visited false " + temp);

        //        temp[idex] = A.get(i);
                permu(A, idex+1, ans, visited, temp);

                System.out.println("after visited false " +temp);
                visited[i] = 0;

            }
        }

    }


    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2,3));

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int[] visited = new int[A.size()];
     //   int[] temp = new int[A.size()];
        ArrayList<Integer> temp = new ArrayList<>();

        permu(A,0, ans, visited, temp);

        System.out.println(ans);


    }
}
