package com.array;

import java.util.*;

class Main {

    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();

        if(s1 == s2) {
            System.out.println("Strings are equal");
        }
        else {
            System.out.println("Strings are not equal");
        }
    }
}