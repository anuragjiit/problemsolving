package com.recrusion;

import java.util.ArrayList;
import java.util.HashMap;

public class LetterPhoneMap {

    public static HashMap<Integer, String> charMap = new HashMap<>();

    public static void helper(String A, String current, int index, ArrayList<String> ans){

        if(A.length()==index) {
            ans.add(current);
            return;
        }

        int digit = A.charAt(index) - '0';
        int n = charMap.get(digit).length();
        for(int i=0; i<n; i++){
            current+=charMap.get(digit).charAt(i);
            helper(A,current,index+1,ans);

            current = current.substring(0, current.length()-1);
        }
    }

    public static void main(String[] args) {

        String A = "23";
        String current = "";
        ArrayList<String> ans = new ArrayList<>();

        charMap.put(0,"0");
        charMap.put(1,"1");
        charMap.put(2,"abc");
        charMap.put(3,"def");
        charMap.put(4,"ghi");
        charMap.put(5,"jkl");
        charMap.put(6,"mno");
        charMap.put(7,"pqrs");
        charMap.put(8,"tuv");
        charMap.put(9,"wxyz");


        helper(A, current, 0, ans);



        System.out.println(ans);

    }
}
