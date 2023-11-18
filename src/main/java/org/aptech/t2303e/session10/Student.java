package org.aptech.t2303e.session10;

import lombok.Builder;
import lombok.Data;

import java.rmi.ServerError;
import java.util.PriorityQueue;
import java.util.Queue;

//@Data
//@Builder
public class Student  implements   Comparable<Student>{
    private int id;
    private String name;
    private String address;
    private int age;

    public Student(int id, String name,int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

//    @Override
//    public int compareTo(Student s) {
//        // compare student with instance o and this student
//        if(this.id > s.id){
//            return 1;
//        } else if(this.id < s.id){
//            return -1;
//        } else {
//            return 0;
//        }
//
//    }
//        @Override
//        public int compareTo(Student s) {
//            if ( this.age > 6 && this.age < 60) {
//                return 1;
//            } else if (this.age > s.age) {
//                return 1;
//            } else if (this.age < s.age) {
//                return -1;
//            } else {
//                return 0;
//            }
//        }
    /** Đầu bài  : sắp xếp hàng đợi 1 danh sách người
        ưu tiên theo thứ tự  : <= 6 , >= 60 , 6< and < 60 , nếu cùng nhóm ưu tiên
        thi ai đến trc đứng trc
     **/
    /**
        -> Chủ động sắp xếp người vào 3 nhóm trên , cùng nhom thì giữ nguyên
     */
    private static final int AGE_LEVEL1 = 6;
    private static final int AGE_LEVEL2 = 60;
    private static final int PRIO_LEVEL1 = 1;
    private static final int PRIO_LEVEL2 = 2;
    private static final int PRIO_LEVEL3 = 3;
    static int getPriorityLevel(int age){
        if(age <= AGE_LEVEL1){
            return PRIO_LEVEL1;
        } else if(age >= AGE_LEVEL2){
           return PRIO_LEVEL2;
        } else {
            return PRIO_LEVEL3;
        }
    }
    @Override
    public int compareTo(Student s){
        int thisPrio = getPriorityLevel(this.age);
        int sPrio = getPriorityLevel(s.age);
        if(thisPrio > sPrio){
            return 1;
        } else if(thisPrio < sPrio){
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
    // sắp xếp danh sách này theo thứ tự như sau  :
//       1 : ưu tiên trẻ dưới 6 tuổi -> người già trên 60 tuổi
   // -> người trong độ tuổi t 6 -> 60 giữ nguyên thứ tự .
    public static void main(String[] args) {
        // 1,4,3,60,40,14
        Queue<Student> students = new PriorityQueue<>();
        students.add(new Student(154,"A",60));
        students.add(new Student(155,"Z",1));
        students.add(new Student(154,"M",40));
        students.add(new Student(111,"B",14));
        students.add(new Student(13,"C",4));
        students.add(new Student(1242,"D",3));
        for (Student s : students){
            System.err.println(s);
        }
        System.err.println("Value after remove element");
        System.err.println(students.poll());
        System.err.println(students.poll());
        System.err.println(students.poll());
        System.err.println(students.poll());
        System.err.println(students.poll());
        System.err.println(students.poll());
    }
}
