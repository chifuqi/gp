package com.chifuqi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SpringConfig
 * @Description TODO
 * @Author 郗富琦
 * @Date 2019/6/8 19:19
 * @Version 1.0
 * @copyright: Copyright(c) 2019 Uzone Co. Ltd. All rights resrved.
 **/
@Configuration
@ComponentScan(value = "com.chifuqi")
public class SpringConfig {
    @Bean(name = "rpcServerAnnotation")
    public RpcServerAnnotation rpcServerAnnotation(){
        System.out.println("rpcServerAnnotation Bean create");
        return new RpcServerAnnotation(8080);
    }
}
