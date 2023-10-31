package org.aptech.t2303e.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

    public static final String alpha =  "abcdefghijklmnopqrstuvwxyz";
    public static final String alphaUpperCase =  alpha.toUpperCase();
    public  static final String digits = "0123456789";

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
