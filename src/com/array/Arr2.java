package com.array;

/*
Read 2 array and generate 3rd by combining common number from first 2
arr1[] = {2,5,6,10,12}
arr2[] = {10,6,1,3}
output : arr3[6,10] or arr3[10,6] => order not important for this prob
 */

public class Arr2 {
    public static void main(String[] args){
       int arr1[] = {2,5,6,10,12};
       int arr2[] = {5,16,10,3};
       int count = 0;

       for (int num1:arr1){
           for (int num2:arr2){
               if (num1 == num2){
                   count += 1;
               }
           }
       }

       int[] arr3 = new int[count];
        int k = 0;
        for (int i=0; i<arr1.length; i++){
            for (int j =0; j<arr2.length; j++){
                if (arr1[i]== arr2[j] && k < count){
                        arr3[k] = arr1[i];
                        k += 1;
                }
            }
        }


        for (int num3=0; num3<arr3.length; num3++){
            System.out.println(arr3[num3]);
        }
    }
}
