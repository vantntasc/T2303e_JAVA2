package org.aptech.t2303e.utils;

import java.util.Random;

public class NumberUtils {
//    public synchronized int num = 1;

    private static  Random random = new Random();

    public static void main(String[] args) {
//        Random random = new Random();
//        System.err.println("Random integer : " + random.nextInt());
//        System.err.println("Random long : " + random.nextLong());
//        System.err.println("Random double : " + random.nextDouble());
//        System.err.println(randomNumber(0,9));
//        System.err.println(randomNumber(0,9));
//        System.err.println(randomNumber(0,9));
//        System.err.println(randomNumber(0,9));
//        for (int i = 0; i < 10 ; i++) {
//            System.err.println(randomAlphaNumeric(8));
//        }
        StringBuilder sb = new StringBuilder("John");
        for (int i = 0; i <  10; i++) {
            sb.append("Doe");
        }
        System.err.println(sb.toString());
    }
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
