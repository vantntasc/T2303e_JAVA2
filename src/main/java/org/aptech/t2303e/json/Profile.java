package org.aptech.t2303e.json;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Profile {
    private String job;
    private long salary;

//    public String getJob() {
//        return job;
//    }
//
//    public void setJob(String job) {
//        this.job = job;
//    }
//
//    public long getSalary() {
//        return salary;
//    }
//
//    public void setSalary(long salary) {
//        this.salary = salary;
//    }
}
