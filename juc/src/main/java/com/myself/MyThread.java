package com.myself;

/**
 * @ClassName MyThread
 * @Description TODO
 * @Author 郗富琦
 * @Date 2019/6/4 17:05
 * @Version 1.0
 * @copyright: Copyright(c) 2019 Uzone Co. Ltd. All rights resrved.
 **/
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("mythread.run:" + Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        thread1.start();
        thread2.start();

        System.out.println("main thread:" + Thread.currentThread().getId());
    }
}
