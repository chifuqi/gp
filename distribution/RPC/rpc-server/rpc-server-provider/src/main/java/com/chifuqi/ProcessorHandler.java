package com.chifuqi;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Map;

/**
 * @ClassName ProcessorHandler
 * @Description TODO
 * @Author 郗富琦
 * @Date 2019/6/8 19:51
 * @Version 1.0
 * @copyright: Copyright(c) 2019 Uzone Co. Ltd. All rights resrved.
 **/
public class ProcessorHandler implements Runnable {
    private final Socket socket;
    private final Map<String, Object> handlerMap;

    public ProcessorHandler(Socket socket, Map<String, Object> handlerMap) {
        this.socket = socket;
        this.handlerMap = handlerMap;
    }

    @Override
    public void run() {
        //反射
        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;
        try {
            inputStream = new ObjectInputStream(socket.getInputStream());
            RpcRequest rpcRequest = (RpcRequest)inputStream.readObject();
            Object result = invoke(rpcRequest);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(result);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private Object invoke(RpcRequest rpcRequest) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String serviceName = rpcRequest.getClassName();
        Class<?> clazz = Class.forName(serviceName);
        Class<?>[] parms = null;
        Object[] objects =  rpcRequest.getParameters();
        if (objects!=null && objects.length > 0)
        {
            parms = new Class[objects.length];
            for (int i = 0; i < objects.length; i++) {
                parms[i] = objects[i].getClass();
            }
        }
        Method method = clazz.getMethod(rpcRequest.getMehtodName(), parms);
        Object service = handlerMap.get(serviceName);
        if (service == null){
            throw new RuntimeException("service not found:" + serviceName);
        }
        Object result = method.invoke(service, rpcRequest.getParameters());
        return  result;
    }
}
