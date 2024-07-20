package com.string;

public class LongestPalindromeSubstringLength {

    public static String palindrom(String str, int left, int right){

        while (left >=0 && right < str.length()){
            if (str.charAt(left) ==  str.charAt(right)){
                left--;
                right++;
            } else {
                break;}
        }
        return str.substring(left+1, right);
    }



    public static void main(String[] args) {

   //         String str = "bxdyzzydbdyzydx";
   //     String str = "feacabacabgf";
       String str = "dddddddddddd";
        int n = str.length();
        String ans = "";
        for (int i =0; i<n; i++) {
            String max ="";
            String oddPelindrom = palindrom(str,i-1, i+1);
            String evenPelindrom = palindrom(str,i,i+1);
            if (oddPelindrom.length() > evenPelindrom.length()){
                max = oddPelindrom;
            } else {max = evenPelindrom;}

            if (ans.length() < max.length()){
                ans = max;
            }
        }

        System.out.println(ans);



    }
}
