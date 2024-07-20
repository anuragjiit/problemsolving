/*
BMI Calculator

Problem Description -

Given the height (A) and weight (B) of a person as input in centimetres and kilograms.

Find the BMI of that person and the classification of the user based on their BMI.

    Print Underweight if BMI < 18.5
    Print Normal if BMI lies in the range [18.5, 24.9]
    Print Overweight if BMI lies in the range (24.9, 29.9]
    Print Obese if BMI is greater than 29.9

If x is the weight in kilograms and y is the height in metres.

Then, BMI is calculated as x/(y*y).

 Note: Use round(BMI,1) to get only one digit after decimal

Problem Constraints -

1 <= A <= 180

1 <= B <= 120

Input Format -

The first line contains the height of the person in centimetres.

The second line of the input contains the weight of the person in kilograms.

Output Format -

The first line of the output contains the classification of a person based on the BMI value.

The second line of the output contains the BMI value of the person having only one digit after decimal.



Sample Input -

Input 1:

101
29

Input 2:

129
31

Sample Output -

Output 1:

Overweight
28.4

Output 2:

Normal
18.6
 */
package com.array;
import java.util.Scanner;

public class Bmi {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double bmiR =0;
        double height = sc.nextInt(); //in cetimeter
        int weight = sc.nextInt(); //in kg
        height = height/100;
        bmiR = weight/(height*height);
        bmiR = Double.parseDouble(String.format("%.1f", bmiR));

        if (bmiR > 29.9) {
            System.out.println("Obese");
            System.out.println(bmiR);
        }
        else if (bmiR > 24.9 && bmiR <= 29.9) {
            System.out.println("Overweight");
            System.out.println(bmiR);
        }else if (bmiR > 18.5 && bmiR <= 24.9) {
            System.out.println("Normal");
            System.out.println(bmiR);
        } else {
            System.out.println("Underweight");
            System.out.println(bmiR);
        }
    }
}
