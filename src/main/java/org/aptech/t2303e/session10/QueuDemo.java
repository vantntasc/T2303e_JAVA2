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

        // không thể thêm data vào 1 queue đã đầy .
        // không thể lấy data từ 1 cái queue bị rỗng .
        // problem :
        /*
        1. nếu lấy ra hay thêm vào bộ đệm thất bại
        -> khi nào chúng ta có thể biết là có thể thực hien lai
        2. xử lý như thế nào trong môi trường đa luồng
         */
        // BlockingQueue
        /*
        1. Với consumer , nếu queue trống -> consumer rơi vào trạng thái
           waiting ,lần đầu tiên sau đó mà producer them data
           vao hàng đợi -> notify consumer dậy và thực hiện luồng lấy dữ liệu
           ra như bt
         2. Với producer , nếu queue đầy -> producer rơi vào trạng thái
           waiting ,lần đầu tiên sau đó mà consumer lay data
           ra khỏi hàng đợi -> notify producer dậy và thực hiện luồng đẩy  dữ liệu
           vào hàng đợi như bt
         3. đảm bảo luồng an toàn
         */


    }
}
