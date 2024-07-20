// find the max & min element in aray. Input -> [10,5,2,12,0]

package com.array;

public class Arr3 {
    public static void main(String[] args){
 //       int []arr= {10,5,2,12,0,-1};
        int[] arr= {10,5,2,12,0,-1};

        int min =0, max = 0;

        for (int num : arr){
            if (min > num) {
                min = num;
            }
        }
        System.out.println(min);

        for (int num : arr){
            if (num > max) {
                max = num;
            }
        }
        System.out.println(max);
    }

}
