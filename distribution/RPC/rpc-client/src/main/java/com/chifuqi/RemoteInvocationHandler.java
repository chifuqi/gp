package com.chifuqi;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @ClassName RemoteInvocationHandler
 * @Description TODO
 * @Author 郗富琦
 * @Date 2019/6/9 11:38
 * @Version 1.0
 * @copyright: Copyright(c) 2019 Uzone Co. Ltd. All rights resrved.
 **/
public class RemoteInvocationHandler implements InvocationHandler {
    private final String host;
    private final int port;

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMehtodName(method.getName());
        rpcRequest.setParameters(args);
        rpcRequest.setVersion("V2.0");

        RpcNetTransport rpcNetTransport = new RpcNetTransport(host, port);
        return rpcNetTransport.send(rpcRequest);
    }


}
