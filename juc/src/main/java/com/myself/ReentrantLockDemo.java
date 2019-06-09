package com.myself;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ReentrantLockDemo
 * @Description TODO
 * @Author 郗富琦
 * @Date 2019/5/19 11:41
 * @Version 1.0
 * @copyright: Copyright(c) 2019 Uzone Co. Ltd. All rights resrved.
 **/
public class ReentrantLockDemo {
    private Lock lock = new ReentrantLock();
    public void demo(){
        lock.lock();
        System.out.println("demo");
        demo2();
        lock.unlock();
    }

    private void demo2() {
        lock.lock();
        System.out.println("demo2");
        lock.unlock();
    }

    public static void main( String[] args )
    {
        App app = new App();
        app.demo();
    }
}
