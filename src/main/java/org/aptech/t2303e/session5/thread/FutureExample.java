package org.aptech.t2303e.session5.thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) {
       HashMap<String,String> hashMap = new HashMap<>();
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
       synchronized (hashMap){
           // do something with hashmap
       }
        List<Future<Integer>> ls  = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Callable<Integer> callable;
        Random random = new Random();
        Future<Integer> future;
        for(int i  = 1 ; i <= 10 ; i++){
            callable = new IntCallbale(i ,random);
            future = executorService.submit(callable);  // return result but in future
            ls.add(future);
        }
        executorService.shutdown();
        // wait all thread done
        while (!executorService.isTerminated()){
        }
        for(Future<Integer> f : ls){
            try {
                Integer num = f.get();
                System.err.println(num);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
