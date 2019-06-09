package com.myself.chain;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName Main
 * @Description TODO
 * @Author 郗富琦
 * @Date 2019/6/4 17:34
 * @Version 1.0
 * @copyright: Copyright(c) 2019 Uzone Co. Ltd. All rights resrved.
 **/
public class Main {
    PrintProcessor printProcessor;
    SaveProcessor saveProcessor;
    public Main() {
        saveProcessor=new SaveProcessor();
        saveProcessor.start();
        printProcessor=new PrintProcessor(saveProcessor);
        printProcessor.start();
    }

    private void doTest(Request request){
        printProcessor.processRequest(request);
    }

    private void interrupt()
    {
        printProcessor.interrupt();
        saveProcessor.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        Request request=new Request();
        request.setName("Mic");
        Main m = new Main();
        m.doTest(request);

        TimeUnit.SECONDS.sleep(2);
        m.interrupt();
    }
}
