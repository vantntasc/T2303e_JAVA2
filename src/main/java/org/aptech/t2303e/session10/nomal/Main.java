package org.aptech.t2303e.session10.nomal;


import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        NomalProducer producer = new NomalProducer(queue);
        NomalProducer producer1 = new NomalProducer(queue);
        NomalProducer producer2 = new NomalProducer(queue);
        NomalProducer producer3 = new NomalProducer(queue);
        NomalConsumer consumer4 = new NomalConsumer(queue);
        new Thread(producer).start();
        new Thread(producer1).start();
        new Thread(producer2).start();
        new Thread(producer3).start();
        new Thread(consumer4).start();
    }
}
