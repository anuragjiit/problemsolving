package com.random;

public class Checkanagrams {
    public static void main(String[] args) {
        String A= "sts";
        String B = "wpl";
        int n = A.length();
        int[] countA = new int[26];
        int[] countB = new int[26];

        for (int i = 0; i < n; i++) {
            countA[A.charAt(i) - 'a']++;
            countB[B.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (countA[i] != countB[i]) {
                System.out.println("0");
            }
        }
        System.out.println("1");
    }
}
