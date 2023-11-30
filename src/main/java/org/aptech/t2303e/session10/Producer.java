package org.aptech.t2303e.session10;

import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable{
    private final BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(200);
                int num  = ThreadLocalRandom.current().nextInt();
                queue.put(num);
                System.err.println("Queue size = "+ queue.size());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
