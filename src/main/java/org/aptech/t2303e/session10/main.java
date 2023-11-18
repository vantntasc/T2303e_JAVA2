package org.aptech.t2303e.session10;

public class main {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new BlockingQueue<>();
        Producer producer = new Producer(queue);
        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);
        Consumer consumer4 = new Consumer(queue);
        new Thread(producer).start();
        new Thread(producer1).start();
        new Thread(producer2).start();
        new Thread(producer3).start();
        new Thread(consumer4).start();
    }
}
