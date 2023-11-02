package org.aptech.t2303e.utils;

import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils {
    public static int getAge(Date date){
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(new Date());
        if(date.after(new Date())){
            return -1; // error.
        }
        return calendar2.get(Calendar.YEAR)
                - calendar1.get(Calendar.YEAR) + 1;
    }

    public static String randomDateOfBirth(){
        int year  = NumberUtils.randomNumber(1900, 2007);
        int month  = NumberUtils.randomNumber(1,12);
        int day =  NumberUtils.randomNumber(1,28);
        return year+"-"+NumberUtils.converNum(month)+"-"+NumberUtils.converNum(day);
    }
}
