package com.myself;

import jdk.net.Sockets;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/**
 * @ClassName ThreadStatus
 * @Description TODO
 * @Author 郗富琦
 * @Date 2019/6/5 9:54
 * @Version 1.0
 * @copyright: Copyright(c) 2019 Uzone Co. Ltd. All rights resrved.
 **/
public class ThreadStatus {
    public static void main(String[] args) throws InterruptedException, IOException {

        ServerSocket server = new ServerSocket(8080);

        new Thread(()->{
            try {
                server.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, "io").start();

        Thread timedWaitingThread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (ThreadStatus.class) {
                System.out.println("notify start");
                ThreadStatus.class.notifyAll();
                System.out.println("notify end");
            }
        }, "timed-waiting");
        timedWaitingThread.start();

        Thread waitingThread = new Thread(() -> {
            synchronized (ThreadStatus.class) {
                try {
                    System.out.println("wait start");
                    ThreadStatus.class.wait(1000000);
                    System.out.println("wait end");
                    System.out.println("synchronized start");
                    synchronized (BlockedDemo.class) {
                        try {
                            TimeUnit.SECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("synchronized stop");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "waiting");
        waitingThread.start();
        Thread.currentThread().setName("main_thread");


        new Thread(new BlockedDemo(), "BlockDemo-01").start();
        new Thread(new BlockedDemo(), "BlockDemo-02").start();

        timedWaitingThread.join();
        waitingThread.join();


    }

    static class BlockedDemo extends Thread {

        @Override
        public void run() {
            synchronized (BlockedDemo.class) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class NIOBlocked implements Runnable {
        private final SocketChannel sc;

        public NIOBlocked(SocketChannel sc) {
            this.sc = sc;
        }

        @Override
        public void run() {
            try {
                System.out.println("Waiting for read() in " + this);
                sc.read(ByteBuffer.allocate(1));
            } catch (ClosedByInterruptException e) {
                System.out.println("ClosedByInterruptException");
            } catch (AsynchronousCloseException e) {
                System.out.println("AsynchronousCloseException");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Exiting NIOBlocked.run() " + this);
        }

    }
}
