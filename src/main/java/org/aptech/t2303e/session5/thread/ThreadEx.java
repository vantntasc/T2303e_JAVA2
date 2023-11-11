package org.aptech.t2303e.session5.thread;

public class ThreadEx extends Thread {
    public void run(){ // only run
        System.err.println("Thread is running");
    }

    public static void main(String[] args) {
        ThreadEx t = new ThreadEx();
        t.start(); // cấp phát tài nguyên  + run.
    }
}
