package com.example.threadTest;

import java.util.LinkedList;

public class MyblockingQueue {

    //queue容量
    private final int MAX_SIZE = 100;
    private LinkedList list = new LinkedList();

    public void put(int num) {
        //同步
        synchronized (list) {
            //仓库剩余的容量不足以存放即将要生产的数量，暂停生产
            while (list.size() + num > MAX_SIZE) {
                System.out.println("装不下了！");
                try {
                    //条件不满足，生产阻塞，解锁，让出cpu
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < num; i++) {
                list.add(new Object());
            }
            System.out.println("新品上架了！可以拿了");
            list.notifyAll();
        }
    }


    public void get(int num) {
        synchronized (list) {

            //不满足消费条件
            while (num > list.size()) {
                System.out.println("没库存了!");
                try {
                    list.wait();//阻塞，解锁，让出cpu
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //消费条件满足，开始消费
            for (int i = 0; i < num; i++) {
                list.remove();
            }
            System.out.println("有空地儿了，继续生产吧！");
            list.notifyAll();
        }
    }
}

