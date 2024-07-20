package com.string;

public class MinimumAppendsforPalindrome {
    public static void main(String[] args){
        String A = "oqycntornscygodzdctxnhoc";
        //          cohnxtcdzdogycsnrotncyqo$cohnxtcdzdogycsnrotncyqo
        int count = 0;

        StringBuilder sb = new StringBuilder(A);
        sb.insert(0, sb.reverse()+"$");
        String B = sb.toString();
       System.out.println(B);
        int n = B.length();

        int i = 0;
        while (i < A.length()) {
            if (B.charAt(i) == B.charAt(n-1)){
                count++;
            }
            i++;
            n--;

        }
        System.out.println(count);

    }
}
