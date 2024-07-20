package com.array;

public class Str2 {

    public static void main(String[] args){
        String s = "restart";
        char firstChar = s.charAt(0);
        // StringBuilder sb = new StringBuilder(s);
        // sb.replace(1, s.length(), );
        String str = s.substring(1,s.length());
        String str1 = str.replace(firstChar, '$');
        System.out.println(firstChar + str1);

    }
}
