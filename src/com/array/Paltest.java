package com.array;

class Solution {

    public String isPalindromic(String str){
        StringBuilder sc = new StringBuilder(str);
        if (str.equals(sc.reverse().toString())) {
            return str;
        }
        else
            return "";
    }

    public String longestPalindrome(String s) {
        String tmp ="", tmp1 = "";
        int endIndex = s.length();

        if (s.length() == 0 || s.length() == 1){
            return(" ");
        }
        else {
            for (int startIndex =0;startIndex<endIndex;startIndex++){
                tmp = isPalindromic(s.substring(startIndex,endIndex));
                if (tmp.length()>0) break;
            }

            for (;endIndex>1;endIndex--){
                tmp1 = isPalindromic(s.substring(1,endIndex));
                if (tmp1.length()>0) break;
            }

            if (tmp.length() > tmp1.length()){
                return tmp;
            } else {
                return tmp1;
            }
        }
    }
}

