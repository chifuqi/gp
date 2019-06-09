package com.myself.chain;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName PrintProcessor
 * @Description TODO
 * @Author 郗富琦
 * @Date 2019/6/4 17:28
 * @Version 1.0
 * @copyright: Copyright(c) 2019 Uzone Co. Ltd. All rights resrved.
 **/
public class PrintProcessor extends Thread implements RequestProcessor {
    private LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<>();
    private final RequestProcessor nextProcessor;

    public PrintProcessor(RequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    @Override
    public void run() {
        while (true){
            Request request = null;
            try {
                request = requests.take();
                System.out.println("print data:" + request.getName());
                System.out.println("thread id:" + Thread.currentThread().getId());
                nextProcessor.processRequest(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    @Override
    public void processRequest(Request request) {
        requests.add(request);
    }
}
