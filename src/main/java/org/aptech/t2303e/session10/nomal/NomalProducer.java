package org.aptech.t2303e.session10.nomal;

import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class NomalProducer implements Runnable {
    private final Queue<Integer> queue;

    public NomalProducer(Queue<Integer> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(200);
                int num  = ThreadLocalRandom.current().nextInt();
                queue.add(num);
                System.err.println("Queue size = "+ queue.size());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
