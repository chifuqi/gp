package com.chifuqi;

import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * @ClassName RpcProxyClient
 * @Description TODO
 * @Author 郗富琦
 * @Date 2019/6/9 11:32
 * @Version 1.0
 * @copyright: Copyright(c) 2019 Uzone Co. Ltd. All rights resrved.
 **/
@Component
public class RpcProxyClient {
    public <T> T clientProxy(final Class<?> clazz,
                             final String host,
                             final int port)
    {
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(),
                new Class<?>[]{clazz},
                new RemoteInvocationHandler(host, port));
    }
}
