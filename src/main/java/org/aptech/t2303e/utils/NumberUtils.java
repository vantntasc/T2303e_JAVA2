package org.aptech.t2303e.utils;

import java.util.Random;

public class NumberUtils {
//    public synchronized int num = 1;

    private static  Random random = new Random();
    public static int randomNumber(int min , int max){
        return random.nextInt((max - min +1)) + min ;
    }

    public static int getMinValue(int a , int b){
//        if(a < b ) {
//            return a;
//        }else {
//            return b;
//        }
        return a < b ? a : b;
    }
    static String converNum(int num){
        return  (num  < 10 ) ?  "0"+ num : String.valueOf(num);
    }
    public static int findUCLN(int a , int b){ // a >= b
        int temp;
        while (b != 0){
            temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
