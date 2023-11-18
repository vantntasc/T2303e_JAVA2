package org.aptech.t2303e.session10;

import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueuDemo {
    public static void main(String[] args) {
//        Queue<String> names  = new LinkedList<>();
//        /** queue **/
//        // add | offer : if failed -> add return false , offer throw exception
//        names.offer("A"); // add element to queue (in last position), return boolean
//        names.offer("B");
//        names.offer("B");
//        names.add("C");
//        names.add("D");
        // poll | remove :  if failed -> poll return null , remove throw exception
//        while (true){
//            String name  = names.poll();
//            if(StringUtils.isEmpty(name)) continue;
//            System.err.println(name);
//        }
        //Priority queue :
        Queue<String> names  = new PriorityQueue<>();
        names.offer("X");
        names.offer("A");
        names.offer("B");
        names.offer("Z");
        names.offer("K");
        names.offer("1");
        while (true){
            String name  = names.poll();
            if(StringUtils.isEmpty(name)) break;
            System.err.println("name :" + name);
        }




    }
}
