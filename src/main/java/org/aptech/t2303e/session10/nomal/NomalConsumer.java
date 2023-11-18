package org.aptech.t2303e.session10.nomal;

import java.util.Queue;

public class NomalConsumer implements Runnable{
    private final Queue<Integer> queue;

    public NomalConsumer(Queue<Integer> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        while (true){
            try {
                queue.remove();
                Thread.sleep(200);
                System.err.println("Queue size = "+ queue.size());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // 1000 ms  : producer add 20 element  , consumer get 100 element
        }
    }
}
