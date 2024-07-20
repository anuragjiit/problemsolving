//Given array, generate a reverse array .. ex - input [10,2,5,0,7] , output = [7,0,5,2,10]


package com.array;

public class Arr4 {
    public static void main(String[] args){
        int arr[] = {10,2,5,0,7};
        int[] out = new int[arr.length];
        int counter = arr.length;
        for (int i=0; i<arr.length; i++){
            out[counter-1] = arr[i];
            counter -= 1;
        }
        for (int num:out){
            System.out.println(num);
        }
    }
}
