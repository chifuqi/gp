package com.chifuqi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    @Autowired
    RpcProxyClient rpcProxyClient;
    public static void main( String[] args )
    {
        ApplicationContext context =new AnnotationConfigApplicationContext(SpringConfig.class);

        RpcProxyClient rpcProxyClient = context.getBean(RpcProxyClient.class);
        IHelloService helloService =
        (IHelloService)rpcProxyClient.clientProxy(IHelloService.class, "localhost", 8080);
        String res = helloService.sayHello("my name is nicholas 哈哈哈哈");
        System.out.println(res);
    }
}
