package org.aptech.t2303e;

import org.aptech.t2303e.lombok.Student;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
//        Student s = new Student();
//        s.setName("John Doe");
//        s.setTel("2432532532");
//        s.setAddress("24335323");
//        s.setDateOfBirth(new Date());
//        s.setStudentId("35433g");
//        System.err.println(s);
        Student s1 = Student.builder()
                            .name("John Doe")
                            .tel("242342")
                            .address("42423")
                            .dateOfBirth(new Date())
                            .build();
        System.err.println(s1);
    }
}