// Sort a String ranged from a - z ..

package com.string;

public class SortStringAtoz {
    public static void main(String[] args){
        String str = "dceabb";


        /* using in built method
        char []arr = str.toCharArray();
        Arrays.sort(arr);
        System.out.print(String.valueOf(arr)); */


        final int MAX_CHAR = 26;
        int letters[] = new int[MAX_CHAR];
        for (char ch: str.toCharArray()) {
            letters[ch - 'a']++;
        }
        for (int i = 0; i < MAX_CHAR; i++) {
            for (int j = 0; j < letters[i]; j++) {
                System.out.print((char) (i + 'a'));
            }
        }


    }
}


