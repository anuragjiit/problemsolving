package com.string;

public class LongestCommonSubString {

    public static void main(String[] args) {

     //        String[] A = {"abcdefgh", "aefghijk", "abcefgh"};
    //   String[] A = {"abcd"};
        String[] A = {"abcd", "abcd", "efgh"};
        int n = A.length;
        int n1 = A[0].length();
        String ans = "";


        for (int j = 0; j < n1; j++) {
            for (int k = j; k < n1; k++) {

                String max = "";
                String sub = "";
                int z = 1;
                sub = A[0].substring(j, k+1);
                //          System.out.println( "Sub String in for combination  ---- >" + sub);
                for (int i = 1; i < n; i++) {
                    if (A[i].contains(sub)) {
                        z++;
                    } else {
                        break;
                    }
                }

                if (z == n) {
                    ans = sub.length() > ans.length() ? sub : ans;
            //        max = sub;
                }
                    //                  System.out.println( "Matched in all String Array :   " + sub);}
//                    if (max.length() > ans.length()) {
//                        ans = max;
//                    }

           }


     /*   String s1 =   "dadef";
        String s2 = "adwce";
        int ans =0 ;




         //     TC : O(n^3) by comparing the chars

        for (int i =0; i < s1.length(); i++){
            for (int j = 0; j < s2.length(); j++){
                int k = 0;
                while ( (i+k) < s1.length() && (j+k) < s2.length() && s1.charAt(i) == s2.charAt(j)) {
                    k+=1;
                }
                ans = Math.max(ans, k);
            }
        }  */


  /*      TC : O(n^3)
        for (int i =0; i < s1.length(); i++){
            for (int j = i+1; j < s1.length(); j++){
                if (s2.contains(s1.substring(i,j))){      // String.contains -> TC is O(n)
                    int length = j - i;
                    ans = Math.max(ans, length);
                }
            }
        } */

        }
        System.out.println(ans);
    }
}
