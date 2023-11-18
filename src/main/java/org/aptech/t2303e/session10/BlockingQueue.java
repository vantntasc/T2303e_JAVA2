package org.aptech.t2303e.session10;

import java.util.LinkedList;

public class BlockingQueue<T> {
    private static final int capacity = 10;
    private final LinkedList<T> ls = new LinkedList<>();

    // đảm bảo thread-safe (concurentcy) -> synchronized
    public synchronized void put(T value) throws InterruptedException {
        while (ls.size() == capacity){
            System.err.println("Blocking queue is full size");
            // wait
            wait();
        }
        // ls.size < 10
        ls.addLast(value); // add in last index
        notifyAll();
    }
    // khi nào cần đồng bộ hóa thread  -> synchronized / ko dc lạm dụng
    public synchronized  T take() throws InterruptedException {
        while (ls.size() == 0 ){
            System.err.println("Blocking queue is no element");
            // wait
            wait();
        }
        notifyAll();
        return ls.removeFirst(); // remove in first index
    }

    public synchronized int size(){
        return ls.size();
    }

}
