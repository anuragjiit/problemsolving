package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Testing {
    public static void main(String[] args){

        List<Integer> al = new ArrayList<Integer>();
        al.add(10);
        al.add(20);
        al.add(30);
        al.add(40);

        ArrayList<String> fruitsList = new ArrayList<>();
        fruitsList.add("Apple");
        fruitsList.add("Banana");
        fruitsList.add("Orange");

        String[] fruitsArray = fruitsList.toArray(new String[fruitsList.size()]); // works are String is an Object
        System.out.println(Arrays.toString(fruitsArray));




        Integer[] arr = new Integer[al.size()];
        al.toArray(arr);


        for (Integer x : arr)
            System.out.print(x + " ");
    }
}
