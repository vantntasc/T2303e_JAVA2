package org.aptech.t2303e.session5.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RunableEx implements Runnable {
    private String threadName;
    public Integer num;

    public RunableEx(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.err.println("Thread" + threadName +" is running");
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Random random = new  Random();
        this.num = random.nextInt();
        System.err.println("Num random in thread "+ threadName + " is  :"+ num);
    }

    public static void main(String[] args) throws InterruptedException {
//        RunableEx runableEx = new RunableEx();
//        Thread  t1 = new Thread(runableEx);
//        t1.start();
//        Thread  t2 = new Thread(runableEx);
//        t2.start();
        long startTime = System.currentTimeMillis();
        // single thread
//        for (int i = 0; i < 4; i++) {
//            Thread.sleep(50);
//        }
//        System.err.println("Time process in single thread : "
//                +(System.currentTimeMillis() - startTime) + " ms");
        // multi thread
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            RunableEx runableEx = new RunableEx("thread" + (i + 1));
            Thread t = new Thread(runableEx);
            t.start();
            t.join();
            nums.add(runableEx.num);
        }
        System.out.println("Time process in multi thread : "
                + (System.currentTimeMillis() - startTime) + " ms");
        System.out.println("nums :  "+ nums);
    }
}
