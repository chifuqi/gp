package com.chifuqi;

/**
 * @ClassName HelloServiceImpl
 * @Description TODO
 * @Author 郗富琦
 * @Date 2019/6/8 19:06
 * @Version 1.0
 * @copyright: Copyright(c) 2019 Uzone Co. Ltd. All rights resrved.
 **/
@RpcService(value = IHelloService.class)
public class HelloServiceImpl implements IHelloService {
    @Override
    public String sayHello(String context) {
        return "response:" + context;
    }

    @Override
    public String saveUser(User user) {
        return "response:" + user;
    }
}
