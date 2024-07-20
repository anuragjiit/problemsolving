package com.string;

public class ReverseString {
    public static void main(String[] args){
        String A = "the sky is blue";
        StringBuilder sb = new StringBuilder();

        String[] str = A.split(" ");
        int n = str.length;

        for (int i = n-1; i>=0 ; i--){
            sb.append(str[i]);
            if (i>0){sb.append(" ");}
        }
        System.out.println(sb.toString());
    }
}
