//Generate N array, fill the number & print

package com.array;
import java.util.Scanner;

public class Arr1 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the given number for Input range : ");
        int num = sc.nextInt();
        int[] arr = new int[num];
        System.out.println(String.format("Enter %d integer values: ", num));
        for (int i= 0; i< num; i++){
            arr[i] = sc.nextInt();
        }
        for (int number:arr){
            System.out.println(number);
        }
    }
}
