package com.chifuqi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName SpringConfig
 * @Description TODO
 * @Author 郗富琦
 * @Date 2019/6/9 11:29
 * @Version 1.0
 * @copyright: Copyright(c) 2019 Uzone Co. Ltd. All rights resrved.
 **/
@ComponentScan(value = "com.chifuqi")
@Configuration
public class SpringConfig {
    /*@Bean(name = "rpcProxyClient")
    public RpcProxyClient rpcProxyClient()
    {
        return new RpcProxyClient();
    }*/
}
