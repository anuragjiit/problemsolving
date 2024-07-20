package com.array;
import java.lang.*;
import java.util.*;

public class Lcm {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int[] arr = new int[2];
            // Input is space separated , otherwise string is not needed
            String[] str = sc.nextLine().split(" ");
            for (int i =0; i< str.length; i++){
               arr[i] = Integer.parseInt(str[i]);
            }

            int lcm = findLcm(arr[0], arr[1]);
            System.out.println(lcm);
        }

        static int findLcm(int a, int b){
            int step, max =0;
            if (a > b) max = step = a;
            else  max = step = b;
            while (true){
                if (max % a == 0 && max % b ==0){
                    return max;
                }
                max += step;
            }
        }
    }
