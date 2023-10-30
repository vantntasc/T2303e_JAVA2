package org.aptech.t2303e.lombok;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private long id;
    private String name;
    private Date dateOfBirth;
    private String address;
    private String tel;
    public static Student convert(DateFormat dateFormat,String header,String line) throws ParseException {
        // test string empty
        if(StringUtils.isEmpty(line)) return null;
        if(line.trim().equalsIgnoreCase(header)) return null;
        String[] chars = line.split("\\|");
        return Student.builder()
                .id(Long.valueOf(chars[0]))
                .name(chars[1])
                .address(chars[2])
                .dateOfBirth(dateFormat.parse(chars[3]))
                .build();
    }
}
