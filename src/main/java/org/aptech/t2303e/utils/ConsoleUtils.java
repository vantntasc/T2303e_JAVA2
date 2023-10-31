package org.aptech.t2303e.utils;

import java.util.Scanner;

public class ConsoleUtils {
    public static int getInt(Integer minValue , Integer maxValue){  // same name  , same output type  , different input\
        // overloading
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        int n = 0;
        while (!valid){
            System.out.println("");
            try {
                n = scanner.nextInt();
                valid = true;
                if (minValue != null) {  // only run here pass minValue  != null
                    if (n < minValue) {
                        System.out.println("Not in valid arrange ,please try again!");
                        valid = false;
                    }
                }
                if (maxValue != null) {  // only run here pass minValue  != null
                    if (n > maxValue) {
                        System.out.println("Not in valid arrange ,please try again!");
                        valid = false;
                    }
                }
            } catch (Exception ex){
                // throw exception here
                scanner.nextLine();
            }
        }
        return n;
    }
    public static int getInt(int minValue , int maxValue){  // same name  , same output type  , different input
        // overloading
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        int n = 0;
        while (!valid){
            System.out.println("");
            try {
                n = scanner.nextInt();
                if( n < minValue || n > maxValue){
                    System.out.println("Not in valid arrange ,please try again!");
                }else{
                    valid = true;
                }
            } catch (Exception ex){
                // throw exception here
                scanner.nextLine();
            }
        }
        return n;
    }
    public static int getInt(){
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        int n = 0;
        while (!valid){
            System.out.println("");
            try {
                n = scanner.nextInt();
                valid = true;
            } catch (Exception ex){
                // throw exception here
                scanner.nextLine();
            }
        }
        return n;
    }
}
