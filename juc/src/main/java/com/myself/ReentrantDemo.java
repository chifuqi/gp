package com.myself;

/**
 * @ClassName ReentrantDemo
 * @Description TODO
 * @Author 郗富琦
 * @Date 2019/6/3 21:04
 * @Version 1.0
 * @copyright: Copyright(c) 2019 Uzone Co. Ltd. All rights resrved.
 **/
public class ReentrantDemo {
    public synchronized void demo(){
        System.out.println("begin:demo");
        demo2();
    }

    private void demo2() {

        synchronized (this){
            System.out.println("begin:demo1");
        }
    }

    public static void main(String[] args) {
        ReentrantDemo rd = new ReentrantDemo();
        new Thread(rd::demo).start();
    }
}
