package com.array;

public class CoronaRecover {

    public static void main(String[] args){
        int RateRecovered = 5, RateNew = 3, RateActive = 1, days =0 ;
            while (true){
                if (RateActive+RateNew > RateRecovered){
                    days += 1;
                    RateActive = (RateActive+RateNew) - RateRecovered;
                }
                else break;
            }
    System.out.println(days);
    }
}
