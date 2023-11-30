package org.aptech.t2303e.session10;

public class Consumer implements Runnable{
    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                queue.take();
                Thread.sleep(200);
                System.err.println("Queue size = "+ queue.size());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // 1000 ms  : producer add 20 element  , consumer get 100 element
        }
    }
}
