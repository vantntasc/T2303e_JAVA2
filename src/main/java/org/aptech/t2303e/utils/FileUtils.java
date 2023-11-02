package org.aptech.t2303e.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class FileUtils {
    public static final String  HEADER_CONTENT  = "ID|CARDTYPE|NAME|CARDNO|IDCARD|MSISDN|ADDRESS|DATEOFBIRTH";
    public static final List<String> CARD_TYPES = Arrays.asList("VISA", "JCB" , "HYBRID"); // can random
    public static final String SEPARATOR = "|";
    public static void main(String[] args) {
        createBankAccountSimulator("./etc/BankAccount_01.txt", 10000);
    }
    static String randomCardType(){
        // get random Card_Type
        return CARD_TYPES.get(NumberUtils.randomNumber(0,2));
    }
    static String randomCardNo(){
        return String.valueOf(System.currentTimeMillis());
    }
    static String randomIdCard(){
        return String.valueOf(System.currentTimeMillis());
    }
    // num : number user in file
    public static void createBankAccountSimulator(String filename, int num){
        PrintWriter out = null;
        try {
            out  = new PrintWriter(new BufferedWriter(
                    new FileWriter(filename,true)));
            out.println(HEADER_CONTENT);
            for (int i = 0; i < num ; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(i + 1)
                        .append(SEPARATOR)
                        .append(randomCardType())
                        .append(SEPARATOR)
                        .append(StringUtils.randomAlphaNumeric(8))
                        .append(SEPARATOR)
                        .append(randomCardNo())
                        .append(SEPARATOR)
                        .append(randomIdCard())
                        .append(SEPARATOR)
                        .append(StringUtils.randomMsisdn())
                        .append(SEPARATOR)
                        .append(StringUtils.randomAlphaNumeric(8))
                        .append(SEPARATOR)
                        .append(DateTimeUtils.randomDateOfBirth());
                out.println(sb.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(out != null){
                out.close();
            }
        }
    }
}
