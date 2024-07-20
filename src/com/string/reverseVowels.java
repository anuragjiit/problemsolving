package com.string;

// reverse vowels in sub string

import java.util.Arrays;

public class reverseVowels {

    public static void main(String[] args){

        String A = "baiedgo";  //boeidga
        int n = A.length();
        String vowels = "aeiou";
        //    char[] B = new char[n];
        char[] B = A.toCharArray();
        int l =0, r =n-1;
        StringBuilder sb = new StringBuilder();

        while (l<r){
            if ( vowels.indexOf(B[l])!=-1 && vowels.indexOf(B[r])!=-1 ){
                char temp = B[l];
                B[l] = B[r];
                B[r] = temp;
                l++;
                r--;
            }
            if ( vowels.indexOf(B[l])==-1 ) l++;
            if (vowels.indexOf(B[r])==-1) r--;
        }

     System.out.println(sb.append(B).toString());
    }
}
