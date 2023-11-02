package org.aptech.t2303e.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

    public static final String alpha =  "abcdefghijklmnopqrstuvwxyz";
    public static final String alphaUpperCase =  alpha.toUpperCase();
    public  static final String digits = "0123456789";

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.err.println(randomMsisdn());
        }
    }
    public static String randomMsisdn(){
        String prefix = "84"; // 9/10
        int max = 9;
        if(NumberUtils.randomNumber(0,1) == 1) max = 10;
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        for(int i = 0 ; i < max; i++){
            int num  = NumberUtils.randomNumber(0,9);
            char ch = digits.charAt(num);
            sb.append(ch);
        }
        return sb.toString();
    }
    public static String randomAlphaNumeric(int numberCharacter){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberCharacter ; i++) {
            int num = NumberUtils.randomNumber(0,alpha.length() -1);
            char ch = alpha.charAt(num);
            sb.append(ch);
        }
        return  sb.toString();
    }
    public static List<String> getBatchStudent(List<String> students , int offset , int limit){
        if(students == null){
            students = new ArrayList<>();
        }
        return  students.stream().skip(offset).limit(limit).collect(Collectors.toList());
    }

}
