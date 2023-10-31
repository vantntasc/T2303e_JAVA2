package org.aptech.t2303e.session2.map;

import org.aptech.t2303e.lombok.Student;
import org.aptech.t2303e.utils.StringUtils;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        listConvert();
    }
    public  static void lab1(){
        // init map : Integer (key dataType), String (value datatype)
        Map<Integer, String> mapDemo = new HashMap<>();
        // add to map
        mapDemo.put( 1 ,"VINFAST");
        mapDemo.put( 1 ,"BMW");
        mapDemo.put( 2 ,"SANTAFEE");
        mapDemo.put( 3 ,"VIOS");
        // FOREACH by KEY
        for( Integer key : mapDemo.keySet()){
            System.err.println("Value with key = "+key + " is  :"+mapDemo.get(key));
        }
        //  FOREACH BY ENTRY - mean (key , value)
        for(Map.Entry<Integer, String> entry : mapDemo.entrySet()){
            Integer key  = entry.getKey();
            String value  = entry.getValue();
            System.err.println("Value with key = "+key + " is  :"+value);
        }
        // LAMBDA
        mapDemo.entrySet().stream().forEach(entry  -> {
            System.err.println("Value with key = "+entry.getKey() + " is  :"+entry.getValue());
        });
        mapDemo.clear(); // clear all element
        mapDemo.size();  // sizing map
    }
    public static void listConvert(){
        // tạo 1  hashmap lưu danh sách 100 học sinh random với khóa là id học sinh
        Map<String, Student> studentMap = new HashMap<>();
        // foreach 100 -> init random student  -> put to hashmap
        for (int i = 0; i < 99 ; i++) {
            Student s = new Student();
            s.setId(i);
            s.setName(StringUtils.randomAlphaNumeric(30));
            s.setAddress(StringUtils.randomAlphaNumeric(500));
            s.setTel(UUID.randomUUID().toString());
            Student s1 = Student.builder()
                        .id(i)
                        .name(StringUtils.randomAlphaNumeric(30))
                        .address(StringUtils.randomAlphaNumeric(500))
                        .tel(UUID.randomUUID().toString())
                        .build();
            studentMap.put(String.valueOf(s.getId()) + s.getName(),s);
        }
        studentMap.keySet().stream().forEach(key -> {
            System.err.println("key : " + key + " , value  : "+ studentMap.get(key));
        });
        // get list key :
        Set<String> keySet = studentMap.keySet();
        List<String> keys = new ArrayList<>(keySet); // get list key of hashmap
        System.err.println("All key of hashmap : ");
        for (String key  : keys){
            System.err.println(key);
        }
        keys.forEach(System.err::println);
        // get list value
        Collection<Student> valueSet  = studentMap.values();
        List<Student> studentList  =  new ArrayList<>(valueSet);
        studentList.forEach(System.err::println);
    }
}
