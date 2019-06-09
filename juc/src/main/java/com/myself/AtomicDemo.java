package com.myself;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName AtomicDemo
 * @Description TODO
 * @Author 郗富琦
 * @Date 2019/6/3 21:39
 * @Version 1.0
 * @copyright: Copyright(c) 2019 Uzone Co. Ltd. All rights resrved.
 **/
public class AtomicDemo {
    private static int count = 0;
    static Lock lock = new ReentrantLock();
    public static void inc(){
        lock.lock();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{AtomicDemo.inc();}).start();
        }
        Thread.sleep(3000);
        System.out.println("result:" + count);
    }
}
