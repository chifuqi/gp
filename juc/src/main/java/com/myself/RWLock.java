package com.myself;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName RWLock
 * @Description TODO
 * @Author 郗富琦
 * @Date 2019/5/19 11:47
 * @Version 1.0
 * @copyright: Copyright(c) 2019 Uzone Co. Ltd. All rights resrved.
 **/
public class RWLock {

    //读->读可同享
    //读->写互斥
    //写->写互斥
    //使用读多写少的场景
    static ReentrantReadWriteLock wrl = new ReentrantReadWriteLock();

    static Map<String, Object> cacheMap = new HashMap<>();

    static Lock read = wrl.readLock();
    static Lock write = wrl.writeLock();

    public static  final Object get(String key){
        System.out.println("begin read data:" + key);
        read.lock();
        try {Thread.yield();
            return cacheMap.get(key);
        }finally {
            read.unlock();
        }
    }

    public static final Object put(String key, Object value){
        System.out.println("begin write data: " + key);
        write.lock();
        try {
            return put(key, value);
        }finally {
            write.unlock();
        }
    }

    public static void main(String[] args) {

    }
}
